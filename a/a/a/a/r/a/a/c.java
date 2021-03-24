package a.a.a.a.r.a.a;

import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.fun.ad.sdk.FunAdInteractionListener;
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBasicCPUData f1088a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FunAdInteractionListener f1089b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f1090c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f1091d;

    public c(a aVar, IBasicCPUData iBasicCPUData, FunAdInteractionListener funAdInteractionListener, String str) {
        this.f1091d = aVar;
        this.f1088a = iBasicCPUData;
        this.f1089b = funAdInteractionListener;
        this.f1090c = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1088a.handleClick(view);
        this.f1091d.e();
        this.f1089b.onAdClicked(this.f1090c);
    }
}
