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
import com.baidu.tbadk.core.data.by;
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
    private a.InterfaceC0594a fgF;
    private SpanGroupEditText fgN;
    private BdUniqueId mBdUniqueId;
    private TextWatcher fgM = new TextWatcher() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.1
        private int fgS = -1;
        private int fgT = -1;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.fgS = Selection.getSelectionStart(charSequence);
            this.fgT = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager.this.a(SpanGroupManager.this.fgO, this.fgS, this.fgT, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.bwl();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.bwn();
        }
    };
    private LinkedList<a> fgO = new LinkedList<>();
    private boolean fgP = true;
    private com.baidu.adp.framework.listener.a fgQ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.2
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
                dVar.eFu = str;
                SpanGroupManager.this.a(dVar, i);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fgR = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                by byVar = new by();
                byVar.a(getMyPostResIdl.data.thread_info);
                SpanGroupManager.this.Q(byVar);
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
                    next.rm(next.getEnd() + i3);
                } else if (i <= next.getStart() && i2 > next.getStart()) {
                    next.setValid(false);
                } else if (i > next.getStart() && i < next.getEnd() && i2 < next.getEnd()) {
                    next.rm(next.getEnd() + i3);
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
            this.fgN = spanGroupEditText;
            this.fgN.addTextChangedListener(this.fgM);
            this.fgN.setEditableFactory(new b(new c(this)));
            this.fgN.setSoftKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        return SpanGroupManager.this.bwp();
                    }
                    return false;
                }
            });
            this.fgR.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.fgR);
            this.fgQ.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.fgQ);
        }
    }

    public String toString() {
        return bwj();
    }

    public synchronized String bwi() {
        String spannableStringBuilder;
        if (this.fgN == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.fgN.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.fgO.iterator();
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

    public synchronized String bwj() {
        String spannableStringBuilder;
        if (this.fgN == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.fgN.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.fgO.iterator();
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
        this.fgP = z;
    }

    public void bwk() {
        this.fgO.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a ro(int i) {
        Iterator<a> it = this.fgO.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i > next.getStart() && i < next.getEnd()) {
                return next;
            }
        }
        return null;
    }

    public a rp(int i) {
        Iterator<a> it = this.fgO.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i == next.getId()) {
                return next;
            }
        }
        return null;
    }

    public void b(a.InterfaceC0594a interfaceC0594a) {
        this.fgF = interfaceC0594a;
    }

    public boolean isEmpty() {
        return this.fgN == null || this.fgN.getText().length() <= 0;
    }

    public void be(int i, int i2) {
        if (!isEmpty() && i <= i2 && i < this.fgN.length()) {
            this.fgN.removeTextChangedListener(this.fgM);
            this.fgN.getText().delete(i, i2);
            a(this.fgO, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            bwl();
            this.fgN.addTextChangedListener(this.fgM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bwl() {
        Iterator<a> it = this.fgO.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
    }

    public synchronized void bwm() {
        com.baidu.tieba.j.a aVar;
        if (this.fgN != null) {
            Editable text = this.fgN.getText();
            Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
            if (matcher.find()) {
                String group = matcher.group();
                String substring = group.substring("#(commodity,commo_".length(), group.length() - "_commo)".length());
                int start = matcher.start();
                int end = matcher.end();
                try {
                    aVar = com.baidu.tieba.j.a.ed(new JSONObject(substring));
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar = null;
                }
                if (aVar != null) {
                    TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                    u a2 = u.a(tbLinkSpanGroup, aVar);
                    tbLinkSpanGroup.a(text, start, end, (int) this.fgN.getTextSize());
                    a2.eFv = substring;
                    tbLinkSpanGroup.CG(a2.mContent);
                    tbLinkSpanGroup.build();
                    a(this.fgO, end, end, (tbLinkSpanGroup.bwx() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                    tbLinkSpanGroup.a(this.fgF);
                    this.fgO.add(tbLinkSpanGroup);
                }
                bwm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bwn() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.fgN != null && this.fgP) {
            Editable text = this.fgN.getText();
            Matcher matcher = ax.eUk.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end >= 0) {
                    if (b(text, end)) {
                        text.replace(end, end2, " ");
                        bwn();
                    } else {
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.fgN.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (bf.bua().m(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String Ch = bf.bua().Ch(subSequence.toString());
                                tbLinkSpanGroup.setTid(Ch);
                                CE(Ch);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.fgN.getTextSize());
                            tbLinkSpanGroup.build();
                            tbLinkSpanGroup.a(this.fgF);
                            this.fgO.add(tbLinkSpanGroup);
                        } else if (this.fgN.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.fgN.getTextSize());
                            tbLinkSpanGroup2.build();
                            at(subSequence.toString(), tbLinkSpanGroup2.getId());
                            tbLinkSpanGroup2.a(this.fgF);
                            this.fgO.add(tbLinkSpanGroup2);
                        }
                        bwn();
                    }
                }
            }
        }
    }

    private void CE(String str) {
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i = 1;
        if (av.btX().btY()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mBdUniqueId);
        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(str, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    private void at(String str, int i) {
        long forumId = this.fgN.getForumId();
        int bwo = bwo() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.mBdUniqueId);
        requestUrlParserNetMessage.setParams(forumId, bwo, str, i);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    private int bwo() {
        int i = 0;
        Iterator<a> it = this.fgO.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).bww() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                    i2++;
                }
                i = i2;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Q(by byVar) {
        this.fgN.removeTextChangedListener(this.fgM);
        Iterator<a> it = this.fgO.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.bww() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && au.equals(byVar.getTid(), tbLinkSpanGroup.getTid())) {
                    String title = byVar.getTitle();
                    if (au.isEmpty(title)) {
                        title = byVar.getAbstract();
                    }
                    tbLinkSpanGroup.CG(title);
                    int start = tbLinkSpanGroup.getStart();
                    int end = tbLinkSpanGroup.getEnd();
                    tbLinkSpanGroup.bwu();
                    a(this.fgO, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                    bwq();
                }
            }
        }
        this.fgN.addTextChangedListener(this.fgM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d dVar, int i) {
        if (dVar != null) {
            if (dVar.mStatus == 1 && dVar.eFC != 3) {
                this.fgN.removeTextChangedListener(this.fgM);
                Iterator<a> it = this.fgO.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.getId() == i && (dVar.eFC == 1 || dVar.eFC == 2)) {
                            tbLinkSpanGroup.CG(dVar.mTitle);
                            if (dVar.eFC == 1) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.eFC == 2) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            u.a(tbLinkSpanGroup, dVar);
                            if (this.fgF != null) {
                                this.fgF.G(i, true);
                            }
                            int start = tbLinkSpanGroup.getStart();
                            int end = tbLinkSpanGroup.getEnd();
                            tbLinkSpanGroup.bwu();
                            a(this.fgO, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                            bwq();
                        }
                    }
                }
                this.fgN.addTextChangedListener(this.fgM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bwp() {
        int selectionStart;
        if (this.fgN != null && (selectionStart = this.fgN.getSelectionStart()) == this.fgN.getSelectionEnd()) {
            Iterator<a> it = this.fgO.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && next.getEnd() == selectionStart) {
                    Selection.setSelection(this.fgN.getText(), next.getStart(), next.getEnd());
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

    private void bwq() {
        if (!isEmpty()) {
            int selectionStart = Selection.getSelectionStart(this.fgN.getText());
            int selectionEnd = Selection.getSelectionEnd(this.fgN.getText());
            a ro = ro(selectionStart);
            a ro2 = ro(selectionEnd);
            if (ro instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.fgN.getText(), ro.getStart(), ro.getStart());
            } else if (ro2 instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.fgN.getText(), ro2.getStart(), ro2.getStart());
            }
        }
    }

    public LinkedList<a> bwr() {
        return this.fgO;
    }

    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.fgO != null) {
            tbLinkSpanGroup.a(this.fgF);
            this.fgO.add(tbLinkSpanGroup);
        }
    }

    public boolean CF(String str) {
        u bwv;
        if (y.isEmpty(this.fgO) || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<a> it = this.fgO.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.isValid()) {
                return false;
            }
            if ((next instanceof TbLinkSpanGroup) && (bwv = ((TbLinkSpanGroup) next).bwv()) != null && str.equals(bwv.eFA)) {
                return true;
            }
        }
        return false;
    }

    public int bws() {
        if (y.isEmpty(this.fgO)) {
            return 0;
        }
        Iterator<a> it = this.fgO.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof TbLinkSpanGroup) {
                if (next.isValid()) {
                    u bwv = ((TbLinkSpanGroup) next).bwv();
                    if (bwv != null && bwv.mType == 2) {
                        i++;
                    }
                }
            }
            i = i;
        }
        return i;
    }

    public void bwg() {
        if (this.fgN != null && this.fgM != null) {
            this.fgN.removeTextChangedListener(this.fgM);
        }
    }

    public void bwh() {
        if (this.fgN != null && this.fgM != null) {
            this.fgN.addTextChangedListener(this.fgM);
        }
    }
}
