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
import d.a.i0.r.f0.p.a;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v;
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
    public BdUniqueId f13255b;

    /* renamed from: c  reason: collision with root package name */
    public SpanGroupEditText f13256c;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1051a f13259f;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f13254a = new a();

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<d.a.i0.r.f0.p.a> f13257d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f13258e = true;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f13260g = new b(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f13261h = new c(CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* loaded from: classes3.dex */
    public enum ChangeSpanGroupType {
        DEFAULT,
        ON_TEXT_CHANGE
    }

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public int f13262e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f13263f = -1;

        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.n();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f13262e = Selection.getSelectionStart(charSequence);
            this.f13263f = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            SpanGroupManager spanGroupManager = SpanGroupManager.this;
            spanGroupManager.h(spanGroupManager.f13257d, this.f13262e, this.f13263f, i4 - i3, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
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
            d.a.i0.r.f0.p.d dVar = new d.a.i0.r.f0.p.d();
            dVar.a(responseData);
            dVar.f48907c = str;
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
            a2Var.R2(responseData.data.thread_info);
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
        this.f13255b = bdUniqueId;
        this.f13256c = spanGroupEditText;
        spanGroupEditText.addTextChangedListener(this.f13254a);
        this.f13256c.setEditableFactory(new d.a.i0.r.f0.p.b(new d.a.i0.r.f0.p.c(this)));
        this.f13256c.setSoftKeyListener(new d());
        this.f13261h.setTag(this.f13255b);
        MessageManager.getInstance().registerListener(this.f13261h);
        this.f13260g.setTag(this.f13255b);
        MessageManager.getInstance().registerListener(this.f13260g);
    }

    public final synchronized void A(a2 a2Var) {
        this.f13256c.removeTextChangedListener(this.f13254a);
        Iterator<d.a.i0.r.f0.p.a> it = this.f13257d.iterator();
        while (it.hasNext()) {
            d.a.i0.r.f0.p.a next = it.next();
            if (next.h() && (next instanceof TbLinkSpanGroup)) {
                TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                if (tbLinkSpanGroup.u() == TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK && StringHelper.equals(a2Var.w1(), tbLinkSpanGroup.v())) {
                    String x1 = a2Var.x1();
                    if (k.isEmpty(x1)) {
                        x1 = a2Var.C();
                    }
                    tbLinkSpanGroup.z(x1);
                    int f2 = tbLinkSpanGroup.f();
                    int c2 = tbLinkSpanGroup.c();
                    tbLinkSpanGroup.E();
                    h(this.f13257d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                    y();
                }
            }
        }
        this.f13256c.addTextChangedListener(this.f13254a);
    }

    public void B() {
        TextWatcher textWatcher;
        SpanGroupEditText spanGroupEditText = this.f13256c;
        if (spanGroupEditText == null || (textWatcher = this.f13254a) == null) {
            return;
        }
        spanGroupEditText.removeTextChangedListener(textWatcher);
    }

    public final void C(String str, int i2) {
        long forumId = this.f13256c.getForumId();
        int u = u() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.f13255b);
        requestUrlParserNetMessage.setParams(forumId, u, str, i2);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    public final void D(String str) {
        int k = l.k(TbadkCoreApplication.getInst());
        int i2 = l.i(TbadkCoreApplication.getInst());
        float f2 = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.f13255b);
        requestGetMyPostNetMessage.setParams(d.a.c.e.m.b.f(str, 0L), 0L, 0L, k, i2, f2, i3);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    public final boolean E() {
        int selectionStart;
        SpanGroupEditText spanGroupEditText = this.f13256c;
        if (spanGroupEditText != null && (selectionStart = spanGroupEditText.getSelectionStart()) == this.f13256c.getSelectionEnd()) {
            Iterator<d.a.i0.r.f0.p.a> it = this.f13257d.iterator();
            while (it.hasNext()) {
                d.a.i0.r.f0.p.a next = it.next();
                if (next.h() && next.c() == selectionStart) {
                    Selection.setSelection(this.f13256c.getText(), next.f(), next.c());
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void F(a.InterfaceC1051a interfaceC1051a) {
        this.f13259f = interfaceC1051a;
    }

    public void G(boolean z) {
        this.f13258e = z;
    }

    public void g() {
        TextWatcher textWatcher;
        SpanGroupEditText spanGroupEditText = this.f13256c;
        if (spanGroupEditText == null || (textWatcher = this.f13254a) == null) {
            return;
        }
        spanGroupEditText.addTextChangedListener(textWatcher);
    }

    public synchronized void h(LinkedList<d.a.i0.r.f0.p.a> linkedList, int i2, int i3, int i4, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Iterator<d.a.i0.r.f0.p.a> it = linkedList.iterator();
        while (it.hasNext()) {
            d.a.i0.r.f0.p.a next = it.next();
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
        if (!ListUtils.isEmpty(this.f13257d) && !TextUtils.isEmpty(str)) {
            Iterator<d.a.i0.r.f0.p.a> it = this.f13257d.iterator();
            while (it.hasNext()) {
                d.a.i0.r.f0.p.a next = it.next();
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
        Iterator<d.a.i0.r.f0.p.a> it = this.f13257d.iterator();
        while (it.hasNext()) {
            if (!it.next().h()) {
                it.remove();
            }
        }
    }

    public void k() {
        this.f13257d.clear();
    }

    public void l(int i2, int i3) {
        if (w() || i2 > i3 || i2 >= this.f13256c.length()) {
            return;
        }
        this.f13256c.removeTextChangedListener(this.f13254a);
        this.f13256c.getText().delete(i2, i3);
        h(this.f13257d, i2, i3, i2 - i3, false, ChangeSpanGroupType.DEFAULT);
        j();
        this.f13256c.addTextChangedListener(this.f13254a);
    }

    public synchronized void m() {
        if (this.f13256c == null) {
            return;
        }
        Editable text = this.f13256c.getText();
        Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
        if (matcher.find()) {
            String group = matcher.group();
            String substring = group.substring(18, group.length() - 7);
            int start = matcher.start();
            int end = matcher.end();
            d.a.j0.w0.a aVar = null;
            try {
                aVar = d.a.j0.w0.a.g(new JSONObject(substring));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (aVar != null) {
                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                v b2 = v.b(tbLinkSpanGroup, aVar);
                tbLinkSpanGroup.a(text, start, end, (int) this.f13256c.getTextSize());
                b2.l = substring;
                tbLinkSpanGroup.z(b2.f49276h);
                tbLinkSpanGroup.r();
                h(this.f13257d, end, end, (tbLinkSpanGroup.w() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                tbLinkSpanGroup.k(this.f13259f);
                this.f13257d.add(tbLinkSpanGroup);
            }
            m();
        }
    }

    public final synchronized void n() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.f13256c != null && this.f13258e) {
            Editable text = this.f13256c.getText();
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
                if (this.f13256c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                    if (UrlManager.getInstance().isPbUrl(subSequence)) {
                        tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                        String tidFromPbUrl = UrlManager.getInstance().getTidFromPbUrl(subSequence.toString());
                        tbLinkSpanGroup.B(tidFromPbUrl);
                        D(tidFromPbUrl);
                    } else {
                        tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                    }
                    tbLinkSpanGroup.a(text, start, end2, (int) this.f13256c.getTextSize());
                    tbLinkSpanGroup.r();
                    tbLinkSpanGroup.k(this.f13259f);
                    this.f13257d.add(tbLinkSpanGroup);
                } else if (this.f13256c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                    TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                    tbLinkSpanGroup2.a(text, start, end2, (int) this.f13256c.getTextSize());
                    tbLinkSpanGroup2.r();
                    C(subSequence.toString(), tbLinkSpanGroup2.e());
                    tbLinkSpanGroup2.k(this.f13259f);
                    this.f13257d.add(tbLinkSpanGroup2);
                }
                n();
            }
        }
    }

    public int o() {
        v t;
        int i2 = 0;
        if (ListUtils.isEmpty(this.f13257d)) {
            return 0;
        }
        Iterator<d.a.i0.r.f0.p.a> it = this.f13257d.iterator();
        while (it.hasNext()) {
            d.a.i0.r.f0.p.a next = it.next();
            if ((next instanceof TbLinkSpanGroup) && next.h() && (t = ((TbLinkSpanGroup) next).t()) != null && t.f49274f == 2) {
                i2++;
            }
        }
        return i2;
    }

    public synchronized String p() {
        if (this.f13256c == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f13256c.getText());
        LinkedList<d.a.i0.r.f0.p.a> linkedList = new LinkedList<>();
        Iterator<d.a.i0.r.f0.p.a> it = this.f13257d.iterator();
        while (it.hasNext()) {
            d.a.i0.r.f0.p.a next = it.next();
            if (next.h()) {
                if (next instanceof TbLinkSpanGroup) {
                    linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                } else {
                    linkedList.add(next);
                }
            }
        }
        Iterator<d.a.i0.r.f0.p.a> it2 = linkedList.iterator();
        while (it2.hasNext()) {
            d.a.i0.r.f0.p.a next2 = it2.next();
            int f2 = next2.f();
            int c2 = next2.c();
            next2.p(spannableStringBuilder);
            h(linkedList, f2, c2, (next2.c() - next2.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
        }
        return spannableStringBuilder.toString();
    }

    public d.a.i0.r.f0.p.a q(int i2) {
        Iterator<d.a.i0.r.f0.p.a> it = this.f13257d.iterator();
        while (it.hasNext()) {
            d.a.i0.r.f0.p.a next = it.next();
            if (next.h() && i2 > next.f() && i2 < next.c()) {
                return next;
            }
        }
        return null;
    }

    public d.a.i0.r.f0.p.a r(int i2) {
        Iterator<d.a.i0.r.f0.p.a> it = this.f13257d.iterator();
        while (it.hasNext()) {
            d.a.i0.r.f0.p.a next = it.next();
            if (next.h() && i2 == next.e()) {
                return next;
            }
        }
        return null;
    }

    public LinkedList<d.a.i0.r.f0.p.a> s() {
        return this.f13257d;
    }

    public synchronized String t() {
        if (this.f13256c == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f13256c.getText());
        LinkedList<d.a.i0.r.f0.p.a> linkedList = new LinkedList<>();
        Iterator<d.a.i0.r.f0.p.a> it = this.f13257d.iterator();
        while (it.hasNext()) {
            d.a.i0.r.f0.p.a next = it.next();
            if (next.h()) {
                if (next instanceof TbLinkSpanGroup) {
                    linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                } else {
                    linkedList.add(next);
                }
            }
        }
        Iterator<d.a.i0.r.f0.p.a> it2 = linkedList.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            d.a.i0.r.f0.p.a next2 = it2.next();
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
        Iterator<d.a.i0.r.f0.p.a> it = this.f13257d.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            d.a.i0.r.f0.p.a next = it.next();
            if (next.h() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).u() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                i2++;
            }
        }
        return i2;
    }

    public void v(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.f13257d != null) {
            tbLinkSpanGroup.k(this.f13259f);
            this.f13257d.add(tbLinkSpanGroup);
        }
    }

    public boolean w() {
        SpanGroupEditText spanGroupEditText = this.f13256c;
        return spanGroupEditText == null || spanGroupEditText.getText().length() <= 0;
    }

    public final boolean x(CharSequence charSequence, int i2) {
        return charSequence != null && charSequence.length() != 0 && i2 >= 0 && charSequence.charAt(i2) == '\n';
    }

    public final void y() {
        if (w()) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.f13256c.getText());
        int selectionEnd = Selection.getSelectionEnd(this.f13256c.getText());
        d.a.i0.r.f0.p.a q = q(selectionStart);
        d.a.i0.r.f0.p.a q2 = q(selectionEnd);
        if (q instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f13256c.getText(), q.f(), q.f());
        } else if (q2 instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f13256c.getText(), q2.f(), q2.f());
        }
    }

    public final synchronized void z(d.a.i0.r.f0.p.d dVar, int i2) {
        if (dVar != null) {
            if (dVar.f48905a == 1 && dVar.f48906b != 3) {
                this.f13256c.removeTextChangedListener(this.f13254a);
                Iterator<d.a.i0.r.f0.p.a> it = this.f13257d.iterator();
                while (it.hasNext()) {
                    d.a.i0.r.f0.p.a next = it.next();
                    if (next.h() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.e() == i2 && (dVar.f48906b == 1 || dVar.f48906b == 2)) {
                            tbLinkSpanGroup.z(dVar.f48909e);
                            if (dVar.f48906b == 1) {
                                tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.f48906b == 2) {
                                tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            v.c(tbLinkSpanGroup, dVar);
                            if (this.f13259f != null) {
                                this.f13259f.a(i2, true);
                            }
                            int f2 = tbLinkSpanGroup.f();
                            int c2 = tbLinkSpanGroup.c();
                            tbLinkSpanGroup.E();
                            h(this.f13257d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                            y();
                        }
                    }
                }
                this.f13256c.addTextChangedListener(this.f13254a);
            }
        }
    }
}
