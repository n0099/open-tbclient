package c.a.o0.g.c.h;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import c.a.o0.g.c.i.c;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, context, i2) == null) {
            ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(i2);
        }
    }

    public static final Bitmap b(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, drawable)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static void c(Context context, int i2, String str, String str2, Bitmap bitmap, long j2, PendingIntent pendingIntent, String str3, String str4) {
        NotificationCompat.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), str, str2, bitmap, Long.valueOf(j2), pendingIntent, str3, str4}) == null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel(String.valueOf(i2), "swan_game_center", 4));
                builder = new NotificationCompat.Builder(context, String.valueOf(i2));
            } else {
                builder = new NotificationCompat.Builder(context);
            }
            if (!TextUtils.isEmpty(str3)) {
                c.c("notifyShow", str3, str4);
            }
            if (pendingIntent != null) {
                builder.setContentIntent(pendingIntent);
            }
            NotificationCompat.Builder smallIcon = builder.setContentTitle(str).setContentText(str2).setWhen(j2).setSmallIcon(c.a.o0.g.a.aiapps_gamecenter_logo);
            if (bitmap == null) {
                bitmap = b(AppRuntime.getAppContext().getResources().getDrawable(c.a.o0.g.a.aiapps_gamecenter_logo));
            }
            notificationManager.notify(i2, smallIcon.setLargeIcon(bitmap).setAutoCancel(true).build());
        }
    }
}
