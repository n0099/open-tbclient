package com.baidu.nadcore.download.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class NadLPDownloadAuditView extends RelativeLayout {
    public RelativeLayout a;
    public RelativeLayout b;

    public NadLPDownloadAuditView(@NonNull Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.nad_lp_download_audit_view, this);
        this.a = (RelativeLayout) inflate.findViewById(R.id.lp_download_view_container);
        this.b = (RelativeLayout) inflate.findViewById(R.id.lp_download_view_container_other_area);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public NadLPDownloadAuditView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RelativeLayout getDownloadView() {
        return this.a;
    }

    public RelativeLayout getDownloadViewOtherArea() {
        return this.b;
    }
}
