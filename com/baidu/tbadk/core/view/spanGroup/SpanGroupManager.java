package com.baidu.tbadk.core.view.spanGroup;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class SpanGroupManager {
    private SpanGroupEditText ehp;
    private BdUniqueId mBdUniqueId;
    private LinkedList<a> ehq = new LinkedList<>();
    private boolean ehr = true;
    private TextWatcher mTextWatcher = new TextWatcher() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.1
        private int eht = -1;
        private int ehu = -1;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.eht = Selection.getSelectionStart(charSequence);
            this.ehu = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager.this.a(SpanGroupManager.this.ehq, this.eht, this.ehu, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.aZc();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.aZd();
        }
    };
    private com.baidu.adp.framework.listener.a ehs = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl = null;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
            }
            if (getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null) {
                bu buVar = new bu();
                buVar.a(getMyPostResIdl.data.thread_info);
                SpanGroupManager.this.Q(buVar);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum ChangeSpanGroupType {
        DEFAULT,
        ON_TEXT_CHANGE
    }

    public SpanGroupManager(@NonNull SpanGroupEditText spanGroupEditText, BdUniqueId bdUniqueId) {
        if (spanGroupEditText != null) {
            this.mBdUniqueId = bdUniqueId;
            this.ehp = spanGroupEditText;
            this.ehp.addTextChangedListener(this.mTextWatcher);
            this.ehp.setEditableFactory(new b(new c(this)));
            this.ehp.setSoftKeyListener(new View.OnKeyListener() { // from class: com.baidu.tbadk.core.view.spanGroup.SpanGroupManager.3
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        return SpanGroupManager.this.aZe();
                    }
                    return false;
                }
            });
            this.ehs.setTag(this.mBdUniqueId);
            MessageManager.getInstance().registerListener(this.ehs);
        }
    }

    public String toString() {
        return aZa();
    }

    public synchronized String aYZ() {
        String spannableStringBuilder;
        if (this.ehp == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.ehp.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.ehq.iterator();
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

    public synchronized String aZa() {
        String spannableStringBuilder;
        if (this.ehp == null) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.ehp.getText());
            LinkedList<a> linkedList = new LinkedList<>();
            Iterator<a> it = this.ehq.iterator();
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

    public boolean aYY() {
        Iterator<a> it = this.ehq.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if ((next instanceof TbLinkSpanGroup) && next.isValid()) {
                return true;
            }
        }
        return false;
    }

    public void setTransLink(boolean z) {
        this.ehr = z;
    }

    public void aZb() {
        this.ehq.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a mJ(int i) {
        Iterator<a> it = this.ehq.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && i > next.getStart() && i < next.getEnd()) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(LinkedList<a> linkedList, int i, int i2, int i3, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Iterator<a> it = linkedList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (!z || next.getStart() != i)) {
                if (i <= next.getStart() && i2 <= next.getStart()) {
                    next.setStart(next.getStart() + i3);
                    next.mI(next.getEnd() + i3);
                } else if (i <= next.getStart() && i2 > next.getStart()) {
                    next.setValid(false);
                } else if (i > next.getStart() && i < next.getEnd() && i2 < next.getEnd()) {
                    next.mI(next.getEnd() + i3);
                } else if (i > next.getStart() && i < next.getEnd() && i2 >= next.getEnd()) {
                    next.setValid(false);
                } else if (changeSpanGroupType == ChangeSpanGroupType.ON_TEXT_CHANGE && i == i2 && Math.abs(i3) == next.getEnd() - next.getStart() && next.getEnd() <= i2 && next.getEnd() > i2 + i3) {
                    next.setValid(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aZc() {
        Iterator<a> it = this.ehq.iterator();
        while (it.hasNext()) {
            if (!it.next().isValid()) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aZd() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.ehp != null && this.ehr) {
            Editable text = this.ehp.getText();
            Matcher matcher = au.dVc.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end >= 0) {
                    CharSequence subSequence = text.subSequence(start, end);
                    if (bc.aWU().k(subSequence)) {
                        tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                        String wO = bc.aWU().wO(subSequence.toString());
                        tbLinkSpanGroup.setTid(wO);
                        xo(wO);
                    } else {
                        tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.EXTERNAL_LINK);
                    }
                    tbLinkSpanGroup.a(text, start, end2, (int) this.ehp.getTextSize());
                    tbLinkSpanGroup.build();
                    this.ehq.add(tbLinkSpanGroup);
                    aZd();
                }
            }
        }
    }

    private void xo(String str) {
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float f = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i = 1;
        if (as.aWR().aWS()) {
            i = 2;
        }
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.mBdUniqueId);
        requestGetMyPostNetMessage.setParams(com.baidu.adp.lib.f.b.toLong(str, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Q(bu buVar) {
        Iterator<a> it = this.ehq.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.isValid() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.aZh() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && ar.equals(buVar.getTid(), tbLinkSpanGroup.getTid())) {
                    String title = buVar.getTitle();
                    if (ar.isEmpty(title)) {
                        title = buVar.getAbstract();
                    }
                    tbLinkSpanGroup.xp(title);
                    int start = tbLinkSpanGroup.getStart();
                    int end = tbLinkSpanGroup.getEnd();
                    tbLinkSpanGroup.aZg();
                    a(this.ehq, start, end, (tbLinkSpanGroup.getEnd() - tbLinkSpanGroup.getStart()) - (end - start), true, ChangeSpanGroupType.DEFAULT);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZe() {
        int selectionStart;
        if (this.ehp != null && (selectionStart = this.ehp.getSelectionStart()) == this.ehp.getSelectionEnd()) {
            Iterator<a> it = this.ehq.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.isValid() && next.getEnd() == selectionStart) {
                    Selection.setSelection(this.ehp.getText(), next.getStart(), next.getEnd());
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
