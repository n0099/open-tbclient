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
    private a.InterfaceC0582a faa;
    private SpanGroupEditText fai;
    private BdUniqueId mBdUniqueId;
    private TextWatcher fah = new TextWatcher() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.1
        private int fan = -1;
        private int fao = -1;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.fan = Selection.getSelectionStart(charSequence);
            this.fao = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager.this.a(SpanGroupManager.this.faj, this.fan, this.fao, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.btv();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.btx();
        }
    };
    private LinkedList<a> faj = new LinkedList<>();
    private boolean fak = true;
    private com.baidu.adp.framework.listener.a fal = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.2
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
                dVar.eAe = str;
                SpanGroupManager.this.a(dVar, i);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fam = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.3
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
                    next.qn(next.getEnd() + i3);
                } else if (i <= next.getStart() && i2 > next.getStart()) {
                    next.setValid(false);
                } else if (i > next.getStart() && i < next.getEnd() && i2 < next.getEnd()) {
                    next.qn(next.getEnd() + i3);
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
            this.fai = spanGroupEditText;
            this.fai.addTextChangedListener(this.fah);
            this.fai.setEditableFactory(new b(new c(this)));
            this.fai.setSoftKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        return SpanGroupManager.this.btz();
                    }
                    return false;
                }
            });
            this.fam.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.fam);
            this.fal.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.fal);
        }
    }

    public String toString() {
        return btt();
    }

    public synchronized String bts() {
        String spannableStringBuilder;
        if (this.fai == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.fai.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.faj.iterator();
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

    public synchronized String btt() {
        String spannableStringBuilder;
        if (this.fai == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.fai.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.faj.iterator();
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
        this.fak = z;
    }

    public void btu() {
        this.faj.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a qp(int i) {
        Iterator<a> it = this.faj.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i > next.getStart() && i < next.getEnd()) {
                return next;
            }
        }
        return null;
    }

    public a qq(int i) {
        Iterator<a> it = this.faj.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i == next.getId()) {
                return next;
            }
        }
        return null;
    }

    public void b(a.InterfaceC0582a interfaceC0582a) {
        this.faa = interfaceC0582a;
    }

    public boolean isEmpty() {
        return this.fai == null || this.fai.getText().length() <= 0;
    }

    public void bc(int i, int i2) {
        if (!isEmpty() && i <= i2 && i < this.fai.length()) {
            this.fai.removeTextChangedListener(this.fah);
            this.fai.getText().delete(i, i2);
            a(this.faj, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            btv();
            this.fai.addTextChangedListener(this.fah);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void btv() {
        Iterator<a> it = this.faj.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
    }

    public synchronized void btw() {
        com.baidu.tieba.i.a aVar;
        if (this.fai != null) {
            Editable text = this.fai.getText();
            Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
            if (matcher.find()) {
                String group = matcher.group();
                String substring = group.substring("#(commodity,commo_".length(), group.length() - "_commo)".length());
                int start = matcher.start();
                int end = matcher.end();
                try {
                    aVar = com.baidu.tieba.i.a.eh(new JSONObject(substring));
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar = null;
                }
                if (aVar != null) {
                    TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                    t a2 = t.a(tbLinkSpanGroup, aVar);
                    tbLinkSpanGroup.a(text, start, end, (int) this.fai.getTextSize());
                    a2.eAf = substring;
                    tbLinkSpanGroup.Cz(a2.mContent);
                    tbLinkSpanGroup.build();
                    a(this.faj, end, end, (tbLinkSpanGroup.btH() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                    tbLinkSpanGroup.a(this.faa);
                    this.faj.add(tbLinkSpanGroup);
                }
                btw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void btx() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.fai != null && this.fak) {
            Editable text = this.fai.getText();
            Matcher matcher = aw.eNU.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end >= 0) {
                    if (b(text, end)) {
                        text.replace(end, end2, " ");
                        btx();
                    } else {
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.fai.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (be.brr().l(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String Ca = be.brr().Ca(subSequence.toString());
                                tbLinkSpanGroup.setTid(Ca);
                                Cx(Ca);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.fai.getTextSize());
                            tbLinkSpanGroup.build();
                            tbLinkSpanGroup.a(this.faa);
                            this.faj.add(tbLinkSpanGroup);
                        } else if (this.fai.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.fai.getTextSize());
                            tbLinkSpanGroup2.build();
                            at(subSequence.toString(), tbLinkSpanGroup2.getId());
                            tbLinkSpanGroup2.a(this.faa);
                            this.faj.add(tbLinkSpanGroup2);
                        }
                        btx();
                    }
                }
            }
        }
    }

    private void Cx(String str) {
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i = 1;
        if (au.bro().brp()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mBdUniqueId);
        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(str, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    private void at(String str, int i) {
        long forumId = this.fai.getForumId();
        int bty = bty() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.mBdUniqueId);
        requestUrlParserNetMessage.setParams(forumId, bty, str, i);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    private int bty() {
        int i = 0;
        Iterator<a> it = this.faj.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).btG() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
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
        this.fai.removeTextChangedListener(this.fah);
        Iterator<a> it = this.faj.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.btG() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && at.equals(bwVar.getTid(), tbLinkSpanGroup.getTid())) {
                    String title = bwVar.getTitle();
                    if (at.isEmpty(title)) {
                        title = bwVar.getAbstract();
                    }
                    tbLinkSpanGroup.Cz(title);
                    int start = tbLinkSpanGroup.getStart();
                    int end = tbLinkSpanGroup.getEnd();
                    tbLinkSpanGroup.btE();
                    a(this.faj, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                    btA();
                }
            }
        }
        this.fai.addTextChangedListener(this.fah);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d dVar, int i) {
        if (dVar != null) {
            if (dVar.mStatus == 1 && dVar.eAm != 3) {
                this.fai.removeTextChangedListener(this.fah);
                Iterator<a> it = this.faj.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.getId() == i && (dVar.eAm == 1 || dVar.eAm == 2)) {
                            tbLinkSpanGroup.Cz(dVar.mTitle);
                            if (dVar.eAm == 1) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.eAm == 2) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            t.a(tbLinkSpanGroup, dVar);
                            if (this.faa != null) {
                                this.faa.G(i, true);
                            }
                            int start = tbLinkSpanGroup.getStart();
                            int end = tbLinkSpanGroup.getEnd();
                            tbLinkSpanGroup.btE();
                            a(this.faj, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                            btA();
                        }
                    }
                }
                this.fai.addTextChangedListener(this.fah);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean btz() {
        int selectionStart;
        if (this.fai != null && (selectionStart = this.fai.getSelectionStart()) == this.fai.getSelectionEnd()) {
            Iterator<a> it = this.faj.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && next.getEnd() == selectionStart) {
                    Selection.setSelection(this.fai.getText(), next.getStart(), next.getEnd());
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

    private void btA() {
        if (!isEmpty()) {
            int selectionStart = Selection.getSelectionStart(this.fai.getText());
            int selectionEnd = Selection.getSelectionEnd(this.fai.getText());
            a qp = qp(selectionStart);
            a qp2 = qp(selectionEnd);
            if (qp instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.fai.getText(), qp.getStart(), qp.getStart());
            } else if (qp2 instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.fai.getText(), qp2.getStart(), qp2.getStart());
            }
        }
    }

    public LinkedList<a> btB() {
        return this.faj;
    }

    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.faj != null) {
            tbLinkSpanGroup.a(this.faa);
            this.faj.add(tbLinkSpanGroup);
        }
    }

    public boolean Cy(String str) {
        t btF;
        if (y.isEmpty(this.faj) || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<a> it = this.faj.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.isValid()) {
                return false;
            }
            if ((next instanceof TbLinkSpanGroup) && (btF = ((TbLinkSpanGroup) next).btF()) != null && str.equals(btF.eAk)) {
                return true;
            }
        }
        return false;
    }

    public int btC() {
        if (y.isEmpty(this.faj)) {
            return 0;
        }
        Iterator<a> it = this.faj.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof TbLinkSpanGroup) {
                if (next.isValid()) {
                    t btF = ((TbLinkSpanGroup) next).btF();
                    if (btF != null && btF.mType == 2) {
                        i++;
                    }
                }
            }
            i = i;
        }
        return i;
    }

    public void btq() {
        if (this.fai != null && this.fah != null) {
            this.fai.removeTextChangedListener(this.fah);
        }
    }

    public void btr() {
        if (this.fai != null && this.fah != null) {
            this.fai.addTextChangedListener(this.fah);
        }
    }
}
