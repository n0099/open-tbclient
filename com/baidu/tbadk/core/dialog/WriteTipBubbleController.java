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
    public TbPageContext f13244a;

    /* renamed from: b  reason: collision with root package name */
    public e f13245b;

    /* renamed from: c  reason: collision with root package name */
    public b f13246c;

    /* loaded from: classes3.dex */
    public enum ANCHOR_VIEW_FROM {
        FROM_EDITOR_TOOL,
        FROM_EDIT_TEXT,
        FROM_PB_REPLY
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f13247e;

        public a(String str) {
            this.f13247e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteTipBubbleController.this.f13246c != null) {
                WriteTipBubbleController.this.f13246c.a(view, this.f13247e);
                if (WriteTipBubbleController.this.f13245b == null || !WriteTipBubbleController.this.f13245b.I()) {
                    return;
                }
                WriteTipBubbleController.this.f13245b.H();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, String str);
    }

    public WriteTipBubbleController(TbPageContext tbPageContext, b bVar) {
        this.f13244a = tbPageContext;
        this.f13246c = bVar;
    }

    public void c() {
        e eVar = this.f13245b;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void d(@NonNull View view, @NonNull String str, @NonNull String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.f13244a == null || view == null || k.isEmpty(str) || k.isEmpty(str2)) {
            return;
        }
        if (this.f13245b == null) {
            e eVar = new e(this.f13244a, view);
            this.f13245b = eVar;
            eVar.c0(R.drawable.pic_post_findlink);
            this.f13245b.R(2);
            this.f13245b.P(true);
            this.f13245b.b0(19);
            this.f13245b.W(R.color.CAM_X0105);
            this.f13245b.M(5000);
        }
        if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
            this.f13245b.N(32);
            this.f13245b.K(2);
            int dimensionPixelSize = this.f13244a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize2 = this.f13244a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f13245b.Y(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
            this.f13245b.f0(0);
            this.f13245b.g0(-dimensionPixelSize2);
            this.f13245b.O(R.dimen.tbds177);
            this.f13245b.e0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
            this.f13245b.N(32);
            this.f13245b.K(5);
            int dimensionPixelSize3 = this.f13244a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize4 = this.f13244a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            this.f13245b.Y(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
            this.f13245b.f0(0);
            this.f13245b.g0(-dimensionPixelSize4);
            this.f13245b.O(R.dimen.tbds177);
            this.f13245b.e0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
            this.f13245b.N(16);
            this.f13245b.K(2);
            int dimensionPixelSize5 = this.f13244a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize6 = this.f13244a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f13245b.Y(dimensionPixelSize5, 0, dimensionPixelSize5, dimensionPixelSize5);
            this.f13245b.f0(0);
            this.f13245b.g0(-dimensionPixelSize6);
            this.f13245b.O(R.dimen.tbds177);
            this.f13245b.e0(R.dimen.tbds484);
        }
        this.f13245b.L(new a(str2));
        this.f13245b.h0(str);
        TiebaStatic.log("c13801");
    }
}
