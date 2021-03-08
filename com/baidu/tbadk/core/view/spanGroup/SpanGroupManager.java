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
    private SpanGroupEditText fpF;
    private a.InterfaceC0571a fpx;
    private BdUniqueId mBdUniqueId;
    private TextWatcher fpE = new TextWatcher() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.1
        private int fpK = -1;
        private int fpL = -1;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.fpK = Selection.getSelectionStart(charSequence);
            this.fpL = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager.this.a(SpanGroupManager.this.fpG, this.fpK, this.fpL, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.bvi();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.bvk();
        }
    };
    private LinkedList<a> fpG = new LinkedList<>();
    private boolean fpH = true;
    private com.baidu.adp.framework.listener.a fpI = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.2
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
                dVar.eOm = str;
                SpanGroupManager.this.a(dVar, i);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fpJ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.3
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
                    next.pX(next.getStart() + i3);
                    next.pY(next.getEnd() + i3);
                } else if (i <= next.getStart() && i2 > next.getStart()) {
                    next.setValid(false);
                } else if (i > next.getStart() && i < next.getEnd() && i2 < next.getEnd()) {
                    next.pY(next.getEnd() + i3);
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
            this.fpF = spanGroupEditText;
            this.fpF.addTextChangedListener(this.fpE);
            this.fpF.setEditableFactory(new b(new c(this)));
            this.fpF.setSoftKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        return SpanGroupManager.this.bvm();
                    }
                    return false;
                }
            });
            this.fpJ.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.fpJ);
            this.fpI.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.fpI);
        }
    }

    public String toString() {
        return bvg();
    }

    public synchronized String bvf() {
        String spannableStringBuilder;
        if (this.fpF == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.fpF.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.fpG.iterator();
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

    public synchronized String bvg() {
        String spannableStringBuilder;
        if (this.fpF == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.fpF.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.fpG.iterator();
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
        this.fpH = z;
    }

    public void bvh() {
        this.fpG.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a qa(int i) {
        Iterator<a> it = this.fpG.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i > next.getStart() && i < next.getEnd()) {
                return next;
            }
        }
        return null;
    }

    public a qb(int i) {
        Iterator<a> it = this.fpG.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i == next.getId()) {
                return next;
            }
        }
        return null;
    }

    public void b(a.InterfaceC0571a interfaceC0571a) {
        this.fpx = interfaceC0571a;
    }

    public boolean isEmpty() {
        return this.fpF == null || this.fpF.getText().length() <= 0;
    }

    public void aZ(int i, int i2) {
        if (!isEmpty() && i <= i2 && i < this.fpF.length()) {
            this.fpF.removeTextChangedListener(this.fpE);
            this.fpF.getText().delete(i, i2);
            a(this.fpG, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            bvi();
            this.fpF.addTextChangedListener(this.fpE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bvi() {
        Iterator<a> it = this.fpG.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
    }

    public synchronized void bvj() {
        com.baidu.tieba.j.a aVar;
        if (this.fpF != null) {
            Editable text = this.fpF.getText();
            Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
            if (matcher.find()) {
                String group = matcher.group();
                String substring = group.substring("#(commodity,commo_".length(), group.length() - "_commo)".length());
                int start = matcher.start();
                int end = matcher.end();
                try {
                    aVar = com.baidu.tieba.j.a.eu(new JSONObject(substring));
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar = null;
                }
                if (aVar != null) {
                    TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                    v a2 = v.a(tbLinkSpanGroup, aVar);
                    tbLinkSpanGroup.a(text, start, end, (int) this.fpF.getTextSize());
                    a2.eOn = substring;
                    tbLinkSpanGroup.BQ(a2.mContent);
                    tbLinkSpanGroup.build();
                    a(this.fpG, end, end, (tbLinkSpanGroup.bvu() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                    tbLinkSpanGroup.a(this.fpx);
                    this.fpG.add(tbLinkSpanGroup);
                }
                bvj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bvk() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.fpF != null && this.fpH) {
            Editable text = this.fpF.getText();
            Matcher matcher = ax.fcN.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end >= 0) {
                    if (b(text, end)) {
                        text.replace(end, end2, " ");
                        bvk();
                    } else {
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.fpF.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (bf.bsY().m(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String Br = bf.bsY().Br(subSequence.toString());
                                tbLinkSpanGroup.setTid(Br);
                                BO(Br);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.fpF.getTextSize());
                            tbLinkSpanGroup.build();
                            tbLinkSpanGroup.a(this.fpx);
                            this.fpG.add(tbLinkSpanGroup);
                        } else if (this.fpF.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.fpF.getTextSize());
                            tbLinkSpanGroup2.build();
                            ax(subSequence.toString(), tbLinkSpanGroup2.getId());
                            tbLinkSpanGroup2.a(this.fpx);
                            this.fpG.add(tbLinkSpanGroup2);
                        }
                        bvk();
                    }
                }
            }
        }
    }

    private void BO(String str) {
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i = 1;
        if (av.bsV().bsW()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mBdUniqueId);
        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(str, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    private void ax(String str, int i) {
        long forumId = this.fpF.getForumId();
        int bvl = bvl() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.mBdUniqueId);
        requestUrlParserNetMessage.setParams(forumId, bvl, str, i);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    private int bvl() {
        int i = 0;
        Iterator<a> it = this.fpG.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).bvt() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
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
        this.fpF.removeTextChangedListener(this.fpE);
        Iterator<a> it = this.fpG.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.bvt() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && au.equals(cbVar.getTid(), tbLinkSpanGroup.getTid())) {
                    String title = cbVar.getTitle();
                    if (au.isEmpty(title)) {
                        title = cbVar.getAbstract();
                    }
                    tbLinkSpanGroup.BQ(title);
                    int start = tbLinkSpanGroup.getStart();
                    int end = tbLinkSpanGroup.getEnd();
                    tbLinkSpanGroup.bvr();
                    a(this.fpG, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                    bvn();
                }
            }
        }
        this.fpF.addTextChangedListener(this.fpE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d dVar, int i) {
        if (dVar != null) {
            if (dVar.mStatus == 1 && dVar.eOu != 3) {
                this.fpF.removeTextChangedListener(this.fpE);
                Iterator<a> it = this.fpG.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.getId() == i && (dVar.eOu == 1 || dVar.eOu == 2)) {
                            tbLinkSpanGroup.BQ(dVar.mTitle);
                            if (dVar.eOu == 1) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.eOu == 2) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            v.a(tbLinkSpanGroup, dVar);
                            if (this.fpx != null) {
                                this.fpx.G(i, true);
                            }
                            int start = tbLinkSpanGroup.getStart();
                            int end = tbLinkSpanGroup.getEnd();
                            tbLinkSpanGroup.bvr();
                            a(this.fpG, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                            bvn();
                        }
                    }
                }
                this.fpF.addTextChangedListener(this.fpE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bvm() {
        int selectionStart;
        if (this.fpF != null && (selectionStart = this.fpF.getSelectionStart()) == this.fpF.getSelectionEnd()) {
            Iterator<a> it = this.fpG.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && next.getEnd() == selectionStart) {
                    Selection.setSelection(this.fpF.getText(), next.getStart(), next.getEnd());
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

    private void bvn() {
        if (!isEmpty()) {
            int selectionStart = Selection.getSelectionStart(this.fpF.getText());
            int selectionEnd = Selection.getSelectionEnd(this.fpF.getText());
            a qa = qa(selectionStart);
            a qa2 = qa(selectionEnd);
            if (qa instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.fpF.getText(), qa.getStart(), qa.getStart());
            } else if (qa2 instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.fpF.getText(), qa2.getStart(), qa2.getStart());
            }
        }
    }

    public LinkedList<a> bvo() {
        return this.fpG;
    }

    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.fpG != null) {
            tbLinkSpanGroup.a(this.fpx);
            this.fpG.add(tbLinkSpanGroup);
        }
    }

    public boolean BP(String str) {
        v bvs;
        if (y.isEmpty(this.fpG) || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<a> it = this.fpG.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.isValid()) {
                return false;
            }
            if ((next instanceof TbLinkSpanGroup) && (bvs = ((TbLinkSpanGroup) next).bvs()) != null && str.equals(bvs.eOs)) {
                return true;
            }
        }
        return false;
    }

    public int bvp() {
        if (y.isEmpty(this.fpG)) {
            return 0;
        }
        Iterator<a> it = this.fpG.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof TbLinkSpanGroup) {
                if (next.isValid()) {
                    v bvs = ((TbLinkSpanGroup) next).bvs();
                    if (bvs != null && bvs.mType == 2) {
                        i++;
                    }
                }
            }
            i = i;
        }
        return i;
    }

    public void bvd() {
        if (this.fpF != null && this.fpE != null) {
            this.fpF.removeTextChangedListener(this.fpE);
        }
    }

    public void bve() {
        if (this.fpF != null && this.fpE != null) {
            this.fpF.addTextChangedListener(this.fpE);
        }
    }
}
