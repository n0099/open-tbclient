package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.j0.b0.e;
/* loaded from: classes3.dex */
public class WriteTipBubbleController {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f12834a;

    /* renamed from: b  reason: collision with root package name */
    public e f12835b;

    /* renamed from: c  reason: collision with root package name */
    public b f12836c;

    /* loaded from: classes3.dex */
    public enum ANCHOR_VIEW_FROM {
        FROM_EDITOR_TOOL,
        FROM_EDIT_TEXT,
        FROM_PB_REPLY
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12837e;

        public a(String str) {
            this.f12837e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteTipBubbleController.this.f12836c != null) {
                WriteTipBubbleController.this.f12836c.a(view, this.f12837e);
                if (WriteTipBubbleController.this.f12835b == null || !WriteTipBubbleController.this.f12835b.I()) {
                    return;
                }
                WriteTipBubbleController.this.f12835b.H();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, String str);
    }

    public WriteTipBubbleController(TbPageContext tbPageContext, b bVar) {
        this.f12834a = tbPageContext;
        this.f12836c = bVar;
    }

    public void c() {
        e eVar = this.f12835b;
        if (eVar != null) {
            eVar.H();
        }
    }

    public void d(@NonNull View view, @NonNull String str, @NonNull String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.f12834a == null || view == null || k.isEmpty(str) || k.isEmpty(str2)) {
            return;
        }
        if (this.f12835b == null) {
            e eVar = new e(this.f12834a, view);
            this.f12835b = eVar;
            eVar.c0(R.drawable.pic_post_findlink);
            this.f12835b.R(2);
            this.f12835b.P(true);
            this.f12835b.b0(19);
            this.f12835b.W(R.color.CAM_X0105);
            this.f12835b.M(5000);
        }
        if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
            this.f12835b.N(32);
            this.f12835b.K(2);
            int dimensionPixelSize = this.f12834a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize2 = this.f12834a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f12835b.Y(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
            this.f12835b.f0(0);
            this.f12835b.g0(-dimensionPixelSize2);
            this.f12835b.O(R.dimen.tbds177);
            this.f12835b.e0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
            this.f12835b.N(32);
            this.f12835b.K(5);
            int dimensionPixelSize3 = this.f12834a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize4 = this.f12834a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            this.f12835b.Y(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
            this.f12835b.f0(0);
            this.f12835b.g0(-dimensionPixelSize4);
            this.f12835b.O(R.dimen.tbds177);
            this.f12835b.e0(R.dimen.tbds484);
        } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
            this.f12835b.N(16);
            this.f12835b.K(2);
            int dimensionPixelSize5 = this.f12834a.getResources().getDimensionPixelSize(R.dimen.tbds32);
            int dimensionPixelSize6 = this.f12834a.getResources().getDimensionPixelSize(R.dimen.ds4);
            this.f12835b.Y(dimensionPixelSize5, 0, dimensionPixelSize5, dimensionPixelSize5);
            this.f12835b.f0(0);
            this.f12835b.g0(-dimensionPixelSize6);
            this.f12835b.O(R.dimen.tbds177);
            this.f12835b.e0(R.dimen.tbds484);
        }
        this.f12835b.L(new a(str2));
        this.f12835b.h0(str);
        TiebaStatic.log("c13801");
    }
}
