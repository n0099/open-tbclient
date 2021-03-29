package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import d.b.i0.b0.e;
/* loaded from: classes3.dex */
public class WriteTipBubbleController {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f13245a;

    /* renamed from: b  reason: collision with root package name */
    public e f13246b;

    /* renamed from: c  reason: collision with root package name */
    public b f13247c;

    /* loaded from: classes3.dex */
    public enum ANCHOR_VIEW_FROM {
        FROM_EDITOR_TOOL,
        FROM_EDIT_TEXT,
        FROM_PB_REPLY
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f13248e;

        public a(String str) {
            this.f13248e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteTipBubbleController.this.f13247c != null) {
                WriteTipBubbleController.this.f13247c.a(view, this.f13248e);
                if (WriteTipBubbleController.this.f13246b == null || !WriteTipBubbleController.this.f13246b.I()) {
                    return;
                }
                WriteTipBubbleController.this.f13246b.H();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, String str);
    }

    public WriteTipBubbleController(TbPageContext tbPageContext, b bVar) {
        this.f13245a = tbPageContext;
        this.f13247c = bVar;
    }

    public void c() {
        e eVar = this.f13246b;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void d(@NonNull View view, @NonNull String str, @NonNull String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.f13245a == null || view == null || k.isEmpty(str) || k.isEmpty(str2)) {
            return;
        }
        if (this.f13246b == null) {
            e eVar = new e(this.f13245a, view);
            this.f13246b = eVar;
            eVar.c0(R.drawable.pic_post_findlink);
            this.f13246b.R(2);
            this.f13246b.P(true);
            this.f13246b.b0(19);
            this.f13246b.W(R.color.CAM_X0105);
            this.f13246b.M(5000);
        }
        if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
            this.f13246b.N(32);
            this.f13246b.K(2);
            int dimensionPixelSize = this.f13245a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize2 = this.f13245a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f13246b.Y(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
            this.f13246b.f0(0);
            this.f13246b.g0(-dimensionPixelSize2);
            this.f13246b.O(R.dimen.tbds177);
            this.f13246b.e0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
            this.f13246b.N(32);
            this.f13246b.K(5);
            int dimensionPixelSize3 = this.f13245a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize4 = this.f13245a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            this.f13246b.Y(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
            this.f13246b.f0(0);
            this.f13246b.g0(-dimensionPixelSize4);
            this.f13246b.O(R.dimen.tbds177);
            this.f13246b.e0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
            this.f13246b.N(16);
            this.f13246b.K(2);
            int dimensionPixelSize5 = this.f13245a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize6 = this.f13245a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f13246b.Y(dimensionPixelSize5, 0, dimensionPixelSize5, dimensionPixelSize5);
            this.f13246b.f0(0);
            this.f13246b.g0(-dimensionPixelSize6);
            this.f13246b.O(R.dimen.tbds177);
            this.f13246b.e0(R.dimen.tbds484);
        }
        this.f13246b.L(new a(str2));
        this.f13246b.h0(str);
        TiebaStatic.log("c13801");
    }
}
