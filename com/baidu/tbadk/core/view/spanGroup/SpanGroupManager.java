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
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.r.f0.p.a;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.v;
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
    public BdUniqueId f13293b;

    /* renamed from: c  reason: collision with root package name */
    public SpanGroupEditText f13294c;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1112a f13297f;

    /* renamed from: a  reason: collision with root package name */
    public TextWatcher f13292a = new a();

    /* renamed from: d  reason: collision with root package name */
    public LinkedList<d.b.i0.r.f0.p.a> f13295d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    public boolean f13296e = true;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f13298g = new b(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.g.a f13299h = new c(CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* loaded from: classes3.dex */
    public enum ChangeSpanGroupType {
        DEFAULT,
        ON_TEXT_CHANGE
    }

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public int f13300e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f13301f = -1;

        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            SpanGroupManager.this.n();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f13300e = Selection.getSelectionStart(charSequence);
            this.f13301f = Selection.getSelectionEnd(charSequence);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SpanGroupManager spanGroupManager = SpanGroupManager.this;
            spanGroupManager.h(spanGroupManager.f13295d, this.f13300e, this.f13301f, i3 - i2, false, ChangeSpanGroupType.ON_TEXT_CHANGE);
            SpanGroupManager.this.j();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.c.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UrlParserResIdl responseData;
            int i;
            String str = null;
            if (responsedMessage instanceof UrlParserHttpResponseMessage) {
                responseData = ((UrlParserHttpResponseMessage) responsedMessage).getResponseData();
            } else {
                responseData = responsedMessage instanceof UrlParserSocketResponseMessage ? ((UrlParserSocketResponseMessage) responsedMessage).getResponseData() : null;
            }
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof RequestUrlParserNetMessage)) {
                i = 0;
            } else {
                RequestUrlParserNetMessage requestUrlParserNetMessage = (RequestUrlParserNetMessage) responsedMessage.getOrginalMessage().getExtra();
                str = requestUrlParserNetMessage.getUrl();
                i = requestUrlParserNetMessage.getSpanGroupId();
            }
            if (responseData == null || responseData.data == null || i == 0) {
                return;
            }
            d.b.i0.r.f0.p.d dVar = new d.b.i0.r.f0.p.d();
            dVar.a(responseData);
            dVar.f51294c = str;
            SpanGroupManager.this.z(dVar, i);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.b.c.c.g.a {
        public c(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
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
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 67 && keyEvent.getAction() == 0) {
                return SpanGroupManager.this.E();
            }
            return false;
        }
    }

    public SpanGroupManager(@NonNull SpanGroupEditText spanGroupEditText, BdUniqueId bdUniqueId) {
        if (spanGroupEditText == null) {
            return;
        }
        this.f13293b = bdUniqueId;
        this.f13294c = spanGroupEditText;
        spanGroupEditText.addTextChangedListener(this.f13292a);
        this.f13294c.setEditableFactory(new d.b.i0.r.f0.p.b(new d.b.i0.r.f0.p.c(this)));
        this.f13294c.setSoftKeyListener(new d());
        this.f13299h.setTag(this.f13293b);
        MessageManager.getInstance().registerListener(this.f13299h);
        this.f13298g.setTag(this.f13293b);
        MessageManager.getInstance().registerListener(this.f13298g);
    }

    public final synchronized void A(a2 a2Var) {
        this.f13294c.removeTextChangedListener(this.f13292a);
        Iterator<d.b.i0.r.f0.p.a> it = this.f13295d.iterator();
        while (it.hasNext()) {
            d.b.i0.r.f0.p.a next = it.next();
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
                    h(this.f13295d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                    y();
                }
            }
        }
        this.f13294c.addTextChangedListener(this.f13292a);
    }

    public void B() {
        TextWatcher textWatcher;
        SpanGroupEditText spanGroupEditText = this.f13294c;
        if (spanGroupEditText == null || (textWatcher = this.f13292a) == null) {
            return;
        }
        spanGroupEditText.removeTextChangedListener(textWatcher);
    }

    public final void C(String str, int i) {
        long forumId = this.f13294c.getForumId();
        int u = u() + 1;
        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
        requestUrlParserNetMessage.setTag(this.f13293b);
        requestUrlParserNetMessage.setParams(forumId, u, str, i);
        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
    }

    public final void D(String str) {
        int k = l.k(TbadkCoreApplication.getInst());
        int i = l.i(TbadkCoreApplication.getInst());
        float f2 = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().density;
        int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
        RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
        requestGetMyPostNetMessage.setTag(this.f13293b);
        requestGetMyPostNetMessage.setParams(d.b.c.e.m.b.f(str, 0L), 0L, 0L, k, i, f2, i2);
        MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
    }

    public final boolean E() {
        int selectionStart;
        SpanGroupEditText spanGroupEditText = this.f13294c;
        if (spanGroupEditText != null && (selectionStart = spanGroupEditText.getSelectionStart()) == this.f13294c.getSelectionEnd()) {
            Iterator<d.b.i0.r.f0.p.a> it = this.f13295d.iterator();
            while (it.hasNext()) {
                d.b.i0.r.f0.p.a next = it.next();
                if (next.h() && next.c() == selectionStart) {
                    Selection.setSelection(this.f13294c.getText(), next.f(), next.c());
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void F(a.InterfaceC1112a interfaceC1112a) {
        this.f13297f = interfaceC1112a;
    }

    public void G(boolean z) {
        this.f13296e = z;
    }

    public void g() {
        TextWatcher textWatcher;
        SpanGroupEditText spanGroupEditText = this.f13294c;
        if (spanGroupEditText == null || (textWatcher = this.f13292a) == null) {
            return;
        }
        spanGroupEditText.addTextChangedListener(textWatcher);
    }

    public synchronized void h(LinkedList<d.b.i0.r.f0.p.a> linkedList, int i, int i2, int i3, boolean z, ChangeSpanGroupType changeSpanGroupType) {
        Iterator<d.b.i0.r.f0.p.a> it = linkedList.iterator();
        while (it.hasNext()) {
            d.b.i0.r.f0.p.a next = it.next();
            if (next.h() && (!z || next.f() != i)) {
                if (i <= next.f() && i2 <= next.f()) {
                    next.m(next.f() + i3);
                    next.j(next.c() + i3);
                } else if (i <= next.f() && i2 > next.f()) {
                    next.o(false);
                } else if (i > next.f() && i < next.c() && i2 < next.c()) {
                    next.j(next.c() + i3);
                } else if (i > next.f() && i < next.c() && i2 >= next.c()) {
                    next.o(false);
                } else if (changeSpanGroupType == ChangeSpanGroupType.ON_TEXT_CHANGE && i == i2 && Math.abs(i3) == next.c() - next.f() && next.c() <= i2 && next.c() > i2 + i3) {
                    next.o(false);
                }
            }
        }
    }

    public boolean i(String str) {
        v t;
        if (!ListUtils.isEmpty(this.f13295d) && !TextUtils.isEmpty(str)) {
            Iterator<d.b.i0.r.f0.p.a> it = this.f13295d.iterator();
            while (it.hasNext()) {
                d.b.i0.r.f0.p.a next = it.next();
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
        Iterator<d.b.i0.r.f0.p.a> it = this.f13295d.iterator();
        while (it.hasNext()) {
            if (!it.next().h()) {
                it.remove();
            }
        }
    }

    public void k() {
        this.f13295d.clear();
    }

    public void l(int i, int i2) {
        if (w() || i > i2 || i >= this.f13294c.length()) {
            return;
        }
        this.f13294c.removeTextChangedListener(this.f13292a);
        this.f13294c.getText().delete(i, i2);
        h(this.f13295d, i, i2, i - i2, false, ChangeSpanGroupType.DEFAULT);
        j();
        this.f13294c.addTextChangedListener(this.f13292a);
    }

    public synchronized void m() {
        if (this.f13294c == null) {
            return;
        }
        Editable text = this.f13294c.getText();
        Matcher matcher = Pattern.compile("#\\(commodity,commo_[\\s\\S]+?_commo\\)").matcher(text);
        if (matcher.find()) {
            String group = matcher.group();
            String substring = group.substring(18, group.length() - 7);
            int start = matcher.start();
            int end = matcher.end();
            d.b.j0.w0.a aVar = null;
            try {
                aVar = d.b.j0.w0.a.g(new JSONObject(substring));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (aVar != null) {
                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                v b2 = v.b(tbLinkSpanGroup, aVar);
                tbLinkSpanGroup.a(text, start, end, (int) this.f13294c.getTextSize());
                b2.l = substring;
                tbLinkSpanGroup.z(b2.f51643h);
                tbLinkSpanGroup.r();
                h(this.f13295d, end, end, (tbLinkSpanGroup.w() - end) + start, false, ChangeSpanGroupType.DEFAULT);
                tbLinkSpanGroup.k(this.f13297f);
                this.f13295d.add(tbLinkSpanGroup);
            }
            m();
        }
    }

    public final synchronized void n() {
        TbLinkSpanGroup tbLinkSpanGroup;
        if (this.f13294c != null && this.f13296e) {
            Editable text = this.f13294c.getText();
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
                if (this.f13294c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT) {
                    if (UrlManager.getInstance().isPbUrl(subSequence)) {
                        tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                        String tidFromPbUrl = UrlManager.getInstance().getTidFromPbUrl(subSequence.toString());
                        tbLinkSpanGroup.B(tidFromPbUrl);
                        D(tidFromPbUrl);
                    } else {
                        tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                    }
                    tbLinkSpanGroup.a(text, start, end2, (int) this.f13294c.getTextSize());
                    tbLinkSpanGroup.r();
                    tbLinkSpanGroup.k(this.f13297f);
                    this.f13295d.add(tbLinkSpanGroup);
                } else if (this.f13294c.getType() == SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY) {
                    TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.DEAULT);
                    tbLinkSpanGroup2.a(text, start, end2, (int) this.f13294c.getTextSize());
                    tbLinkSpanGroup2.r();
                    C(subSequence.toString(), tbLinkSpanGroup2.e());
                    tbLinkSpanGroup2.k(this.f13297f);
                    this.f13295d.add(tbLinkSpanGroup2);
                }
                n();
            }
        }
    }

    public int o() {
        v t;
        int i = 0;
        if (ListUtils.isEmpty(this.f13295d)) {
            return 0;
        }
        Iterator<d.b.i0.r.f0.p.a> it = this.f13295d.iterator();
        while (it.hasNext()) {
            d.b.i0.r.f0.p.a next = it.next();
            if ((next instanceof TbLinkSpanGroup) && next.h() && (t = ((TbLinkSpanGroup) next).t()) != null && t.f51641f == 2) {
                i++;
            }
        }
        return i;
    }

    public synchronized String p() {
        if (this.f13294c == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f13294c.getText());
        LinkedList<d.b.i0.r.f0.p.a> linkedList = new LinkedList<>();
        Iterator<d.b.i0.r.f0.p.a> it = this.f13295d.iterator();
        while (it.hasNext()) {
            d.b.i0.r.f0.p.a next = it.next();
            if (next.h()) {
                if (next instanceof TbLinkSpanGroup) {
                    linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                } else {
                    linkedList.add(next);
                }
            }
        }
        Iterator<d.b.i0.r.f0.p.a> it2 = linkedList.iterator();
        while (it2.hasNext()) {
            d.b.i0.r.f0.p.a next2 = it2.next();
            int f2 = next2.f();
            int c2 = next2.c();
            next2.p(spannableStringBuilder);
            h(linkedList, f2, c2, (next2.c() - next2.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
        }
        return spannableStringBuilder.toString();
    }

    public d.b.i0.r.f0.p.a q(int i) {
        Iterator<d.b.i0.r.f0.p.a> it = this.f13295d.iterator();
        while (it.hasNext()) {
            d.b.i0.r.f0.p.a next = it.next();
            if (next.h() && i > next.f() && i < next.c()) {
                return next;
            }
        }
        return null;
    }

    public d.b.i0.r.f0.p.a r(int i) {
        Iterator<d.b.i0.r.f0.p.a> it = this.f13295d.iterator();
        while (it.hasNext()) {
            d.b.i0.r.f0.p.a next = it.next();
            if (next.h() && i == next.e()) {
                return next;
            }
        }
        return null;
    }

    public LinkedList<d.b.i0.r.f0.p.a> s() {
        return this.f13295d;
    }

    public synchronized String t() {
        if (this.f13294c == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f13294c.getText());
        LinkedList<d.b.i0.r.f0.p.a> linkedList = new LinkedList<>();
        Iterator<d.b.i0.r.f0.p.a> it = this.f13295d.iterator();
        while (it.hasNext()) {
            d.b.i0.r.f0.p.a next = it.next();
            if (next.h()) {
                if (next instanceof TbLinkSpanGroup) {
                    linkedList.add(TbLinkSpanGroup.x((TbLinkSpanGroup) next, spannableStringBuilder));
                } else {
                    linkedList.add(next);
                }
            }
        }
        Iterator<d.b.i0.r.f0.p.a> it2 = linkedList.iterator();
        int i = 0;
        while (it2.hasNext()) {
            d.b.i0.r.f0.p.a next2 = it2.next();
            int f2 = next2.f();
            int c2 = next2.c();
            next2.q(spannableStringBuilder, i);
            h(linkedList, f2, c2, (next2.c() - next2.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
            i++;
        }
        return spannableStringBuilder.toString();
    }

    public String toString() {
        return p();
    }

    public final int u() {
        Iterator<d.b.i0.r.f0.p.a> it = this.f13295d.iterator();
        int i = 0;
        while (it.hasNext()) {
            d.b.i0.r.f0.p.a next = it.next();
            if (next.h() && (next instanceof TbLinkSpanGroup) && ((TbLinkSpanGroup) next).u() != TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK) {
                i++;
            }
        }
        return i;
    }

    public void v(TbLinkSpanGroup tbLinkSpanGroup) {
        if (this.f13295d != null) {
            tbLinkSpanGroup.k(this.f13297f);
            this.f13295d.add(tbLinkSpanGroup);
        }
    }

    public boolean w() {
        SpanGroupEditText spanGroupEditText = this.f13294c;
        return spanGroupEditText == null || spanGroupEditText.getText().length() <= 0;
    }

    public final boolean x(CharSequence charSequence, int i) {
        return charSequence != null && charSequence.length() != 0 && i >= 0 && charSequence.charAt(i) == '\n';
    }

    public final void y() {
        if (w()) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.f13294c.getText());
        int selectionEnd = Selection.getSelectionEnd(this.f13294c.getText());
        d.b.i0.r.f0.p.a q = q(selectionStart);
        d.b.i0.r.f0.p.a q2 = q(selectionEnd);
        if (q instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f13294c.getText(), q.f(), q.f());
        } else if (q2 instanceof TbLinkSpanGroup) {
            Selection.setSelection(this.f13294c.getText(), q2.f(), q2.f());
        }
    }

    public final synchronized void z(d.b.i0.r.f0.p.d dVar, int i) {
        if (dVar != null) {
            if (dVar.f51292a == 1 && dVar.f51293b != 3) {
                this.f13294c.removeTextChangedListener(this.f13292a);
                Iterator<d.b.i0.r.f0.p.a> it = this.f13295d.iterator();
                while (it.hasNext()) {
                    d.b.i0.r.f0.p.a next = it.next();
                    if (next.h() && (next instanceof TbLinkSpanGroup)) {
                        TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                        if (tbLinkSpanGroup.e() == i && (dVar.f51293b == 1 || dVar.f51293b == 2)) {
                            tbLinkSpanGroup.z(dVar.f51296e);
                            if (dVar.f51293b == 1) {
                                tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.INTERNAL_LINK);
                            } else if (dVar.f51293b == 2) {
                                tbLinkSpanGroup.A(TbLinkSpanGroup.LINK_TYPE.PARSABLE_EXTERNAL_LINK);
                            }
                            v.c(tbLinkSpanGroup, dVar);
                            if (this.f13297f != null) {
                                this.f13297f.a(i, true);
                            }
                            int f2 = tbLinkSpanGroup.f();
                            int c2 = tbLinkSpanGroup.c();
                            tbLinkSpanGroup.E();
                            h(this.f13295d, f2, c2, (tbLinkSpanGroup.c() - tbLinkSpanGroup.f()) - (c2 - f2), true, ChangeSpanGroupType.DEFAULT);
                            y();
                        }
                    }
                }
                this.f13294c.addTextChangedListener(this.f13292a);
            }
        }
    }
}
