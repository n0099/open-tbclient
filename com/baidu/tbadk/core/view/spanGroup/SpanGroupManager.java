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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.u;
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
    private a.InterfaceC0581a eZi;
    private SpanGroupEditText eZq;
    private BdUniqueId mBdUniqueId;
    private TextWatcher eZp = new TextWatcher() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.1
        private int eZv = -1;
        private int eZw = -1;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.eZv = Selection.getSelectionStart(charSequence);
            this.eZw = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager.this.a(SpanGroupManager.this.eZr, this.eZv, this.eZw, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.bsL();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.bsN();
        }
    };
    private LinkedList<a> eZr = new LinkedList<>();
    private boolean eZs = true;
    private com.baidu.adp.framework.listener.a eZt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.2
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
                dVar.eyv = str;
                SpanGroupManager.this.a(dVar, i);
            }
        }
    };
    private com.baidu.adp.framework.listener.a eZu = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                bx bxVar = new bx();
                bxVar.a(getMyPostResIdl.data.thread_info);
                SpanGroupManager.this.Q(bxVar);
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
                    next.qL(next.getEnd() + i3);
                } else if (i <= next.getStart() && i2 > next.getStart()) {
                    next.setValid(false);
                } else if (i > next.getStart() && i < next.getEnd() && i2 < next.getEnd()) {
                    next.qL(next.getEnd() + i3);
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
            this.eZq = spanGroupEditText;
            this.eZq.addTextChangedListener(this.eZp);
            this.eZq.setEditableFactory(new b(new c(this)));
            this.eZq.setSoftKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        return SpanGroupManager.this.bsP();
                    }
                    return false;
                }
            });
            this.eZu.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.eZu);
            this.eZt.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.eZt);
        }
    }

    public String toString() {
        return bsJ();
    }

    public synchronized String bsI() {
        String spannableStringBuilder;
        if (this.eZq == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.eZq.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.eZr.iterator();
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

    public synchronized String bsJ() {
        String spannableStringBuilder;
        if (this.eZq == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.eZq.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.eZr.iterator();
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
        this.eZs = z;
    }

    public void bsK() {
        this.eZr.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a qN(int i) {
        Iterator<a> it = this.eZr.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i > next.getStart() && i < next.getEnd()) {
                return next;
            }
        }
        return null;
    }

    public a qO(int i) {
        Iterator<a> it = this.eZr.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i == next.getId()) {
                return next;
            }
        }
        return null;
    }

    public void b(a.InterfaceC0581a interfaceC0581a) {
        this.eZi = interfaceC0581a;
    }

    public boolean isEmpty() {
        return this.eZq == null || this.eZq.getText().length() <= 0;
    }

    public void bc(int i, int i2) {
        if (!isEmpty() && i <= i2 && i < this.eZq.length()) {
            this.eZq.removeTextChangedListener(this.eZp);
            this.eZq.getText().delete(i, i2);
            a(this.eZr, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            bsL();
            this.eZq.addTextChangedListener(this.eZp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bsL() {
        Iterator<a> it = this.eZr.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
    }

    public synchronized void bsM() {
        com.baidu.tieba.j.a aVar;
        if (this.eZq != null) {
            Editable text = this.eZq.getText();
            Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
            if (matcher.find()) {
                String group = matcher.group();
                String substring = group.substring("#(commodity,commo_".length(), group.length() - "_commo)".length());
                int start = matcher.start();
                int end = matcher.end();
                try {
                    aVar = com.baidu.tieba.j.a.eb(new JSONObject(substring));
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar = null;
                }
                if (aVar != null) {
                    TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                    u a2 = u.a(tbLinkSpanGroup, aVar);
                    tbLinkSpanGroup.a(text, start, end, (int) this.eZq.getTextSize());
                    a2.eyw = substring;
                    tbLinkSpanGroup.BY(a2.mContent);
                    tbLinkSpanGroup.build();
                    a(this.eZr, end, end, (tbLinkSpanGroup.bsX() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                    tbLinkSpanGroup.a(this.eZi);
                    this.eZr.add(tbLinkSpanGroup);
                }
                bsM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bsN() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.eZq != null && this.eZs) {
            Editable text = this.eZq.getText();
            Matcher matcher = ax.eMY.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end >= 0) {
                    if (b(text, end)) {
                        text.replace(end, end2, " ");
                        bsN();
                    } else {
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.eZq.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (bf.bqF().m(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String BA = bf.bqF().BA(subSequence.toString());
                                tbLinkSpanGroup.setTid(BA);
                                BW(BA);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.eZq.getTextSize());
                            tbLinkSpanGroup.build();
                            tbLinkSpanGroup.a(this.eZi);
                            this.eZr.add(tbLinkSpanGroup);
                        } else if (this.eZq.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.eZq.getTextSize());
                            tbLinkSpanGroup2.build();
                            as(subSequence.toString(), tbLinkSpanGroup2.getId());
                            tbLinkSpanGroup2.a(this.eZi);
                            this.eZr.add(tbLinkSpanGroup2);
                        }
                        bsN();
                    }
                }
            }
        }
    }

    private void BW(String str) {
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i = 1;
        if (av.bqC().bqD()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mBdUniqueId);
        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(str, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    private void as(String str, int i) {
        long forumId = this.eZq.getForumId();
        int bsO = bsO() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.mBdUniqueId);
        requestUrlParserNetMessage.setParams(forumId, bsO, str, i);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    private int bsO() {
        int i = 0;
        Iterator<a> it = this.eZr.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).bsW() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i2++;
                }
                i = i2;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Q(bx bxVar) {
        this.eZq.removeTextChangedListener(this.eZp);
        Iterator<a> it = this.eZr.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.bsW() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && au.equals(bxVar.getTid(), tbLinkSpanGroup.getTid())) {
                    String title = bxVar.getTitle();
                    if (au.isEmpty(title)) {
                        title = bxVar.getAbstract();
                    }
                    tbLinkSpanGroup.BY(title);
                    int start = tbLinkSpanGroup.getStart();
                    int end = tbLinkSpanGroup.getEnd();
                    tbLinkSpanGroup.bsU();
                    a(this.eZr, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                    bsQ();
                }
            }
        }
        this.eZq.addTextChangedListener(this.eZp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d dVar, int i) {
        if (dVar != null) {
            if (dVar.mStatus == 1 && dVar.eyD != 3) {
                this.eZq.removeTextChangedListener(this.eZp);
                Iterator<a> it = this.eZr.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.getId() == i && (dVar.eyD == 1 || dVar.eyD == 2)) {
                            tbLinkSpanGroup.BY(dVar.mTitle);
                            if (dVar.eyD == 1) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.eyD == 2) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            u.a(tbLinkSpanGroup, dVar);
                            if (this.eZi != null) {
                                this.eZi.G(i, true);
                            }
                            int start = tbLinkSpanGroup.getStart();
                            int end = tbLinkSpanGroup.getEnd();
                            tbLinkSpanGroup.bsU();
                            a(this.eZr, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                            bsQ();
                        }
                    }
                }
                this.eZq.addTextChangedListener(this.eZp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bsP() {
        int selectionStart;
        if (this.eZq != null && (selectionStart = this.eZq.getSelectionStart()) == this.eZq.getSelectionEnd()) {
            Iterator<a> it = this.eZr.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && next.getEnd() == selectionStart) {
                    Selection.setSelection(this.eZq.getText(), next.getStart(), next.getEnd());
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

    private void bsQ() {
        if (!isEmpty()) {
            int selectionStart = Selection.getSelectionStart(this.eZq.getText());
            int selectionEnd = Selection.getSelectionEnd(this.eZq.getText());
            a qN = qN(selectionStart);
            a qN2 = qN(selectionEnd);
            if (qN instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.eZq.getText(), qN.getStart(), qN.getStart());
            } else if (qN2 instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.eZq.getText(), qN2.getStart(), qN2.getStart());
            }
        }
    }

    public LinkedList<a> bsR() {
        return this.eZr;
    }

    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.eZr != null) {
            tbLinkSpanGroup.a(this.eZi);
            this.eZr.add(tbLinkSpanGroup);
        }
    }

    public boolean BX(String str) {
        u bsV;
        if (y.isEmpty(this.eZr) || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<a> it = this.eZr.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.isValid()) {
                return false;
            }
            if ((next instanceof TbLinkSpanGroup) && (bsV = ((TbLinkSpanGroup) next).bsV()) != null && str.equals(bsV.eyB)) {
                return true;
            }
        }
        return false;
    }

    public int bsS() {
        if (y.isEmpty(this.eZr)) {
            return 0;
        }
        Iterator<a> it = this.eZr.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof TbLinkSpanGroup) {
                if (next.isValid()) {
                    u bsV = ((TbLinkSpanGroup) next).bsV();
                    if (bsV != null && bsV.mType == 2) {
                        i++;
                    }
                }
            }
            i = i;
        }
        return i;
    }

    public void bsG() {
        if (this.eZq != null && this.eZp != null) {
            this.eZq.removeTextChangedListener(this.eZp);
        }
    }

    public void bsH() {
        if (this.eZq != null && this.eZp != null) {
            this.eZq.addTextChangedListener(this.eZp);
        }
    }
}
