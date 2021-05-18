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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.j0.r.f0.p.a;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes3.dex */
public class SpanGroupManager {

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f12591b;

    /* renamed from: c  reason: collision with root package name */
    public SpanGroupEditText f12592c;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1127a f12595f;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f12590a = new a();

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<d.a.j0.r.f0.p.a> f12593d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f12594e = true;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f12596g = new b(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f12597h = new c(CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* loaded from: classes3.dex */
    public enum ChangeSpanGroupType {
        DEFAULT,
        ON_TEXT_CHANGE
    }

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public int f12598e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f12599f = -1;

        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.n();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f12598e = Selection.getSelectionStart(charSequence);
            this.f12599f = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            SpanGroupManager spanGroupManager = SpanGroupManager.this;
            spanGroupManager.h(spanGroupManager.f12593d, this.f12598e, this.f12599f, i4 - i3, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.j();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UrlParserResIdl responseData;
            int i2;
            String str = null;
            if (responsedMessage instanceof UrlParserHttpResponseMessage) {
                responseData = ((UrlParserHttpResponseMessage) responsedMessage).getResponseData();
            } else {
                responseData = responsedMessage instanceof UrlParserSocketResponseMessage ? ((UrlParserSocketResponseMessage) responsedMessage).getResponseData() : null;
            }
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof RequestUrlParserNetMessage)) {
                i2 = 0;
            } else {
                RequestUrlParserNetMessage requestUrlParserNetMessage = (RequestUrlParserNetMessage) responsedMessage.getOrginalMessage().getExtra();
                str = requestUrlParserNetMessage.getUrl();
                i2 = requestUrlParserNetMessage.getSpanGroupId();
            }
            if (responseData == null || responseData.data == null || i2 == 0) {
                return;
            }
            d.a.j0.r.f0.p.d dVar = new d.a.j0.r.f0.p.d();
            dVar.a(responseData);
            dVar.f49736c = str;
            SpanGroupManager.this.z(dVar, i2);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.c.c.g.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl responseData;
            DataRes dataRes;
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                responseData = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
            } else {
                responseData = responsedMessage instanceof GetMyPostSocketResponseMessage ? ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData() : null;
            }
            if (responseData == null || (dataRes = responseData.data) == null || dataRes.thread_info == null) {
                return;
            }
            a2 a2Var = new a2();
            a2Var.T2(responseData.data.thread_info);
            SpanGroupManager.this.A(a2Var);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnKeyListener {
        public d() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 == 67 && keyEvent.getAction() == 0) {
                return SpanGroupManager.this.E();
            }
            return false;
        }
    }

    public SpanGroupManager(@NonNull SpanGroupEditText spanGroupEditText, BdUniqueId bdUniqueId) {
        if (spanGroupEditText == null) {
            return;
        }
        this.f12591b = bdUniqueId;
        this.f12592c = spanGroupEditText;
        spanGroupEditText.addTextChangedListener(this.f12590a);
        this.f12592c.setEditableFactory(new d.a.j0.r.f0.p.b(new d.a.j0.r.f0.p.c(this)));
        this.f12592c.setSoftKeyListener(new d());
        this.f12597h.setTag(this.f12591b);
        MessageManager.getInstance().registerListener(this.f12597h);
        this.f12596g.setTag(this.f12591b);
        MessageManager.getInstance().registerListener(this.f12596g);
    }

    public final synchronized void A(a2 a2Var) {
        this.f12592c.removeTextChangedListener(this.f12590a);
        Iterator<d.a.j0.r.f0.p.a> it = this.f12593d.iterator();
        while (it.hasNext()) {
            d.a.j0.r.f0.p.a next = it.next();
            if (next.h() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.u() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && StringHelper.equals(a2Var.x1(), tbLinkSpanGroup.v())) {
                    String y1 = a2Var.y1();
                    if (k.isEmpty(y1)) {
                        y1 = a2Var.C();
                    }
                    tbLinkSpanGroup.z(y1);
                    int f2 = tbLinkSpanGroup.f();
                    int c2 = tbLinkSpanGroup.c();
                    tbLinkSpanGroup.E();
                    h(this.f12593d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                    y();
                }
            }
        }
        this.f12592c.addTextChangedListener(this.f12590a);
    }

    public void B() {
        TextWatcher textWatcher;
        SpanGroupEditText spanGroupEditText = this.f12592c;
        if (spanGroupEditText == null || (textWatcher = this.f12590a) == null) {
            return;
        }
        spanGroupEditText.removeTextChangedListener(textWatcher);
    }

    public final void C(String str, int i2) {
        long forumId = this.f12592c.getForumId();
        int u = u() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.f12591b);
        requestUrlParserNetMessage.setParams(forumId, u, str, i2);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    public final void D(String str) {
        int k = l.k(TbadkCoreApplication.getInst());
        int i2 = l.i(TbadkCoreApplication.getInst());
        float f2 = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.f12591b);
        requestGetMyPostNetMessage.setParams(d.a.c.e.m.b.f(str, 0L), 0L, 0L, k, i2, f2, i3);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    public final boolean E() {
        int selectionStart;
        SpanGroupEditText spanGroupEditText = this.f12592c;
        if (spanGroupEditText != null && (selectionStart = spanGroupEditText.getSelectionStart()) == this.f12592c.getSelectionEnd()) {
            Iterator<d.a.j0.r.f0.p.a> it = this.f12593d.iterator();
            while (it.hasNext()) {
                d.a.j0.r.f0.p.a next = it.next();
                if (next.h() && next.c() == selectionStart) {
                    Selection.setSelection(this.f12592c.getText(), next.f(), next.c());
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void F(a.InterfaceC1127a interfaceC1127a) {
        this.f12595f = interfaceC1127a;
    }

    public void G(boolean z) {
        this.f12594e = z;
    }

    public void g() {
        TextWatcher textWatcher;
        SpanGroupEditText spanGroupEditText = this.f12592c;
        if (spanGroupEditText == null || (textWatcher = this.f12590a) == null) {
            return;
        }
        spanGroupEditText.addTextChangedListener(textWatcher);
    }

    public synchronized void h(LinkedList<d.a.j0.r.f0.p.a> linkedList, int i2, int i3, int i4, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Iterator<d.a.j0.r.f0.p.a> it = linkedList.iterator();
        while (it.hasNext()) {
            d.a.j0.r.f0.p.a next = it.next();
            if (next.h() && (!z || next.f() != i2)) {
                if (i2 <= next.f() && i3 <= next.f()) {
                    next.m(next.f() + i4);
                    next.j(next.c() + i4);
                } else if (i2 <= next.f() && i3 > next.f()) {
                    next.o(false);
                } else if (i2 > next.f() && i2 < next.c() && i3 < next.c()) {
                    next.j(next.c() + i4);
                } else if (i2 > next.f() && i2 < next.c() && i3 >= next.c()) {
                    next.o(false);
                } else if (changeSpanGroupType == ChangeSpanGroupType.ON_TEXT_CHANGE && i2 == i3 && Math.abs(i4) == next.c() - next.f() && next.c() <= i3 && next.c() > i3 + i4) {
                    next.o(false);
                }
            }
        }
    }

    public boolean i(String str) {
        v t;
        if (!ListUtils.isEmpty(this.f12593d) && !TextUtils.isEmpty(str)) {
            Iterator<d.a.j0.r.f0.p.a> it = this.f12593d.iterator();
            while (it.hasNext()) {
                d.a.j0.r.f0.p.a next = it.next();
                if (!next.h()) {
                    return false;
                }
                if ((next instanceof TbLinkSpanGroup) && (t = ((TbLinkSpanGroup) next).t()) != null && str.equals(t.q)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final synchronized void j() {
        Iterator<d.a.j0.r.f0.p.a> it = this.f12593d.iterator();
        while (it.hasNext()) {
            if (!it.next().h()) {
                it.remove();
            }
        }
    }

    public void k() {
        this.f12593d.clear();
    }

    public void l(int i2, int i3) {
        if (w() || i2 > i3 || i2 >= this.f12592c.length()) {
            return;
        }
        this.f12592c.removeTextChangedListener(this.f12590a);
        this.f12592c.getText().delete(i2, i3);
        h(this.f12593d, i2, i3, i2 - i3, false, ChangeSpanGroupType.DEFAULT);
        j();
        this.f12592c.addTextChangedListener(this.f12590a);
    }

    public synchronized void m() {
        if (this.f12592c == null) {
            return;
        }
        Editable text = this.f12592c.getText();
        Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
        if (matcher.find()) {
            String group = matcher.group();
            String substring = group.substring(18, group.length() - 7);
            int start = matcher.start();
            int end = matcher.end();
            d.a.k0.w0.a aVar = null;
            try {
                aVar = d.a.k0.w0.a.g(new JSONObject(substring));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (aVar != null) {
                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                v b2 = v.b(tbLinkSpanGroup, aVar);
                tbLinkSpanGroup.a(text, start, end, (int) this.f12592c.getTextSize());
                b2.l = substring;
                tbLinkSpanGroup.z(b2.f50095h);
                tbLinkSpanGroup.r();
                h(this.f12593d, end, end, (tbLinkSpanGroup.w() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                tbLinkSpanGroup.k(this.f12595f);
                this.f12593d.add(tbLinkSpanGroup);
            }
            m();
        }
    }

    public final synchronized void n() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.f12592c != null && this.f12594e) {
            Editable text = this.f12592c.getText();
            Matcher matcher = TbPatternsCompat.WEB_URL_END_WITH_BLANK.matcher(text);
            if (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end() - 1;
                int end2 = matcher.end();
                if (end < 0) {
                    return;
                }
                if (x(text, end)) {
                    text.replace(end, end2, " ");
                    n();
                    return;
                }
                CharSequence subSequence = text.subSequence(start, end);
                if (this.f12592c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                    if (UrlManager.getInstance().isPbUrl(subSequence)) {
                        tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                        String tidFromPbUrl = UrlManager.getInstance().getTidFromPbUrl(subSequence.toString());
                        tbLinkSpanGroup.B(tidFromPbUrl);
                        D(tidFromPbUrl);
                    } else {
                        tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                    }
                    tbLinkSpanGroup.a(text, start, end2, (int) this.f12592c.getTextSize());
                    tbLinkSpanGroup.r();
                    tbLinkSpanGroup.k(this.f12595f);
                    this.f12593d.add(tbLinkSpanGroup);
                } else if (this.f12592c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                    TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                    tbLinkSpanGroup2.a(text, start, end2, (int) this.f12592c.getTextSize());
                    tbLinkSpanGroup2.r();
                    C(subSequence.toString(), tbLinkSpanGroup2.e());
                    tbLinkSpanGroup2.k(this.f12595f);
                    this.f12593d.add(tbLinkSpanGroup2);
                }
                n();
            }
        }
    }

    public int o() {
        v t;
        int i2 = 0;
        if (ListUtils.isEmpty(this.f12593d)) {
            return 0;
        }
        Iterator<d.a.j0.r.f0.p.a> it = this.f12593d.iterator();
        while (it.hasNext()) {
            d.a.j0.r.f0.p.a next = it.next();
            if ((next instanceof TbLinkSpanGroup) && next.h() && (t = ((TbLinkSpanGroup) next).t()) != null && t.f50093f == 2) {
                i2++;
            }
        }
        return i2;
    }

    public synchronized String p() {
        if (this.f12592c == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f12592c.getText());
        LinkedList<d.a.j0.r.f0.p.a> linkedList = new LinkedList<>();
        Iterator<d.a.j0.r.f0.p.a> it = this.f12593d.iterator();
        while (it.hasNext()) {
            d.a.j0.r.f0.p.a next = it.next();
            if (next.h()) {
                if (next instanceof TbLinkSpanGroup) {
                    linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                } else {
                    linkedList.add(next);
                }
            }
        }
        Iterator<d.a.j0.r.f0.p.a> it2 = linkedList.iterator();
        while (it2.hasNext()) {
            d.a.j0.r.f0.p.a next2 = it2.next();
            int f2 = next2.f();
            int c2 = next2.c();
            next2.p(spannableStringBuilder);
            h(linkedList, f2, c2, (next2.c() - next2.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
        }
        return spannableStringBuilder.toString();
    }

    public d.a.j0.r.f0.p.a q(int i2) {
        Iterator<d.a.j0.r.f0.p.a> it = this.f12593d.iterator();
        while (it.hasNext()) {
            d.a.j0.r.f0.p.a next = it.next();
            if (next.h() && i2 > next.f() && i2 < next.c()) {
                return next;
            }
        }
        return null;
    }

    public d.a.j0.r.f0.p.a r(int i2) {
        Iterator<d.a.j0.r.f0.p.a> it = this.f12593d.iterator();
        while (it.hasNext()) {
            d.a.j0.r.f0.p.a next = it.next();
            if (next.h() && i2 == next.e()) {
                return next;
            }
        }
        return null;
    }

    public LinkedList<d.a.j0.r.f0.p.a> s() {
        return this.f12593d;
    }

    public synchronized String t() {
        if (this.f12592c == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f12592c.getText());
        LinkedList<d.a.j0.r.f0.p.a> linkedList = new LinkedList<>();
        Iterator<d.a.j0.r.f0.p.a> it = this.f12593d.iterator();
        while (it.hasNext()) {
            d.a.j0.r.f0.p.a next = it.next();
            if (next.h()) {
                if (next instanceof TbLinkSpanGroup) {
                    linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                } else {
                    linkedList.add(next);
                }
            }
        }
        Iterator<d.a.j0.r.f0.p.a> it2 = linkedList.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            d.a.j0.r.f0.p.a next2 = it2.next();
            int f2 = next2.f();
            int c2 = next2.c();
            next2.q(spannableStringBuilder, i2);
            h(linkedList, f2, c2, (next2.c() - next2.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
            i2++;
        }
        return spannableStringBuilder.toString();
    }

    public String toString() {
        return p();
    }

    public final int u() {
        Iterator<d.a.j0.r.f0.p.a> it = this.f12593d.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            d.a.j0.r.f0.p.a next = it.next();
            if (next.h() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).u() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                i2++;
            }
        }
        return i2;
    }

    public void v(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.f12593d != null) {
            tbLinkSpanGroup.k(this.f12595f);
            this.f12593d.add(tbLinkSpanGroup);
        }
    }

    public boolean w() {
        SpanGroupEditText spanGroupEditText = this.f12592c;
        return spanGroupEditText == null || spanGroupEditText.getText().length() <= 0;
    }

    public final boolean x(CharSequence charSequence, int i2) {
        return charSequence != null && charSequence.length() != 0 && i2 >= 0 && charSequence.charAt(i2) == '\n';
    }

    public final void y() {
        if (w()) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.f12592c.getText());
        int selectionEnd = Selection.getSelectionEnd(this.f12592c.getText());
        d.a.j0.r.f0.p.a q = q(selectionStart);
        d.a.j0.r.f0.p.a q2 = q(selectionEnd);
        if (q instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f12592c.getText(), q.f(), q.f());
        } else if (q2 instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f12592c.getText(), q2.f(), q2.f());
        }
    }

    public final synchronized void z(d.a.j0.r.f0.p.d dVar, int i2) {
        if (dVar != null) {
            if (dVar.f49734a == 1 && dVar.f49735b != 3) {
                this.f12592c.removeTextChangedListener(this.f12590a);
                Iterator<d.a.j0.r.f0.p.a> it = this.f12593d.iterator();
                while (it.hasNext()) {
                    d.a.j0.r.f0.p.a next = it.next();
                    if (next.h() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.e() == i2 && (dVar.f49735b == 1 || dVar.f49735b == 2)) {
                            tbLinkSpanGroup.z(dVar.f49738e);
                            if (dVar.f49735b == 1) {
                                tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.f49735b == 2) {
                                tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            v.c(tbLinkSpanGroup, dVar);
                            if (this.f12595f != null) {
                                this.f12595f.a(i2, true);
                            }
                            int f2 = tbLinkSpanGroup.f();
                            int c2 = tbLinkSpanGroup.c();
                            tbLinkSpanGroup.E();
                            h(this.f12593d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                            y();
                        }
                    }
                }
                this.f12592c.addTextChangedListener(this.f12590a);
            }
        }
    }
}
