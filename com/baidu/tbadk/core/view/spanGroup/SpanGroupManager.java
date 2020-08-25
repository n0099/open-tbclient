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
/* loaded from: classes2.dex */
public class SpanGroupManager {
    private SpanGroupEditText exG;
    private a.InterfaceC0544a exy;
    private BdUniqueId mBdUniqueId;
    private TextWatcher exF = new TextWatcher() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.1
        private int exL = -1;
        private int exM = -1;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.exL = Selection.getSelectionStart(charSequence);
            this.exM = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager.this.a(SpanGroupManager.this.exH, this.exL, this.exM, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.bly();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.blA();
        }
    };
    private LinkedList<a> exH = new LinkedList<>();
    private boolean exI = true;
    private com.baidu.adp.framework.listener.a exJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.2
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
                dVar.dXv = str;
                SpanGroupManager.this.a(dVar, i);
            }
        }
    };
    private com.baidu.adp.framework.listener.a exK = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.3
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
                SpanGroupManager.this.N(bwVar);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
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
                    next.pg(next.getEnd() + i3);
                } else if (i <= next.getStart() && i2 > next.getStart()) {
                    next.setValid(false);
                } else if (i > next.getStart() && i < next.getEnd() && i2 < next.getEnd()) {
                    next.pg(next.getEnd() + i3);
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
            this.exG = spanGroupEditText;
            this.exG.addTextChangedListener(this.exF);
            this.exG.setEditableFactory(new b(new c(this)));
            this.exG.setSoftKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        return SpanGroupManager.this.blC();
                    }
                    return false;
                }
            });
            this.exK.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.exK);
            this.exJ.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.exJ);
        }
    }

    public String toString() {
        return blw();
    }

    public synchronized String blv() {
        String spannableStringBuilder;
        if (this.exG == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.exG.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.exH.iterator();
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

    public synchronized String blw() {
        String spannableStringBuilder;
        if (this.exG == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.exG.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.exH.iterator();
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

    public boolean blu() {
        Iterator<a> it = this.exH.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if ((next instanceof TbLinkSpanGroup) && next.isValid()) {
                return true;
            }
        }
        return false;
    }

    public void setTransLink(boolean z) {
        this.exI = z;
    }

    public void blx() {
        this.exH.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a pi(int i) {
        Iterator<a> it = this.exH.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i > next.getStart() && i < next.getEnd()) {
                return next;
            }
        }
        return null;
    }

    public a pj(int i) {
        Iterator<a> it = this.exH.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i == next.getId()) {
                return next;
            }
        }
        return null;
    }

    public void b(a.InterfaceC0544a interfaceC0544a) {
        this.exy = interfaceC0544a;
    }

    public boolean isEmpty() {
        return this.exG == null || this.exG.getText().length() <= 0;
    }

    public void bc(int i, int i2) {
        if (!isEmpty() && i <= i2 && i < this.exG.length()) {
            this.exG.removeTextChangedListener(this.exF);
            this.exG.getText().delete(i, i2);
            a(this.exH, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            bly();
            this.exG.addTextChangedListener(this.exF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bly() {
        Iterator<a> it = this.exH.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
    }

    public synchronized void blz() {
        com.baidu.tieba.i.a aVar;
        if (this.exG != null) {
            Editable text = this.exG.getText();
            Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
            if (matcher.find()) {
                String group = matcher.group();
                String substring = group.substring("#(commodity,commo_".length(), group.length() - "_commo)".length());
                int start = matcher.start();
                int end = matcher.end();
                try {
                    aVar = com.baidu.tieba.i.a.dJ(new JSONObject(substring));
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar = null;
                }
                if (aVar != null) {
                    TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                    t a = t.a(tbLinkSpanGroup, aVar);
                    tbLinkSpanGroup.a(text, start, end, (int) this.exG.getTextSize());
                    a.dXw = substring;
                    tbLinkSpanGroup.AJ(a.mContent);
                    tbLinkSpanGroup.build();
                    a(this.exH, end, end, (tbLinkSpanGroup.blK() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                    tbLinkSpanGroup.a(this.exy);
                    this.exH.add(tbLinkSpanGroup);
                }
                blz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void blA() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.exG != null && this.exI) {
            Editable text = this.exG.getText();
            Matcher matcher = aw.elg.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end >= 0) {
                    if (b(text, end)) {
                        text.replace(end, end2, " ");
                        blA();
                    } else {
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.exG.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (be.bju().k(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String Ak = be.bju().Ak(subSequence.toString());
                                tbLinkSpanGroup.setTid(Ak);
                                AH(Ak);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.exG.getTextSize());
                            tbLinkSpanGroup.build();
                            tbLinkSpanGroup.a(this.exy);
                            this.exH.add(tbLinkSpanGroup);
                        } else if (this.exG.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.exG.getTextSize());
                            tbLinkSpanGroup2.build();
                            aq(subSequence.toString(), tbLinkSpanGroup2.getId());
                            tbLinkSpanGroup2.a(this.exy);
                            this.exH.add(tbLinkSpanGroup2);
                        }
                        blA();
                    }
                }
            }
        }
    }

    private void AH(String str) {
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i = 1;
        if (au.bjr().bjs()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mBdUniqueId);
        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(str, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    private void aq(String str, int i) {
        long forumId = this.exG.getForumId();
        int blB = blB() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.mBdUniqueId);
        requestUrlParserNetMessage.setParams(forumId, blB, str, i);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    private int blB() {
        int i = 0;
        Iterator<a> it = this.exH.iterator();
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
    public synchronized void N(bw bwVar) {
        this.exG.removeTextChangedListener(this.exF);
        Iterator<a> it = this.exH.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.blJ() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && at.equals(bwVar.getTid(), tbLinkSpanGroup.getTid())) {
                    String title = bwVar.getTitle();
                    if (at.isEmpty(title)) {
                        title = bwVar.getAbstract();
                    }
                    tbLinkSpanGroup.AJ(title);
                    int start = tbLinkSpanGroup.getStart();
                    int end = tbLinkSpanGroup.getEnd();
                    tbLinkSpanGroup.blH();
                    a(this.exH, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                    blD();
                }
            }
        }
        this.exG.addTextChangedListener(this.exF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d dVar, int i) {
        if (dVar != null) {
            if (dVar.mStatus == 1 && dVar.dXD != 3) {
                this.exG.removeTextChangedListener(this.exF);
                Iterator<a> it = this.exH.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.getId() == i && (dVar.dXD == 1 || dVar.dXD == 2)) {
                            tbLinkSpanGroup.AJ(dVar.mTitle);
                            if (dVar.dXD == 1) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.dXD == 2) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            t.a(tbLinkSpanGroup, dVar);
                            if (this.exy != null) {
                                this.exy.E(i, true);
                            }
                            int start = tbLinkSpanGroup.getStart();
                            int end = tbLinkSpanGroup.getEnd();
                            tbLinkSpanGroup.blH();
                            a(this.exH, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                            blD();
                        }
                    }
                }
                this.exG.addTextChangedListener(this.exF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean blC() {
        int selectionStart;
        if (this.exG != null && (selectionStart = this.exG.getSelectionStart()) == this.exG.getSelectionEnd()) {
            Iterator<a> it = this.exH.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && next.getEnd() == selectionStart) {
                    Selection.setSelection(this.exG.getText(), next.getStart(), next.getEnd());
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

    private void blD() {
        if (!isEmpty()) {
            int selectionStart = Selection.getSelectionStart(this.exG.getText());
            int selectionEnd = Selection.getSelectionEnd(this.exG.getText());
            a pi = pi(selectionStart);
            a pi2 = pi(selectionEnd);
            if (pi instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.exG.getText(), pi.getStart(), pi.getStart());
            } else if (pi2 instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.exG.getText(), pi2.getStart(), pi2.getStart());
            }
        }
    }

    public LinkedList<a> blE() {
        return this.exH;
    }

    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.exH != null) {
            tbLinkSpanGroup.a(this.exy);
            this.exH.add(tbLinkSpanGroup);
        }
    }

    public boolean AI(String str) {
        t blI;
        if (y.isEmpty(this.exH) || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<a> it = this.exH.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.isValid()) {
                return false;
            }
            if ((next instanceof TbLinkSpanGroup) && (blI = ((TbLinkSpanGroup) next).blI()) != null && str.equals(blI.dXB)) {
                return true;
            }
        }
        return false;
    }

    public int blF() {
        if (y.isEmpty(this.exH)) {
            return 0;
        }
        Iterator<a> it = this.exH.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof TbLinkSpanGroup) {
                if (next.isValid()) {
                    t blI = ((TbLinkSpanGroup) next).blI();
                    if (blI != null && blI.mType == 2) {
                        i++;
                    }
                }
            }
            i = i;
        }
        return i;
    }

    public void bls() {
        if (this.exG != null && this.exF != null) {
            this.exG.removeTextChangedListener(this.exF);
        }
    }

    public void blt() {
        if (this.exG != null && this.exF != null) {
            this.exG.addTextChangedListener(this.exF);
        }
    }
}
