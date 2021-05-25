package com.baidu.tbadk.core.view.spanGroup;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.m0.r.f0.p.a;
import d.a.m0.r.q.v;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TbLinkSpanGroup extends a<TbLinkSpanGroup> {
    public static final String r = TbadkCoreApplication.getInst().getString(R.string.web_page_link);

    /* renamed from: i  reason: collision with root package name */
    public v f12512i;
    public LINK_TYPE j;
    public int k;
    public CharSequence l;
    public CharSequence m;
    public String n;
    public String o;
    public String p;
    public int q;

    /* loaded from: classes3.dex */
    public enum LINK_TYPE {
        INTERNAL_LINK,
        PARSED_EXTERNAL_LINK,
        PARSABLE_EXTERNAL_LINK,
        UNPAESABLE_EXTERNAL_LINK,
        DEAULT
    }

    public TbLinkSpanGroup() {
        this.k = 0;
        this.j = LINK_TYPE.DEAULT;
    }

    public static TbLinkSpanGroup x(@NonNull TbLinkSpanGroup tbLinkSpanGroup, @NonNull Editable editable) {
        TbLinkSpanGroup tbLinkSpanGroup2 = new TbLinkSpanGroup();
        tbLinkSpanGroup2.s(tbLinkSpanGroup);
        tbLinkSpanGroup2.n(editable);
        return tbLinkSpanGroup2;
    }

    public void A(LINK_TYPE link_type) {
        this.j = link_type;
    }

    public void B(String str) {
        this.n = str;
    }

    public void C(String str) {
        this.l = str;
    }

    public void D() {
        if (this.k == 1) {
            return;
        }
        this.k = 1;
        this.p = r;
        String str = "[p]" + r + ((Object) this.m);
        this.q = str.length();
        i(str);
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.b(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        l(eMRichTextAnyIconSpan, f(), f() + 3, 33);
        l(new TbLinkForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), f() + 3, c(), 33);
    }

    public void E() {
        if (this.k == 2 || k.isEmpty(this.o)) {
            return;
        }
        this.k = 2;
        this.p = StringHelper.cutStringWithEllipsisStrict(this.o, 40);
        String str = "[p]" + this.p + ((Object) this.m);
        this.q = str.length();
        i(str);
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_post_link16, R.color.CAM_X0304, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.b(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        l(eMRichTextAnyIconSpan, f(), f() + 3, 33);
        l(new TbLinkForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), f() + 3, c(), 33);
    }

    @Override // d.a.m0.r.f0.p.a
    public void a(Editable editable, int i2, int i3, int i4) {
        super.a(editable, i2, i3, i4);
        if (this.j == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            this.m = " ";
            return;
        }
        int i5 = i3 - 1;
        this.l = editable.subSequence(i2, i5);
        this.m = editable.subSequence(i5, i3);
    }

    @Override // d.a.m0.r.f0.p.a
    public void p(Editable editable) {
        v vVar = this.f12512i;
        if (vVar != null && vVar.f50137f == 2) {
            if (vVar.l != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("#(commodity,commo_");
                sb.append(this.f12512i.l);
                sb.append("_commo)");
                i(sb);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.l);
        sb2.append(this.m);
        i(sb2);
    }

    @Override // d.a.m0.r.f0.p.a
    public void q(Editable editable, int i2) {
        if (this.f12512i == null) {
            String str = k.isEmpty(this.n) ? "0" : this.n;
            String str2 = (this.j == LINK_TYPE.INTERNAL_LINK && k.isEmpty(this.o)) ? "" : this.p;
            StringBuilder sb = new StringBuilder();
            sb.append("#(url,");
            sb.append(str);
            sb.append(",");
            sb.append(k.getUrlEncode(this.l.toString()));
            sb.append(",");
            sb.append(k.getUrlEncode(str2));
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append(this.m);
            i(sb);
            return;
        }
        LINK_TYPE link_type = this.j;
        if (link_type != LINK_TYPE.INTERNAL_LINK && link_type != LINK_TYPE.PARSABLE_EXTERNAL_LINK) {
            if (link_type == LINK_TYPE.PARSED_EXTERNAL_LINK) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("goods_id", this.f12512i.q);
                    jSONObject2.put(QuickPersistConfigConst.KEY_SPLASH_SORT, i2);
                    jSONObject2.put("title", this.f12512i.f50139h);
                    jSONObject2.put("url", this.f12512i.o);
                    StringBuilder sb2 = new StringBuilder();
                    jSONObject.put("goods", jSONObject2);
                    sb2.append("#(goods,");
                    sb2.append(k.getUrlEncode(jSONObject.toString()));
                    sb2.append(SmallTailInfo.EMOTION_SUFFIX);
                    sb2.append(this.m);
                    i(sb2);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        String str3 = this.p;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("#(url,0,");
        sb3.append(k.getUrlEncode(this.l.toString()));
        sb3.append(",");
        sb3.append(k.getUrlEncode(str3));
        sb3.append(",");
        sb3.append(k.getUrlEncode(this.f12512i.p));
        sb3.append(",");
        sb3.append(this.f12512i.f50140i);
        sb3.append(",");
        sb3.append(k.getUrlEncode(this.f12512i.j));
        sb3.append(",");
        sb3.append(i2);
        sb3.append(",");
        sb3.append(this.f12512i.s);
        sb3.append(SmallTailInfo.EMOTION_SUFFIX);
        sb3.append(this.m);
        i(sb3);
    }

    public void r() {
        o(true);
        if (this.j == LINK_TYPE.PARSED_EXTERNAL_LINK) {
            E();
        } else {
            D();
        }
    }

    public void s(TbLinkSpanGroup tbLinkSpanGroup) {
        super.b(tbLinkSpanGroup);
        this.j = tbLinkSpanGroup.j;
        this.k = tbLinkSpanGroup.k;
        this.l = tbLinkSpanGroup.l;
        this.m = tbLinkSpanGroup.m;
        this.n = tbLinkSpanGroup.n;
        this.o = tbLinkSpanGroup.o;
        this.p = tbLinkSpanGroup.p;
        this.f12512i = tbLinkSpanGroup.f12512i;
    }

    public v t() {
        return this.f12512i;
    }

    public LINK_TYPE u() {
        return this.j;
    }

    public String v() {
        return this.n;
    }

    public int w() {
        return this.q;
    }

    public void y(v vVar) {
        this.f12512i = vVar;
    }

    public void z(String str) {
        this.o = str;
    }

    public TbLinkSpanGroup(@NonNull LINK_TYPE link_type) {
        this.k = 0;
        this.j = link_type;
    }
}
