package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.be;
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
    private a.InterfaceC0570a eUl;
    private SpanGroupEditText eUt;
    private BdUniqueId mBdUniqueId;
    private TextWatcher eUs = new TextWatcher() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.1
        private int eUy = -1;
        private int eUz = -1;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.eUy = Selection.getSelectionStart(charSequence);
            this.eUz = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager.this.a(SpanGroupManager.this.eUu, this.eUy, this.eUz, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.bqV();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.bqX();
        }
    };
    private LinkedList<a> eUu = new LinkedList<>();
    private boolean eUv = true;
    private com.baidu.adp.framework.listener.a eUw = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UrlParserResIdl responseData;
            String str;
            int i;
            if (responsedMessage instanceof UrlParserHttpResponseMessage) {
                responseData = ((UrlParserHttpResponseMessage) responsedMessage).getResponseData();
            } else {
                responseData = responsedMessage instanceof UrlParserSocketResponseMessage ? ((UrlParserSocketResponseMessage) responsedMessage).getResponseData() : null;
            }
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof RequestUrlParserNetMessage)) {
                str = null;
                i = 0;
            } else {
                RequestUrlParserNetMessage requestUrlParserNetMessage = (RequestUrlParserNetMessage) responsedMessage.getOrginalMessage().getExtra();
                String url = requestUrlParserNetMessage.getUrl();
                i = requestUrlParserNetMessage.getSpanGroupId();
                str = url;
            }
            if (responseData != null && responseData.data != null && i != 0) {
                d dVar = new d();
                dVar.a(responseData);
                dVar.eul = str;
                SpanGroupManager.this.a(dVar, i);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eUx = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                bw bwVar = new bw();
                bwVar.a(getMyPostResIdl.data.thread_info);
                SpanGroupManager.this.O(bwVar);
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
                    next.setStart(next.getStart() + i3);
                    next.qd(next.getEnd() + i3);
                } else if (i <= next.getStart() && i2 > next.getStart()) {
                    next.setValid(false);
                } else if (i > next.getStart() && i < next.getEnd() && i2 < next.getEnd()) {
                    next.qd(next.getEnd() + i3);
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
            this.eUt = spanGroupEditText;
            this.eUt.addTextChangedListener(this.eUs);
            this.eUt.setEditableFactory(new b(new c(this)));
            this.eUt.setSoftKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        return SpanGroupManager.this.bqZ();
                    }
                    return false;
                }
            });
            this.eUx.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.eUx);
            this.eUw.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.eUw);
        }
    }

    public String toString() {
        return bqT();
    }

    public synchronized String bqS() {
        String spannableStringBuilder;
        if (this.eUt == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.eUt.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.eUu.iterator();
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

    public synchronized String bqT() {
        String spannableStringBuilder;
        if (this.eUt == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.eUt.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.eUu.iterator();
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
                next2.a(spannableStringBuilder2);
                a(linkedList, start, end, (next2.getEnd() - next2.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
            }
            spannableStringBuilder = spannableStringBuilder2.toString();
        }
        return spannableStringBuilder;
    }

    public void setTransLink(boolean z) {
        this.eUv = z;
    }

    public void bqU() {
        this.eUu.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a qf(int i) {
        Iterator<a> it = this.eUu.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i > next.getStart() && i < next.getEnd()) {
                return next;
            }
        }
        return null;
    }

    public a qg(int i) {
        Iterator<a> it = this.eUu.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i == next.getId()) {
                return next;
            }
        }
        return null;
    }

    public void b(a.InterfaceC0570a interfaceC0570a) {
        this.eUl = interfaceC0570a;
    }

    public boolean isEmpty() {
        return this.eUt == null || this.eUt.getText().length() <= 0;
    }

    public void bc(int i, int i2) {
        if (!isEmpty() && i <= i2 && i < this.eUt.length()) {
            this.eUt.removeTextChangedListener(this.eUs);
            this.eUt.getText().delete(i, i2);
            a(this.eUu, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            bqV();
            this.eUt.addTextChangedListener(this.eUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bqV() {
        Iterator<a> it = this.eUu.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
    }

    public synchronized void bqW() {
        com.baidu.tieba.i.a aVar;
        if (this.eUt != null) {
            Editable text = this.eUt.getText();
            Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
            if (matcher.find()) {
                String group = matcher.group();
                String substring = group.substring("#(commodity,commo_".length(), group.length() - "_commo)".length());
                int start = matcher.start();
                int end = matcher.end();
                try {
                    aVar = com.baidu.tieba.i.a.eb(new JSONObject(substring));
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar = null;
                }
                if (aVar != null) {
                    TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                    t a2 = t.a(tbLinkSpanGroup, aVar);
                    tbLinkSpanGroup.a(text, start, end, (int) this.eUt.getTextSize());
                    a2.eum = substring;
                    tbLinkSpanGroup.Cl(a2.mContent);
                    tbLinkSpanGroup.build();
                    a(this.eUu, end, end, (tbLinkSpanGroup.brh() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                    tbLinkSpanGroup.a(this.eUl);
                    this.eUu.add(tbLinkSpanGroup);
                }
                bqW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bqX() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.eUt != null && this.eUv) {
            Editable text = this.eUt.getText();
            Matcher matcher = aw.eIf.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end >= 0) {
                    if (b(text, end)) {
                        text.replace(end, end2, " ");
                        bqX();
                    } else {
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.eUt.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (be.boR().l(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String BM = be.boR().BM(subSequence.toString());
                                tbLinkSpanGroup.setTid(BM);
                                Cj(BM);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.eUt.getTextSize());
                            tbLinkSpanGroup.build();
                            tbLinkSpanGroup.a(this.eUl);
                            this.eUu.add(tbLinkSpanGroup);
                        } else if (this.eUt.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.eUt.getTextSize());
                            tbLinkSpanGroup2.build();
                            ar(subSequence.toString(), tbLinkSpanGroup2.getId());
                            tbLinkSpanGroup2.a(this.eUl);
                            this.eUu.add(tbLinkSpanGroup2);
                        }
                        bqX();
                    }
                }
            }
        }
    }

    private void Cj(String str) {
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i = 1;
        if (au.boO().boP()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mBdUniqueId);
        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(str, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    private void ar(String str, int i) {
        long forumId = this.eUt.getForumId();
        int bqY = bqY() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.mBdUniqueId);
        requestUrlParserNetMessage.setParams(forumId, bqY, str, i);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    private int bqY() {
        int i = 0;
        Iterator<a> it = this.eUu.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).brg() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i2++;
                }
                i = i2;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void O(bw bwVar) {
        this.eUt.removeTextChangedListener(this.eUs);
        Iterator<a> it = this.eUu.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.brg() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && at.equals(bwVar.getTid(), tbLinkSpanGroup.getTid())) {
                    String title = bwVar.getTitle();
                    if (at.isEmpty(title)) {
                        title = bwVar.getAbstract();
                    }
                    tbLinkSpanGroup.Cl(title);
                    int start = tbLinkSpanGroup.getStart();
                    int end = tbLinkSpanGroup.getEnd();
                    tbLinkSpanGroup.bre();
                    a(this.eUu, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                    bra();
                }
            }
        }
        this.eUt.addTextChangedListener(this.eUs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d dVar, int i) {
        if (dVar != null) {
            if (dVar.mStatus == 1 && dVar.eut != 3) {
                this.eUt.removeTextChangedListener(this.eUs);
                Iterator<a> it = this.eUu.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.getId() == i && (dVar.eut == 1 || dVar.eut == 2)) {
                            tbLinkSpanGroup.Cl(dVar.mTitle);
                            if (dVar.eut == 1) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.eut == 2) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            t.a(tbLinkSpanGroup, dVar);
                            if (this.eUl != null) {
                                this.eUl.G(i, true);
                            }
                            int start = tbLinkSpanGroup.getStart();
                            int end = tbLinkSpanGroup.getEnd();
                            tbLinkSpanGroup.bre();
                            a(this.eUu, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                            bra();
                        }
                    }
                }
                this.eUt.addTextChangedListener(this.eUs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqZ() {
        int selectionStart;
        if (this.eUt != null && (selectionStart = this.eUt.getSelectionStart()) == this.eUt.getSelectionEnd()) {
            Iterator<a> it = this.eUu.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && next.getEnd() == selectionStart) {
                    Selection.setSelection(this.eUt.getText(), next.getStart(), next.getEnd());
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

    private void bra() {
        if (!isEmpty()) {
            int selectionStart = Selection.getSelectionStart(this.eUt.getText());
            int selectionEnd = Selection.getSelectionEnd(this.eUt.getText());
            a qf = qf(selectionStart);
            a qf2 = qf(selectionEnd);
            if (qf instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.eUt.getText(), qf.getStart(), qf.getStart());
            } else if (qf2 instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.eUt.getText(), qf2.getStart(), qf2.getStart());
            }
        }
    }

    public LinkedList<a> brb() {
        return this.eUu;
    }

    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.eUu != null) {
            tbLinkSpanGroup.a(this.eUl);
            this.eUu.add(tbLinkSpanGroup);
        }
    }

    public boolean Ck(String str) {
        t brf;
        if (y.isEmpty(this.eUu) || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<a> it = this.eUu.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.isValid()) {
                return false;
            }
            if ((next instanceof TbLinkSpanGroup) && (brf = ((TbLinkSpanGroup) next).brf()) != null && str.equals(brf.eur)) {
                return true;
            }
        }
        return false;
    }

    public int brc() {
        if (y.isEmpty(this.eUu)) {
            return 0;
        }
        Iterator<a> it = this.eUu.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof TbLinkSpanGroup) {
                if (next.isValid()) {
                    t brf = ((TbLinkSpanGroup) next).brf();
                    if (brf != null && brf.mType == 2) {
                        i++;
                    }
                }
            }
            i = i;
        }
        return i;
    }

    public void bqQ() {
        if (this.eUt != null && this.eUs != null) {
            this.eUt.removeTextChangedListener(this.eUs);
        }
    }

    public void bqR() {
        if (this.eUt != null && this.eUs != null) {
            this.eUt.addTextChangedListener(this.eUs);
        }
    }
}
