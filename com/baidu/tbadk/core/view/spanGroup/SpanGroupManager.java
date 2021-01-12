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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
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
    private a.InterfaceC0568a flE;
    private SpanGroupEditText flM;
    private BdUniqueId mBdUniqueId;
    private TextWatcher flL = new TextWatcher() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.1
        private int flR = -1;
        private int flS = -1;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.flR = Selection.getSelectionStart(charSequence);
            this.flS = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager.this.a(SpanGroupManager.this.flN, this.flR, this.flS, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.buL();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.buN();
        }
    };
    private LinkedList<a> flN = new LinkedList<>();
    private boolean flO = true;
    private com.baidu.adp.framework.listener.a flP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.2
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
                dVar.eKz = str;
                SpanGroupManager.this.a(dVar, i);
            }
        }
    };
    private com.baidu.adp.framework.listener.a flQ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                bz bzVar = new bz();
                bzVar.a(getMyPostResIdl.data.thread_info);
                SpanGroupManager.this.Q(bzVar);
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
                    next.pR(next.getStart() + i3);
                    next.pS(next.getEnd() + i3);
                } else if (i <= next.getStart() && i2 > next.getStart()) {
                    next.setValid(false);
                } else if (i > next.getStart() && i < next.getEnd() && i2 < next.getEnd()) {
                    next.pS(next.getEnd() + i3);
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
            this.flM = spanGroupEditText;
            this.flM.addTextChangedListener(this.flL);
            this.flM.setEditableFactory(new b(new c(this)));
            this.flM.setSoftKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        return SpanGroupManager.this.buP();
                    }
                    return false;
                }
            });
            this.flQ.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.flQ);
            this.flP.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.flP);
        }
    }

    public String toString() {
        return buJ();
    }

    public synchronized String buI() {
        String spannableStringBuilder;
        if (this.flM == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.flM.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.flN.iterator();
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

    public synchronized String buJ() {
        String spannableStringBuilder;
        if (this.flM == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.flM.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.flN.iterator();
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
        this.flO = z;
    }

    public void buK() {
        this.flN.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a pU(int i) {
        Iterator<a> it = this.flN.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i > next.getStart() && i < next.getEnd()) {
                return next;
            }
        }
        return null;
    }

    public a pV(int i) {
        Iterator<a> it = this.flN.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i == next.getId()) {
                return next;
            }
        }
        return null;
    }

    public void b(a.InterfaceC0568a interfaceC0568a) {
        this.flE = interfaceC0568a;
    }

    public boolean isEmpty() {
        return this.flM == null || this.flM.getText().length() <= 0;
    }

    public void bc(int i, int i2) {
        if (!isEmpty() && i <= i2 && i < this.flM.length()) {
            this.flM.removeTextChangedListener(this.flL);
            this.flM.getText().delete(i, i2);
            a(this.flN, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            buL();
            this.flM.addTextChangedListener(this.flL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void buL() {
        Iterator<a> it = this.flN.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
    }

    public synchronized void buM() {
        com.baidu.tieba.j.a aVar;
        if (this.flM != null) {
            Editable text = this.flM.getText();
            Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
            if (matcher.find()) {
                String group = matcher.group();
                String substring = group.substring("#(commodity,commo_".length(), group.length() - "_commo)".length());
                int start = matcher.start();
                int end = matcher.end();
                try {
                    aVar = com.baidu.tieba.j.a.er(new JSONObject(substring));
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar = null;
                }
                if (aVar != null) {
                    TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                    u a2 = u.a(tbLinkSpanGroup, aVar);
                    tbLinkSpanGroup.a(text, start, end, (int) this.flM.getTextSize());
                    a2.eKA = substring;
                    tbLinkSpanGroup.Bs(a2.mContent);
                    tbLinkSpanGroup.build();
                    a(this.flN, end, end, (tbLinkSpanGroup.buX() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                    tbLinkSpanGroup.a(this.flE);
                    this.flN.add(tbLinkSpanGroup);
                }
                buM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void buN() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.flM != null && this.flO) {
            Editable text = this.flM.getText();
            Matcher matcher = aw.eYY.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end >= 0) {
                    if (b(text, end)) {
                        text.replace(end, end2, " ");
                        buN();
                    } else {
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.flM.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (be.bsB().m(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String AT = be.bsB().AT(subSequence.toString());
                                tbLinkSpanGroup.setTid(AT);
                                Bq(AT);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.flM.getTextSize());
                            tbLinkSpanGroup.build();
                            tbLinkSpanGroup.a(this.flE);
                            this.flN.add(tbLinkSpanGroup);
                        } else if (this.flM.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.flM.getTextSize());
                            tbLinkSpanGroup2.build();
                            av(subSequence.toString(), tbLinkSpanGroup2.getId());
                            tbLinkSpanGroup2.a(this.flE);
                            this.flN.add(tbLinkSpanGroup2);
                        }
                        buN();
                    }
                }
            }
        }
    }

    private void Bq(String str) {
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i = 1;
        if (au.bsy().bsz()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mBdUniqueId);
        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(str, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    private void av(String str, int i) {
        long forumId = this.flM.getForumId();
        int buO = buO() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.mBdUniqueId);
        requestUrlParserNetMessage.setParams(forumId, buO, str, i);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    private int buO() {
        int i = 0;
        Iterator<a> it = this.flN.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).buW() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i2++;
                }
                i = i2;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Q(bz bzVar) {
        this.flM.removeTextChangedListener(this.flL);
        Iterator<a> it = this.flN.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.buW() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && at.equals(bzVar.getTid(), tbLinkSpanGroup.getTid())) {
                    String title = bzVar.getTitle();
                    if (at.isEmpty(title)) {
                        title = bzVar.getAbstract();
                    }
                    tbLinkSpanGroup.Bs(title);
                    int start = tbLinkSpanGroup.getStart();
                    int end = tbLinkSpanGroup.getEnd();
                    tbLinkSpanGroup.buU();
                    a(this.flN, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                    buQ();
                }
            }
        }
        this.flM.addTextChangedListener(this.flL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d dVar, int i) {
        if (dVar != null) {
            if (dVar.mStatus == 1 && dVar.eKH != 3) {
                this.flM.removeTextChangedListener(this.flL);
                Iterator<a> it = this.flN.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.getId() == i && (dVar.eKH == 1 || dVar.eKH == 2)) {
                            tbLinkSpanGroup.Bs(dVar.mTitle);
                            if (dVar.eKH == 1) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.eKH == 2) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            u.a(tbLinkSpanGroup, dVar);
                            if (this.flE != null) {
                                this.flE.G(i, true);
                            }
                            int start = tbLinkSpanGroup.getStart();
                            int end = tbLinkSpanGroup.getEnd();
                            tbLinkSpanGroup.buU();
                            a(this.flN, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                            buQ();
                        }
                    }
                }
                this.flM.addTextChangedListener(this.flL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buP() {
        int selectionStart;
        if (this.flM != null && (selectionStart = this.flM.getSelectionStart()) == this.flM.getSelectionEnd()) {
            Iterator<a> it = this.flN.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && next.getEnd() == selectionStart) {
                    Selection.setSelection(this.flM.getText(), next.getStart(), next.getEnd());
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

    private void buQ() {
        if (!isEmpty()) {
            int selectionStart = Selection.getSelectionStart(this.flM.getText());
            int selectionEnd = Selection.getSelectionEnd(this.flM.getText());
            a pU = pU(selectionStart);
            a pU2 = pU(selectionEnd);
            if (pU instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.flM.getText(), pU.getStart(), pU.getStart());
            } else if (pU2 instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.flM.getText(), pU2.getStart(), pU2.getStart());
            }
        }
    }

    public LinkedList<a> buR() {
        return this.flN;
    }

    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.flN != null) {
            tbLinkSpanGroup.a(this.flE);
            this.flN.add(tbLinkSpanGroup);
        }
    }

    public boolean Br(String str) {
        u buV;
        if (x.isEmpty(this.flN) || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<a> it = this.flN.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.isValid()) {
                return false;
            }
            if ((next instanceof TbLinkSpanGroup) && (buV = ((TbLinkSpanGroup) next).buV()) != null && str.equals(buV.eKF)) {
                return true;
            }
        }
        return false;
    }

    public int buS() {
        if (x.isEmpty(this.flN)) {
            return 0;
        }
        Iterator<a> it = this.flN.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof TbLinkSpanGroup) {
                if (next.isValid()) {
                    u buV = ((TbLinkSpanGroup) next).buV();
                    if (buV != null && buV.mType == 2) {
                        i++;
                    }
                }
            }
            i = i;
        }
        return i;
    }

    public void buG() {
        if (this.flM != null && this.flL != null) {
            this.flM.removeTextChangedListener(this.flL);
        }
    }

    public void buH() {
        if (this.flM != null && this.flL != null) {
            this.flM.addTextChangedListener(this.flL);
        }
    }
}
