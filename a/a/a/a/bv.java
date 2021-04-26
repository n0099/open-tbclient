package a.a.a.a;

import com.baidu.cloudbase.audiofilter.AudioFilter;
/* loaded from: classes.dex */
public class bv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioFilter f1006a;

    public bv(AudioFilter audioFilter) {
        this.f1006a = audioFilter;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1006a.a();
    }
}
