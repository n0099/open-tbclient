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
    private a.InterfaceC0539a ezI;
    private SpanGroupEditText ezQ;
    private BdUniqueId mBdUniqueId;
    private TextWatcher ezP = new TextWatcher() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.1
        private int ezV = -1;
        private int ezW = -1;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.ezV = Selection.getSelectionStart(charSequence);
            this.ezW = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager.this.a(SpanGroupManager.this.ezR, this.ezV, this.ezW, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.bms();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.bmu();
        }
    };
    private LinkedList<a> ezR = new LinkedList<>();
    private boolean ezS = true;
    private com.baidu.adp.framework.listener.a ezT = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.2
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
                dVar.dZJ = str;
                SpanGroupManager.this.a(dVar, i);
            }
        }
    };
    private com.baidu.adp.framework.listener.a ezU = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.3
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
                    next.pu(next.getEnd() + i3);
                } else if (i <= next.getStart() && i2 > next.getStart()) {
                    next.setValid(false);
                } else if (i > next.getStart() && i < next.getEnd() && i2 < next.getEnd()) {
                    next.pu(next.getEnd() + i3);
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
            this.ezQ = spanGroupEditText;
            this.ezQ.addTextChangedListener(this.ezP);
            this.ezQ.setEditableFactory(new b(new c(this)));
            this.ezQ.setSoftKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        return SpanGroupManager.this.bmw();
                    }
                    return false;
                }
            });
            this.ezU.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.ezU);
            this.ezT.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.ezT);
        }
    }

    public String toString() {
        return bmq();
    }

    public synchronized String bmp() {
        String spannableStringBuilder;
        if (this.ezQ == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.ezQ.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.ezR.iterator();
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

    public synchronized String bmq() {
        String spannableStringBuilder;
        if (this.ezQ == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.ezQ.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.ezR.iterator();
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
        this.ezS = z;
    }

    public void bmr() {
        this.ezR.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a pw(int i) {
        Iterator<a> it = this.ezR.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i > next.getStart() && i < next.getEnd()) {
                return next;
            }
        }
        return null;
    }

    public a px(int i) {
        Iterator<a> it = this.ezR.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i == next.getId()) {
                return next;
            }
        }
        return null;
    }

    public void b(a.InterfaceC0539a interfaceC0539a) {
        this.ezI = interfaceC0539a;
    }

    public boolean isEmpty() {
        return this.ezQ == null || this.ezQ.getText().length() <= 0;
    }

    public void bc(int i, int i2) {
        if (!isEmpty() && i <= i2 && i < this.ezQ.length()) {
            this.ezQ.removeTextChangedListener(this.ezP);
            this.ezQ.getText().delete(i, i2);
            a(this.ezR, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            bms();
            this.ezQ.addTextChangedListener(this.ezP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bms() {
        Iterator<a> it = this.ezR.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
    }

    public synchronized void bmt() {
        com.baidu.tieba.i.a aVar;
        if (this.ezQ != null) {
            Editable text = this.ezQ.getText();
            Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
            if (matcher.find()) {
                String group = matcher.group();
                String substring = group.substring("#(commodity,commo_".length(), group.length() - "_commo)".length());
                int start = matcher.start();
                int end = matcher.end();
                try {
                    aVar = com.baidu.tieba.i.a.dR(new JSONObject(substring));
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar = null;
                }
                if (aVar != null) {
                    TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                    t a = t.a(tbLinkSpanGroup, aVar);
                    tbLinkSpanGroup.a(text, start, end, (int) this.ezQ.getTextSize());
                    a.dZK = substring;
                    tbLinkSpanGroup.Bg(a.mContent);
                    tbLinkSpanGroup.build();
                    a(this.ezR, end, end, (tbLinkSpanGroup.bmE() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                    tbLinkSpanGroup.a(this.ezI);
                    this.ezR.add(tbLinkSpanGroup);
                }
                bmt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bmu() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.ezQ != null && this.ezS) {
            Editable text = this.ezQ.getText();
            Matcher matcher = aw.enB.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end >= 0) {
                    if (b(text, end)) {
                        text.replace(end, end2, " ");
                        bmu();
                    } else {
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.ezQ.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (be.bkp().k(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String AH = be.bkp().AH(subSequence.toString());
                                tbLinkSpanGroup.setTid(AH);
                                Be(AH);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.ezQ.getTextSize());
                            tbLinkSpanGroup.build();
                            tbLinkSpanGroup.a(this.ezI);
                            this.ezR.add(tbLinkSpanGroup);
                        } else if (this.ezQ.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.ezQ.getTextSize());
                            tbLinkSpanGroup2.build();
                            aq(subSequence.toString(), tbLinkSpanGroup2.getId());
                            tbLinkSpanGroup2.a(this.ezI);
                            this.ezR.add(tbLinkSpanGroup2);
                        }
                        bmu();
                    }
                }
            }
        }
    }

    private void Be(String str) {
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i = 1;
        if (au.bkm().bkn()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mBdUniqueId);
        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(str, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    private void aq(String str, int i) {
        long forumId = this.ezQ.getForumId();
        int bmv = bmv() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.mBdUniqueId);
        requestUrlParserNetMessage.setParams(forumId, bmv, str, i);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    private int bmv() {
        int i = 0;
        Iterator<a> it = this.ezR.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().isValid() ? i2 + 1 : i2;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void O(bw bwVar) {
        this.ezQ.removeTextChangedListener(this.ezP);
        Iterator<a> it = this.ezR.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.bmD() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && at.equals(bwVar.getTid(), tbLinkSpanGroup.getTid())) {
                    String title = bwVar.getTitle();
                    if (at.isEmpty(title)) {
                        title = bwVar.getAbstract();
                    }
                    tbLinkSpanGroup.Bg(title);
                    int start = tbLinkSpanGroup.getStart();
                    int end = tbLinkSpanGroup.getEnd();
                    tbLinkSpanGroup.bmB();
                    a(this.ezR, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                    bmx();
                }
            }
        }
        this.ezQ.addTextChangedListener(this.ezP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d dVar, int i) {
        if (dVar != null) {
            if (dVar.mStatus == 1 && dVar.dZR != 3) {
                this.ezQ.removeTextChangedListener(this.ezP);
                Iterator<a> it = this.ezR.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.getId() == i && (dVar.dZR == 1 || dVar.dZR == 2)) {
                            tbLinkSpanGroup.Bg(dVar.mTitle);
                            if (dVar.dZR == 1) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.dZR == 2) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            t.a(tbLinkSpanGroup, dVar);
                            if (this.ezI != null) {
                                this.ezI.E(i, true);
                            }
                            int start = tbLinkSpanGroup.getStart();
                            int end = tbLinkSpanGroup.getEnd();
                            tbLinkSpanGroup.bmB();
                            a(this.ezR, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                            bmx();
                        }
                    }
                }
                this.ezQ.addTextChangedListener(this.ezP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmw() {
        int selectionStart;
        if (this.ezQ != null && (selectionStart = this.ezQ.getSelectionStart()) == this.ezQ.getSelectionEnd()) {
            Iterator<a> it = this.ezR.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && next.getEnd() == selectionStart) {
                    Selection.setSelection(this.ezQ.getText(), next.getStart(), next.getEnd());
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

    private void bmx() {
        if (!isEmpty()) {
            int selectionStart = Selection.getSelectionStart(this.ezQ.getText());
            int selectionEnd = Selection.getSelectionEnd(this.ezQ.getText());
            a pw = pw(selectionStart);
            a pw2 = pw(selectionEnd);
            if (pw instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.ezQ.getText(), pw.getStart(), pw.getStart());
            } else if (pw2 instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.ezQ.getText(), pw2.getStart(), pw2.getStart());
            }
        }
    }

    public LinkedList<a> bmy() {
        return this.ezR;
    }

    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.ezR != null) {
            tbLinkSpanGroup.a(this.ezI);
            this.ezR.add(tbLinkSpanGroup);
        }
    }

    public boolean Bf(String str) {
        t bmC;
        if (y.isEmpty(this.ezR) || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<a> it = this.ezR.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.isValid()) {
                return false;
            }
            if ((next instanceof TbLinkSpanGroup) && (bmC = ((TbLinkSpanGroup) next).bmC()) != null && str.equals(bmC.dZP)) {
                return true;
            }
        }
        return false;
    }

    public int bmz() {
        if (y.isEmpty(this.ezR)) {
            return 0;
        }
        Iterator<a> it = this.ezR.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof TbLinkSpanGroup) {
                if (next.isValid()) {
                    t bmC = ((TbLinkSpanGroup) next).bmC();
                    if (bmC != null && bmC.mType == 2) {
                        i++;
                    }
                }
            }
            i = i;
        }
        return i;
    }

    public void bmn() {
        if (this.ezQ != null && this.ezP != null) {
            this.ezQ.removeTextChangedListener(this.ezP);
        }
    }

    public void bmo() {
        if (this.ezQ != null && this.ezP != null) {
            this.ezQ.addTextChangedListener(this.ezP);
        }
    }
}
