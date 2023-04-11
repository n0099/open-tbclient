package com.baidu.nadcore.business.inserting;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.l11;
import com.baidu.tieba.m11;
import com.baidu.tieba.og0;
import com.baidu.tieba.pg0;
import com.baidu.tieba.s41;
import com.baidu.tieba.ym0;
/* loaded from: classes2.dex */
public abstract class NadInsertingBaseView extends RelativeLayout {
    public og0 a;
    public long b;
    public s41 c;
    public ym0 d;

    public abstract void a();

    public abstract void b(Context context);

    public abstract void g();

    public abstract View getRealView();

    public abstract void setData(@NonNull AdBaseModel adBaseModel, @NonNull pg0.c cVar);

    /* loaded from: classes2.dex */
    public class a implements ym0 {
        @Override // com.baidu.tieba.ym0
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // com.baidu.tieba.ym0
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // com.baidu.tieba.ym0
        public void onActivitySaveInstanceState(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // com.baidu.tieba.ym0
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // com.baidu.tieba.ym0
        public void onActivityStopped(@NonNull Activity activity) {
        }

        public a() {
        }

        @Override // com.baidu.tieba.ym0
        public void onActivityPaused(@NonNull Activity activity) {
            NadInsertingBaseView.this.c.b();
        }

        @Override // com.baidu.tieba.ym0
        public void onActivityResumed(@NonNull Activity activity) {
            NadInsertingBaseView.this.c.c();
        }

        @Override // com.baidu.tieba.ym0
        public void onBackgroundToForeground(@NonNull Activity activity) {
            NadInsertingBaseView.this.c.c();
        }

        @Override // com.baidu.tieba.ym0
        public void onForegroundToBackground(@NonNull Activity activity) {
            NadInsertingBaseView.this.c.b();
        }
    }

    public NadInsertingBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new a();
        b(context);
    }

    public NadInsertingBaseView(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull og0 og0Var) {
        this(context, null);
        setContainer(viewGroup);
        this.a = og0Var;
    }

    public void c(@NonNull AdBaseModel adBaseModel, String str, String str2) {
        if (TextUtils.isEmpty(adBaseModel.f.d)) {
            return;
        }
        l11.b(new ClogBuilder().y(ClogBuilder.LogType.CHECK).p(adBaseModel.f.d).k(str).l(str2));
    }

    public void e(@NonNull AdBaseModel adBaseModel, @NonNull ClogBuilder.Area area, long j) {
        if (TextUtils.isEmpty(adBaseModel.f.d)) {
            return;
        }
        l11.b(new ClogBuilder().y(ClogBuilder.LogType.CLOSE).p(adBaseModel.f.d).k(String.valueOf(j)).i(area));
    }

    public void d(@NonNull AdBaseModel adBaseModel, @NonNull ClogBuilder.Area area) {
        l11.b(new ClogBuilder().y(ClogBuilder.LogType.CLICK).p(adBaseModel.f.d).i(area));
        for (MonitorUrl monitorUrl : adBaseModel.e) {
            if (monitorUrl != null && !TextUtils.isEmpty(monitorUrl.clickUrl)) {
                m11.b(monitorUrl.clickUrl);
            }
        }
    }

    public void f(@NonNull AdBaseModel adBaseModel) {
        if (adBaseModel.a) {
            return;
        }
        l11.b(new ClogBuilder().y(ClogBuilder.LogType.SHOW).p(adBaseModel.f.d));
        for (MonitorUrl monitorUrl : adBaseModel.e) {
            if (monitorUrl != null && !TextUtils.isEmpty(monitorUrl.showUrl)) {
                m11.b(monitorUrl.showUrl);
            }
        }
        adBaseModel.a = true;
    }

    @Nullable
    public String getAdType() {
        if (!(getTag() instanceof AdBaseModel)) {
            return null;
        }
        return ((AdBaseModel) getTag()).f.a.value;
    }

    public void setContainer(@NonNull ViewGroup viewGroup) {
        View view2 = (View) getParent();
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).removeView(this);
        }
        viewGroup.addView(this);
    }
}
