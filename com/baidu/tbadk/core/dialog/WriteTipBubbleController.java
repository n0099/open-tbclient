package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.n0.d0.e;
/* loaded from: classes3.dex */
public class WriteTipBubbleController {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f12140a;

    /* renamed from: b  reason: collision with root package name */
    public e f12141b;

    /* renamed from: c  reason: collision with root package name */
    public b f12142c;

    /* loaded from: classes3.dex */
    public enum ANCHOR_VIEW_FROM {
        FROM_EDITOR_TOOL,
        FROM_EDIT_TEXT,
        FROM_PB_REPLY
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12143e;

        public a(String str) {
            this.f12143e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteTipBubbleController.this.f12142c != null) {
                WriteTipBubbleController.this.f12142c.a(view, this.f12143e);
                if (WriteTipBubbleController.this.f12141b == null || !WriteTipBubbleController.this.f12141b.J()) {
                    return;
                }
                WriteTipBubbleController.this.f12141b.I();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, String str);
    }

    public WriteTipBubbleController(TbPageContext tbPageContext, b bVar) {
        this.f12140a = tbPageContext;
        this.f12142c = bVar;
    }

    public void c() {
        e eVar = this.f12141b;
        if (eVar != null) {
            eVar.I();
        }
    }

    public void d(@NonNull View view, @NonNull String str, @NonNull String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.f12140a == null || view == null || k.isEmpty(str) || k.isEmpty(str2)) {
            return;
        }
        if (this.f12141b == null) {
            e eVar = new e(this.f12140a, view);
            this.f12141b = eVar;
            eVar.g0(R.drawable.pic_post_findlink);
            this.f12141b.S(2);
            this.f12141b.Q(true);
            this.f12141b.f0(19);
            this.f12141b.X(R.color.CAM_X0105);
            this.f12141b.N(5000);
        }
        if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
            this.f12141b.O(32);
            this.f12141b.L(2);
            int dimensionPixelSize = this.f12140a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize2 = this.f12140a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f12141b.Z(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
            this.f12141b.j0(0);
            this.f12141b.k0(-dimensionPixelSize2);
            this.f12141b.P(R.dimen.tbds177);
            this.f12141b.i0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
            this.f12141b.O(32);
            this.f12141b.L(5);
            int dimensionPixelSize3 = this.f12140a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize4 = this.f12140a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            this.f12141b.Z(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
            this.f12141b.j0(0);
            this.f12141b.k0(-dimensionPixelSize4);
            this.f12141b.P(R.dimen.tbds177);
            this.f12141b.i0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
            this.f12141b.O(16);
            this.f12141b.L(2);
            int dimensionPixelSize5 = this.f12140a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize6 = this.f12140a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f12141b.Z(dimensionPixelSize5, 0, dimensionPixelSize5, dimensionPixelSize5);
            this.f12141b.j0(0);
            this.f12141b.k0(-dimensionPixelSize6);
            this.f12141b.P(R.dimen.tbds177);
            this.f12141b.i0(R.dimen.tbds484);
        }
        this.f12141b.M(new a(str2));
        this.f12141b.l0(str);
        TiebaStatic.log("c13801");
    }
}
