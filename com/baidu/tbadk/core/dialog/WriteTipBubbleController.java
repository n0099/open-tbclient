package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.j0.b0.e;
/* loaded from: classes3.dex */
public class WriteTipBubbleController {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f12914a;

    /* renamed from: b  reason: collision with root package name */
    public e f12915b;

    /* renamed from: c  reason: collision with root package name */
    public b f12916c;

    /* loaded from: classes3.dex */
    public enum ANCHOR_VIEW_FROM {
        FROM_EDITOR_TOOL,
        FROM_EDIT_TEXT,
        FROM_PB_REPLY
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12917e;

        public a(String str) {
            this.f12917e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteTipBubbleController.this.f12916c != null) {
                WriteTipBubbleController.this.f12916c.a(view, this.f12917e);
                if (WriteTipBubbleController.this.f12915b == null || !WriteTipBubbleController.this.f12915b.I()) {
                    return;
                }
                WriteTipBubbleController.this.f12915b.H();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, String str);
    }

    public WriteTipBubbleController(TbPageContext tbPageContext, b bVar) {
        this.f12914a = tbPageContext;
        this.f12916c = bVar;
    }

    public void c() {
        e eVar = this.f12915b;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void d(@NonNull View view, @NonNull String str, @NonNull String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.f12914a == null || view == null || k.isEmpty(str) || k.isEmpty(str2)) {
            return;
        }
        if (this.f12915b == null) {
            e eVar = new e(this.f12914a, view);
            this.f12915b = eVar;
            eVar.c0(R.drawable.pic_post_findlink);
            this.f12915b.R(2);
            this.f12915b.P(true);
            this.f12915b.b0(19);
            this.f12915b.W(R.color.CAM_X0105);
            this.f12915b.M(5000);
        }
        if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
            this.f12915b.N(32);
            this.f12915b.K(2);
            int dimensionPixelSize = this.f12914a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize2 = this.f12914a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f12915b.Y(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
            this.f12915b.f0(0);
            this.f12915b.g0(-dimensionPixelSize2);
            this.f12915b.O(R.dimen.tbds177);
            this.f12915b.e0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
            this.f12915b.N(32);
            this.f12915b.K(5);
            int dimensionPixelSize3 = this.f12914a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize4 = this.f12914a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            this.f12915b.Y(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
            this.f12915b.f0(0);
            this.f12915b.g0(-dimensionPixelSize4);
            this.f12915b.O(R.dimen.tbds177);
            this.f12915b.e0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
            this.f12915b.N(16);
            this.f12915b.K(2);
            int dimensionPixelSize5 = this.f12914a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize6 = this.f12914a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f12915b.Y(dimensionPixelSize5, 0, dimensionPixelSize5, dimensionPixelSize5);
            this.f12915b.f0(0);
            this.f12915b.g0(-dimensionPixelSize6);
            this.f12915b.O(R.dimen.tbds177);
            this.f12915b.e0(R.dimen.tbds484);
        }
        this.f12915b.L(new a(str2));
        this.f12915b.h0(str);
        TiebaStatic.log("c13801");
    }
}
