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
    private a.InterfaceC0585a fqo;
    private SpanGroupEditText fqw;
    private BdUniqueId mBdUniqueId;
    private TextWatcher fqv = new TextWatcher() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.1
        private int fqB = -1;
        private int fqC = -1;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.fqB = Selection.getSelectionStart(charSequence);
            this.fqC = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager.this.a(SpanGroupManager.this.fqx, this.fqB, this.fqC, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.byF();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.byH();
        }
    };
    private LinkedList<a> fqx = new LinkedList<>();
    private boolean fqy = true;
    private com.baidu.adp.framework.listener.a fqz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.2
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
                dVar.ePk = str;
                SpanGroupManager.this.a(dVar, i);
            }
        }
    };
    private com.baidu.adp.framework.listener.a fqA = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.3
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
                    next.rx(next.getStart() + i3);
                    next.ry(next.getEnd() + i3);
                } else if (i <= next.getStart() && i2 > next.getStart()) {
                    next.setValid(false);
                } else if (i > next.getStart() && i < next.getEnd() && i2 < next.getEnd()) {
                    next.ry(next.getEnd() + i3);
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
            this.fqw = spanGroupEditText;
            this.fqw.addTextChangedListener(this.fqv);
            this.fqw.setEditableFactory(new b(new c(this)));
            this.fqw.setSoftKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.4
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        return SpanGroupManager.this.byJ();
                    }
                    return false;
                }
            });
            this.fqA.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.fqA);
            this.fqz.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.fqz);
        }
    }

    public String toString() {
        return byD();
    }

    public synchronized String byC() {
        String spannableStringBuilder;
        if (this.fqw == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.fqw.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.fqx.iterator();
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

    public synchronized String byD() {
        String spannableStringBuilder;
        if (this.fqw == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.fqw.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.fqx.iterator();
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
        this.fqy = z;
    }

    public void byE() {
        this.fqx.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a rA(int i) {
        Iterator<a> it = this.fqx.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i > next.getStart() && i < next.getEnd()) {
                return next;
            }
        }
        return null;
    }

    public a rB(int i) {
        Iterator<a> it = this.fqx.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i == next.getId()) {
                return next;
            }
        }
        return null;
    }

    public void b(a.InterfaceC0585a interfaceC0585a) {
        this.fqo = interfaceC0585a;
    }

    public boolean isEmpty() {
        return this.fqw == null || this.fqw.getText().length() <= 0;
    }

    public void bc(int i, int i2) {
        if (!isEmpty() && i <= i2 && i < this.fqw.length()) {
            this.fqw.removeTextChangedListener(this.fqv);
            this.fqw.getText().delete(i, i2);
            a(this.fqx, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
            byF();
            this.fqw.addTextChangedListener(this.fqv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void byF() {
        Iterator<a> it = this.fqx.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
    }

    public synchronized void byG() {
        com.baidu.tieba.j.a aVar;
        if (this.fqw != null) {
            Editable text = this.fqw.getText();
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
                    tbLinkSpanGroup.a(text, start, end, (int) this.fqw.getTextSize());
                    a2.ePl = substring;
                    tbLinkSpanGroup.CD(a2.mContent);
                    tbLinkSpanGroup.build();
                    a(this.fqx, end, end, (tbLinkSpanGroup.byR() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                    tbLinkSpanGroup.a(this.fqo);
                    this.fqx.add(tbLinkSpanGroup);
                }
                byG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void byH() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.fqw != null && this.fqy) {
            Editable text = this.fqw.getText();
            Matcher matcher = aw.fdH.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end >= 0) {
                    if (b(text, end)) {
                        text.replace(end, end2, " ");
                        byH();
                    } else {
                        CharSequence subSequence = text.subSequence(start, end);
                        if (this.fqw.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                            if (be.bwv().m(subSequence)) {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                                String Ce = be.bwv().Ce(subSequence.toString());
                                tbLinkSpanGroup.setTid(Ce);
                                CB(Ce);
                            } else {
                                tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            }
                            tbLinkSpanGroup.a(text, start, end2, (int) this.fqw.getTextSize());
                            tbLinkSpanGroup.build();
                            tbLinkSpanGroup.a(this.fqo);
                            this.fqx.add(tbLinkSpanGroup);
                        } else if (this.fqw.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                            TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                            tbLinkSpanGroup2.a(text, start, end2, (int) this.fqw.getTextSize());
                            tbLinkSpanGroup2.build();
                            av(subSequence.toString(), tbLinkSpanGroup2.getId());
                            tbLinkSpanGroup2.a(this.fqo);
                            this.fqx.add(tbLinkSpanGroup2);
                        }
                        byH();
                    }
                }
            }
        }
    }

    private void CB(String str) {
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i = 1;
        if (au.bws().bwt()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mBdUniqueId);
        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(str, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    private void av(String str, int i) {
        long forumId = this.fqw.getForumId();
        int byI = byI() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.mBdUniqueId);
        requestUrlParserNetMessage.setParams(forumId, byI, str, i);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    private int byI() {
        int i = 0;
        Iterator<a> it = this.fqx.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).byQ() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
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
        this.fqw.removeTextChangedListener(this.fqv);
        Iterator<a> it = this.fqx.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.byQ() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && at.equals(bzVar.getTid(), tbLinkSpanGroup.getTid())) {
                    String title = bzVar.getTitle();
                    if (at.isEmpty(title)) {
                        title = bzVar.getAbstract();
                    }
                    tbLinkSpanGroup.CD(title);
                    int start = tbLinkSpanGroup.getStart();
                    int end = tbLinkSpanGroup.getEnd();
                    tbLinkSpanGroup.byO();
                    a(this.fqx, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                    byK();
                }
            }
        }
        this.fqw.addTextChangedListener(this.fqv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(d dVar, int i) {
        if (dVar != null) {
            if (dVar.mStatus == 1 && dVar.ePs != 3) {
                this.fqw.removeTextChangedListener(this.fqv);
                Iterator<a> it = this.fqx.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.getId() == i && (dVar.ePs == 1 || dVar.ePs == 2)) {
                            tbLinkSpanGroup.CD(dVar.mTitle);
                            if (dVar.ePs == 1) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.ePs == 2) {
                                tbLinkSpanGroup.a(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            u.a(tbLinkSpanGroup, dVar);
                            if (this.fqo != null) {
                                this.fqo.G(i, true);
                            }
                            int start = tbLinkSpanGroup.getStart();
                            int end = tbLinkSpanGroup.getEnd();
                            tbLinkSpanGroup.byO();
                            a(this.fqx, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                            byK();
                        }
                    }
                }
                this.fqw.addTextChangedListener(this.fqv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean byJ() {
        int selectionStart;
        if (this.fqw != null && (selectionStart = this.fqw.getSelectionStart()) == this.fqw.getSelectionEnd()) {
            Iterator<a> it = this.fqx.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && next.getEnd() == selectionStart) {
                    Selection.setSelection(this.fqw.getText(), next.getStart(), next.getEnd());
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

    private void byK() {
        if (!isEmpty()) {
            int selectionStart = Selection.getSelectionStart(this.fqw.getText());
            int selectionEnd = Selection.getSelectionEnd(this.fqw.getText());
            a rA = rA(selectionStart);
            a rA2 = rA(selectionEnd);
            if (rA instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.fqw.getText(), rA.getStart(), rA.getStart());
            } else if (rA2 instanceof TbLinkSpanGroup) {
                Selection.setSelection(this.fqw.getText(), rA2.getStart(), rA2.getStart());
            }
        }
    }

    public LinkedList<a> byL() {
        return this.fqx;
    }

    public void a(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.fqx != null) {
            tbLinkSpanGroup.a(this.fqo);
            this.fqx.add(tbLinkSpanGroup);
        }
    }

    public boolean CC(String str) {
        u byP;
        if (x.isEmpty(this.fqx) || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<a> it = this.fqx.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.isValid()) {
                return false;
            }
            if ((next instanceof TbLinkSpanGroup) && (byP = ((TbLinkSpanGroup) next).byP()) != null && str.equals(byP.ePq)) {
                return true;
            }
        }
        return false;
    }

    public int byM() {
        if (x.isEmpty(this.fqx)) {
            return 0;
        }
        Iterator<a> it = this.fqx.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if (next instanceof TbLinkSpanGroup) {
                if (next.isValid()) {
                    u byP = ((TbLinkSpanGroup) next).byP();
                    if (byP != null && byP.mType == 2) {
                        i++;
                    }
                }
            }
            i = i;
        }
        return i;
    }

    public void byA() {
        if (this.fqw != null && this.fqv != null) {
            this.fqw.removeTextChangedListener(this.fqv);
        }
    }

    public void byB() {
        if (this.fqw != null && this.fqv != null) {
            this.fqw.addTextChangedListener(this.fqv);
        }
    }
}
