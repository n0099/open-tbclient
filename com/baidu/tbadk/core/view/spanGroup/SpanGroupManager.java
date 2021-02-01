package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.core.view.spanGroup.a;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes.dex */
public class SpanGroupManager {
    private a.InterfaceC0565a fnW;
    private SpanGroupEditText foe;
    private BdUniqueId mBdUniqueId;
    private TextWatcher fod = new TextWatcher() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.1
        private int foj = -1;
        private int fok = -1;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.foj = Selection.getSelectionStart(charSequence);
            this.fok = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager.this.a(SpanGroupManager.this.fof, this.foj, this.fok, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.bvf();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.bvh();
        }
    };
    private LinkedList<a> fof = new LinkedList<>();
    private boolean fog = true;
    private com.baidu.adp.framework.listener.a foh = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UrlParserResIdl responseData;
            String str;
            int i = 0;
            if (responsedMessage instanceof UrlParserHttpResponseMessage) {
                responseData = ((UrlParserHttpResponseMessage) responsedMessage).getResponseData();
            } else {
                responseData = responsedMessage instanceof UrlParserSocketResponseMessage ? ((UrlParserSocketResponseMessage) responsedMessage).getResponseData() : null;
            }
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof RequestUrlParserNetMessage)) {
                str = null;
            } else {
                RequestUrlParserNetMessage requestUrlParserNetMessage = (RequestUrlParserNetMessage) responsedMessage.getOrginalMessage().getExtra();
                String url = requestUrlParserNetMessage.getUrl();
                i = requestUrlParserNetMessage.getSpanGroupId();
                str = url;
            }
            if (responseData != null && responseData.data != null && i != 0) {
                d dVar = new d();
                dVar.a(responseData);
                dVar.eML = str;
                SpanGroupManager.this.a(dVar, i);
            }
        }
    };
    private com.baidu.adp.framework.listener.a foi = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                cb cbVar = new cb();
                cbVar.a(getMyPostResIdl.data.thread_info);
                SpanGroupManager.this.R(cbVar);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum ChangeSpanGroupType {
        DEFAULT,
        ON_TEXT_CHANGE
    }

    synchronized void a(LinkedList<a> linkedList, int i, int i2, int i3, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Iterator<a> it = linkedList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (!z || next.getStart() != i)) {
                if (i <= next.getStart() && i2 <= next.getStart()) {
                    next.pW(next.getStart() + i3);
                    next.pX(next.getEnd() + i3);
                } else if (i <= next.getStart() && i2 > next.getStart()) {
                    next.setValid(false);
                } else if (i > next.getStart() && i < next.getEnd() && i2 < next.getEnd()) {
                    next.pX(next.getEnd() + i3);
                } else if (i > next.getStart() && i < next.getEnd() && i2 >= next.getEnd()) {
                    next.setValid(false);
                } else if (changeSpanGroupType == ChangeSpanGroupType.ON_TEXT_CHANGE && i == i2 && Math.abs(i3) == next.getEnd() - next.getStart() && next.getEnd() <= i2 && next.getEnd() > i2 + i3) {
                    next.setValid(false);
                }
            }
        }
    }

    public SpanGroupManager(@NonNull SpanGroupEditText spanGroupEditText, BdUniqueId bdUniqueId) {
        if (spanGroupEditText != null) {
            this.mBdUniqueId = bdUniqueId;
            this.foe = spanGroupEditText;
            this.foe.addTextChangedListener(this.fod);
            this.foe.setEditableFactory(new b(new c(this)));
            this.foe.setSoftKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        return SpanGroupManager.this.bvj();
                    }
                    return false;
                }
            });
            this.foi.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.foi);
            this.foh.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.foh);
        }
    }

    public String toString() {
        return bvd();
    }

    public synchronized String bvc() {
        String spannableStringBuilder;
        if (this.foe == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.foe.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.fof.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid()) {
                    if (next instanceof TbLinkSpanGroup) {
                        linkedList.add(TbLinkSpanGroup.a((TbLinkSpanGroup) next, spannableStringBuilder2));
                    } else {
                        linkedList.add(next);
                    }
                }
            }
            Iterator<a> it2 = linkedList.iterator();
            int i = 0;
            while (it2.hasNext()) {
                a next2 = it2.next();
                int start = next2.getStart();
                int end = next2.getEnd();
                next2.a(spannableStringBuilder2, i);
                a(linkedList, start, end, (next2.getEnd() - next2.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                i++;
            }
            spannableStringBuilder = spannableStringBuilder2.toString();
        }
        return spannableStringBuilder;
    }

    public synchronized String bvd() {
        String spannableStringBuilder;
        if (this.foe == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.foe.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.fof.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid()) {
                    if (next instanceof TbLinkSpanGroup) {
                        linkedList.add(TbLinkSpanGroup.a((TbLinkSpanGroup) next, spannableStringBuilder2));
                    } else {
                        linkedList.add(next);
                    }
                }
            }
            Iterator<a> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                a next2 = it2.next();
                int start = next2.getStart();
                int end = next2.getEnd();
                next2.b(spannableStringBuilder2);
                a(linkedList, start, end, (next2.getEnd() - next2.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
            }
            spannableStringBuilder = spannableStringBuilder2.toString();
        }
        return spannableStringBuilder;
    }

    public void setTransLink(boolean z) {
        this.fog = z;
    }

    public void bve() {
        this.fof.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a pZ(int i) {
        Iterator<a> it = this.fof.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i > next.getStart() && i < next.getEnd()) {
                return next;
            }
        }
        return null;
    }

    public a qa(int i) {
        Iterator<a> it = this.fof.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i == next.getId()) {
                return next;
            }
        }
        return null;
    }

    public void b(a.InterfaceC0565a interfaceC0565a) {
        this.fnW = interfaceC0565a;
    }

    public boolean isEmpty() {
        return this.foe == null || this.foe.getText().length() <= 0;
    }

    public void aZ(int i, int i2) {
        if (!isEmpty() && i <= i2 && i < this.foe.length()) {
            this.foe.removeTextChangedListener(this.fod);
            this.foe.getText().delete(i, i2);
            a(this.fof, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            bvf();
            this.foe.addTextChangedListener(this.fod);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bvf() {
        Iterator<a> it = this.fof.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
    }

    public synchronized void bvg() {
        com.baidu.tieba.j.a aVar;
        if (this.foe != null) {
            Editable text = this.foe.getText();
            Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
            if (matcher.find()) {
                String group = matcher.group();
                String substring = group.substring("#(commodity,commo_".length(), group.length() - "_commo)".length());
                int start = matcher.start();
                int end = matcher.end();
                try {
                    aVar = com.baidu.tieba.j.a.es(new JSONObject(substring));
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar = null;
                }
                if (aVar != null) {
                    TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                    v a2 = v.a(tbLinkSpanGroup, aVar);
                    tbLinkSpanGroup.a(text, start, end, (int) this.foe.getTextSize());
                    a2.eMM = substring;
                    tbLinkSpanGroup.BJ(a2.mContent);
                    tbLinkSpanGroup.build();
                    a(this.fof, end, end, (tbLinkSpanGroup.bvr() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                    tbLinkSpanGroup.a(this.fnW);
                    this.fof.add(tbLinkSpanGroup);
                }
                bvg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bvh() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.foe != null && this.fog) {
            Editable text = this.foe.getText();
            Matcher matcher = ax.fbn.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end >= 0) {
                    if (b(text, end)) {
                        text.replace(end, end2, " ");
                        bvh();
                    } else {
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.foe.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (bf.bsV().m(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String Bk = bf.bsV().Bk(subSequence.toString());
                                tbLinkSpanGroup.setTid(Bk);
                                BH(Bk);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.foe.getTextSize());
                            tbLinkSpanGroup.build();
                            tbLinkSpanGroup.a(this.fnW);
                            this.fof.add(tbLinkSpanGroup);
                        } else if (this.foe.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.foe.getTextSize());
                            tbLinkSpanGroup2.build();
                            ax(subSequence.toString(), tbLinkSpanGroup2.getId());
                            tbLinkSpanGroup2.a(this.fnW);
                            this.fof.add(tbLinkSpanGroup2);
                        }
                        bvh();
                    }
                }
            }
        }
    }

    private void BH(String str) {
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i = 1;
        if (av.bsS().bsT()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mBdUniqueId);
        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(str, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    private void ax(String str, int i) {
        long forumId = this.foe.getForumId();
        int bvi = bvi() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.mBdUniqueId);
        requestUrlParserNetMessage.setParams(forumId, bvi, str, i);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    private int bvi() {
        int i = 0;
        Iterator<a> it = this.fof.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).bvq() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i2++;
                }
                i = i2;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void R(cb cbVar) {
        this.foe.removeTextChangedListener(this.fod);
        Iterator<a> it = this.fof.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.bvq() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && au.equals(cbVar.getTid(), tbLinkSpanGroup.getTid())) {
                    String title = cbVar.getTitle();
                    if (au.isEmpty(title)) {
                        title = cbVar.getAbstract();
                    }
                    tbLinkSpanGroup.BJ(title);
                    int start = tbLinkSpanGroup.getStart();
                    int end = tbLinkSpanGroup.getEnd();
                    tbLinkSpanGroup.bvo();
                    a(this.fof, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                    bvk();
                }
            }
        }
        this.foe.addTextChangedListener(this.fod);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d dVar, int i) {
        if (dVar != null) {
            if (dVar.mStatus == 1 && dVar.eMT != 3) {
                this.foe.removeTextChangedListener(this.fod);
                Iterator<a> it = this.fof.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.getId() == i && (dVar.eMT == 1 || dVar.eMT == 2)) {
                            tbLinkSpanGroup.BJ(dVar.mTitle);
                            if (dVar.eMT == 1) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.eMT == 2) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            v.a(tbLinkSpanGroup, dVar);
                            if (this.fnW != null) {
                                this.fnW.G(i, true);
                            }
                            int start = tbLinkSpanGroup.getStart();
                            int end = tbLinkSpanGroup.getEnd();
                            tbLinkSpanGroup.bvo();
                            a(this.fof, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                            bvk();
                        }
                    }
                }
                this.foe.addTextChangedListener(this.fod);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvj() {
        int selectionStart;
        if (this.foe != null && (selectionStart = this.foe.getSelectionStart()) == this.foe.getSelectionEnd()) {
            Iterator<a> it = this.fof.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && next.getEnd() == selectionStart) {
                    Selection.setSelection(this.foe.getText(), next.getStart(), next.getEnd());
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean b(CharSequence charSequence, int i) {
        return charSequence != null && charSequence.length() != 0 && i >= 0 && charSequence.charAt(i) == '\n';
    }

    private void bvk() {
        if (!isEmpty()) {
            int selectionStart = Selection.getSelectionStart(this.foe.getText());
            int selectionEnd = Selection.getSelectionEnd(this.foe.getText());
            a pZ = pZ(selectionStart);
            a pZ2 = pZ(selectionEnd);
            if (pZ instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.foe.getText(), pZ.getStart(), pZ.getStart());
            } else if (pZ2 instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.foe.getText(), pZ2.getStart(), pZ2.getStart());
            }
        }
    }

    public LinkedList<a> bvl() {
        return this.fof;
    }

    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.fof != null) {
            tbLinkSpanGroup.a(this.fnW);
            this.fof.add(tbLinkSpanGroup);
        }
    }

    public boolean BI(String str) {
        v bvp;
        if (y.isEmpty(this.fof) || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<a> it = this.fof.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.isValid()) {
                return false;
            }
            if ((next instanceof TbLinkSpanGroup) && (bvp = ((TbLinkSpanGroup) next).bvp()) != null && str.equals(bvp.eMR)) {
                return true;
            }
        }
        return false;
    }

    public int bvm() {
        if (y.isEmpty(this.fof)) {
            return 0;
        }
        Iterator<a> it = this.fof.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof TbLinkSpanGroup) {
                if (next.isValid()) {
                    v bvp = ((TbLinkSpanGroup) next).bvp();
                    if (bvp != null && bvp.mType == 2) {
                        i++;
                    }
                }
            }
            i = i;
        }
        return i;
    }

    public void bva() {
        if (this.foe != null && this.fod != null) {
            this.foe.removeTextChangedListener(this.fod);
        }
    }

    public void bvb() {
        if (this.foe != null && this.fod != null) {
            this.foe.addTextChangedListener(this.fod);
        }
    }
}
