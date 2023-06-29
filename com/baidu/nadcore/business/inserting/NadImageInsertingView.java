package com.baidu.nadcore.business.inserting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ap0;
import com.baidu.tieba.b31;
import com.baidu.tieba.ip0;
import com.baidu.tieba.nr0;
import com.baidu.tieba.ui0;
import com.baidu.tieba.vc1;
import com.baidu.tieba.vi0;
import com.baidu.tieba.xj0;
import com.baidu.tieba.y61;
/* loaded from: classes3.dex */
public class NadImageInsertingView extends NadInsertingBaseView {
    public AdImageView e;
    public TextView f;
    public View.OnClickListener g;

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public View getRealView() {
        return this;
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!(NadImageInsertingView.this.getTag() instanceof AdBaseModel)) {
                return;
            }
            AdBaseModel adBaseModel = (AdBaseModel) NadImageInsertingView.this.getTag();
            NadImageInsertingView.this.d(adBaseModel, ClogBuilder.Area.IMAGE);
            xj0.b(adBaseModel.f.c);
            NadImageInsertingView.this.a.c();
            NadImageInsertingView.this.j(2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ip0 {
        public final /* synthetic */ nr0 a;
        public final /* synthetic */ vi0.c b;
        public final /* synthetic */ AdBaseModel c;

        public b(nr0 nr0Var, vi0.c cVar, AdBaseModel adBaseModel) {
            this.a = nr0Var;
            this.b = cVar;
            this.c = adBaseModel;
        }

        @Override // com.baidu.tieba.ip0
        public void a() {
            NadImageInsertingView.this.c(this.c, "16", "16003");
            this.b.onFail();
        }

        @Override // com.baidu.tieba.ip0
        public void b(Bitmap bitmap) {
            int i = this.a.b;
            if (i > 1794) {
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), (int) ((1.0f - (((i - 1794) * 1.0f) / i)) * bitmap.getHeight()));
            }
            if (bitmap != null) {
                NadImageInsertingView.this.e.setImageBitmap(bitmap);
                this.b.onSuccess();
                return;
            }
            NadImageInsertingView.this.c(this.c, "16", "16002");
            this.b.onFail();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends y61.b {
        public c() {
        }

        @Override // com.baidu.tieba.y61.b
        public void b() {
            super.b();
            NadImageInsertingView.this.j(1);
        }

        @Override // com.baidu.tieba.y61.b
        public void c() {
            super.c();
            NadImageInsertingView.this.a.b();
        }

        @Override // com.baidu.tieba.y61.b
        public void d() {
            super.d();
            NadImageInsertingView.this.a.a();
        }

        @Override // com.baidu.tieba.y61.b
        public void e() {
            super.e();
        }
    }

    public NadImageInsertingView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull ui0 ui0Var) {
        super(context, viewGroup, ui0Var);
        this.g = new a();
    }

    public final void m(@NonNull AdBaseModel adBaseModel, @NonNull vi0.c cVar) {
        nr0 nr0Var = (nr0) b31.d(adBaseModel.f.k, 0);
        if (nr0Var == null) {
            setVisibility(8);
            c(adBaseModel, "16", "16001");
            cVar.onFail();
            return;
        }
        vc1.a().e(nr0Var.a, new b(nr0Var, cVar, adBaseModel));
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void setData(@NonNull AdBaseModel adBaseModel, @NonNull vi0.c cVar) {
        setTag(adBaseModel);
        setOnClickListener(this.g);
        l();
        m(adBaseModel, cVar);
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.nad_inserting_image_layout, this);
        this.e = (AdImageView) findViewById(R.id.nad_inserting_image);
        this.f = (TextView) findViewById(R.id.nad_inserting_tag);
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void a() {
        j(0);
    }

    @Override // com.baidu.nadcore.business.inserting.NadInsertingBaseView
    public void g() {
        k();
    }

    public final void l() {
        y61 y61Var = new y61(5000L, 1000L);
        y61Var.d(new c());
        this.c = y61Var;
    }

    public final void j(int i) {
        if (!(getTag() instanceof AdBaseModel)) {
            return;
        }
        AdBaseModel adBaseModel = (AdBaseModel) getTag();
        setVisibility(8);
        try {
            removeAllViews();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        long currentTimeMillis = (System.currentTimeMillis() - this.b) / 1000;
        if (i == 1) {
            e(adBaseModel, ClogBuilder.Area.AUTO_HIDE, currentTimeMillis);
        } else if (i == 0) {
            e(adBaseModel, ClogBuilder.Area.CLOSE_BTN, currentTimeMillis);
        }
        this.a.d();
        ap0.g(this.d);
        this.c.a();
    }

    public void k() {
        if ((getTag() instanceof AdBaseModel) && this.a != null) {
            f((AdBaseModel) getTag());
            this.b = System.currentTimeMillis();
            this.a.onShow();
            this.c.e();
            ap0.f(this.d);
            this.e.setVisibility(0);
            this.f.setVisibility(0);
        }
    }
}
