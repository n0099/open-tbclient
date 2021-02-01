package b.a.a.a.a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class am extends Handler {
    StringBuffer Bx;
    final /* synthetic */ al By;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(al alVar, Looper looper) {
        super(looper);
        this.By = alVar;
        this.Bx = new StringBuffer(15360);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Context context;
        String b2;
        w wVar;
        SimpleDateFormat simpleDateFormat;
        String str;
        w wVar2;
        try {
            switch (message.what) {
                case 1:
                    String stringBuffer = this.Bx.toString();
                    wVar = al.AV;
                    x xVar = wVar.AW;
                    this.Bx.setLength(0);
                    StringBuffer append = this.Bx.append("LOC_CORE,");
                    simpleDateFormat = this.By.Bw;
                    append.append(simpleDateFormat.format(new Date())).append(',').append(xVar.f()).append(',').append(xVar.h()).append(',').append(xVar.e().replaceAll(":", "").toUpperCase()).append(',').append("Lite");
                    if (!o.a(stringBuffer)) {
                        this.Bx.append(stringBuffer);
                    }
                    al alVar = this.By;
                    StringBuilder append2 = new StringBuilder().append(xVar.c).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(xVar.d).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(xVar.f1083b).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(xVar.f1082a).append(',');
                    str = al.h;
                    StringBuilder append3 = append2.append(str).append(',');
                    wVar2 = al.AV;
                    alVar.a("SYSTEM", append3.append(wVar2.AW.f()).append(',').append(Build.MODEL).append(',').append(Build.VERSION.SDK_INT).toString());
                    break;
                case 2:
                    break;
                case 3:
                    this.Bx.append('$').append((String) message.obj);
                    if (this.Bx.length() >= 15360) {
                        this.By.a(this.Bx.toString(), false);
                        this.Bx.setLength(0);
                        sendEmptyMessage(1);
                        return;
                    }
                    return;
                case 4:
                    this.By.a("", true);
                    return;
                case 5:
                    al.b(this.By);
                    return;
                default:
                    return;
            }
            removeMessages(2);
            al alVar2 = this.By;
            context = al.f;
            b2 = al.b(context);
            alVar2.a("PERMISSION", b2);
            this.By.c();
        } catch (Throwable th) {
        }
    }
}
