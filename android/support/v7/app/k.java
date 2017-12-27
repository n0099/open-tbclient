package android.support.v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompatBase;
import android.support.v7.appcompat.R;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
class k {
    public static <T extends NotificationCompatBase.Action> RemoteViews a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent, boolean z3) {
        RemoteViews a = a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, i2, list, iArr, z2, pendingIntent, z3);
        notificationBuilderWithBuilderAccessor.getBuilder().setContent(a);
        if (z2) {
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
        return a;
    }

    private static <T extends NotificationCompatBase.Action> RemoteViews a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent, boolean z3) {
        RemoteViews a = a(context, charSequence, charSequence2, charSequence3, i, 0, bitmap, charSequence4, z, j, i2, 0, z3 ? R.layout.notification_template_media_custom : R.layout.notification_template_media, true);
        int size = list.size();
        int min = iArr == null ? 0 : Math.min(iArr.length, 3);
        a.removeAllViews(R.id.media_actions);
        if (min > 0) {
            for (int i3 = 0; i3 < min; i3++) {
                if (i3 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i3), Integer.valueOf(size - 1)));
                }
                a.addView(R.id.media_actions, a(context, list.get(iArr[i3])));
            }
        }
        if (z2) {
            a.setViewVisibility(R.id.end_padder, 8);
            a.setViewVisibility(R.id.cancel_action, 0);
            a.setOnClickPendingIntent(R.id.cancel_action, pendingIntent);
            a.setInt(R.id.cancel_action, "setAlpha", context.getResources().getInteger(R.integer.cancel_button_image_alpha));
        } else {
            a.setViewVisibility(R.id.end_padder, 0);
            a.setViewVisibility(R.id.cancel_action, 8);
        }
        return a;
    }

    public static <T extends NotificationCompatBase.Action> void a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, int i3, List<T> list, boolean z2, PendingIntent pendingIntent, boolean z3) {
        notification.bigContentView = a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, i2, i3, list, z2, pendingIntent, z3);
        if (z2) {
            notification.flags |= 2;
        }
    }

    public static <T extends NotificationCompatBase.Action> RemoteViews a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, int i3, List<T> list, boolean z2, PendingIntent pendingIntent, boolean z3) {
        int min = Math.min(list.size(), 5);
        RemoteViews a = a(context, charSequence, charSequence2, charSequence3, i, 0, bitmap, charSequence4, z, j, i2, i3, b(z3, min), false);
        a.removeAllViews(R.id.media_actions);
        if (min > 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= min) {
                    break;
                }
                a.addView(R.id.media_actions, a(context, list.get(i5)));
                i4 = i5 + 1;
            }
        }
        if (z2) {
            a.setViewVisibility(R.id.cancel_action, 0);
            a.setInt(R.id.cancel_action, "setAlpha", context.getResources().getInteger(R.integer.cancel_button_image_alpha));
            a.setOnClickPendingIntent(R.id.cancel_action, pendingIntent);
        } else {
            a.setViewVisibility(R.id.cancel_action, 8);
        }
        return a;
    }

    private static RemoteViews a(Context context, NotificationCompatBase.Action action) {
        boolean z = action.getActionIntent() == null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_media_action);
        remoteViews.setImageViewResource(R.id.action0, action.getIcon());
        if (!z) {
            remoteViews.setOnClickPendingIntent(R.id.action0, action.getActionIntent());
        }
        if (Build.VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(R.id.action0, action.getTitle());
        }
        return remoteViews;
    }

    private static int b(boolean z, int i) {
        return i <= 3 ? z ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_narrow : z ? R.layout.notification_template_big_media_custom : R.layout.notification_template_big_media;
    }

    public static RemoteViews a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, int i2, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i3, int i4, int i5, boolean z2, ArrayList<NotificationCompat.Action> arrayList) {
        boolean z3;
        int size;
        RemoteViews a = a(context, charSequence, charSequence2, charSequence3, i, i2, bitmap, charSequence4, z, j, i3, i4, i5, z2);
        a.removeAllViews(R.id.actions);
        if (arrayList == null || (size = arrayList.size()) <= 0) {
            z3 = false;
        } else {
            int i6 = size > 3 ? 3 : size;
            for (int i7 = 0; i7 < i6; i7++) {
                a.addView(R.id.actions, a(context, arrayList.get(i7)));
            }
            z3 = true;
        }
        int i8 = z3 ? 0 : 8;
        a.setViewVisibility(R.id.actions, i8);
        a.setViewVisibility(R.id.action_divider, i8);
        return a;
    }

    private static RemoteViews a(Context context, NotificationCompat.Action action) {
        int ei;
        boolean z = action.actionIntent == null;
        String packageName = context.getPackageName();
        if (z) {
            ei = ej();
        } else {
            ei = ei();
        }
        RemoteViews remoteViews = new RemoteViews(packageName, ei);
        remoteViews.setImageViewBitmap(R.id.action_image, b(context, action.getIcon(), context.getResources().getColor(R.color.notification_action_color_filter)));
        remoteViews.setTextViewText(R.id.action_text, action.title);
        if (!z) {
            remoteViews.setOnClickPendingIntent(R.id.action_container, action.actionIntent);
        }
        remoteViews.setContentDescription(R.id.action_container, action.title);
        return remoteViews;
    }

    private static Bitmap b(Context context, int i, int i2) {
        return a(context, i, i2, 0);
    }

    private static Bitmap a(Context context, int i, int i2, int i3) {
        Drawable drawable = context.getResources().getDrawable(i);
        int intrinsicWidth = i3 == 0 ? drawable.getIntrinsicWidth() : i3;
        if (i3 == 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i3, Bitmap.Config.ARGB_8888);
        drawable.setBounds(0, 0, intrinsicWidth, i3);
        if (i2 != 0) {
            drawable.mutate().setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
        }
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private static int ei() {
        return R.layout.notification_action;
    }

    private static int ej() {
        return R.layout.notification_action_tombstone;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static RemoteViews a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, int i2, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i3, int i4, int i5, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Resources resources = context.getResources();
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i5);
        boolean z7 = i3 < -1;
        boolean z8 = Build.VERSION.SDK_INT >= 16;
        boolean z9 = Build.VERSION.SDK_INT >= 21;
        if (z8 && !z9) {
            if (z7) {
                remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
                remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
            } else {
                remoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
                remoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
            }
        }
        if (bitmap != null) {
            if (z8) {
                remoteViews.setViewVisibility(R.id.icon, 0);
                remoteViews.setImageViewBitmap(R.id.icon, bitmap);
            } else {
                remoteViews.setViewVisibility(R.id.icon, 8);
            }
            if (i2 != 0) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
                int dimensionPixelSize2 = dimensionPixelSize - (resources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding) * 2);
                if (z9) {
                    remoteViews.setImageViewBitmap(R.id.right_icon, a(context, i2, dimensionPixelSize, dimensionPixelSize2, i4));
                } else {
                    remoteViews.setImageViewBitmap(R.id.right_icon, b(context, i2, -1));
                }
                remoteViews.setViewVisibility(R.id.right_icon, 0);
            }
        } else if (i2 != 0) {
            remoteViews.setViewVisibility(R.id.icon, 0);
            if (z9) {
                remoteViews.setImageViewBitmap(R.id.icon, a(context, i2, resources.getDimensionPixelSize(R.dimen.notification_large_icon_width) - resources.getDimensionPixelSize(R.dimen.notification_big_circle_margin), resources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large), i4));
            } else {
                remoteViews.setImageViewBitmap(R.id.icon, b(context, i2, -1));
            }
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(R.id.title, charSequence);
        }
        if (charSequence2 == null) {
            z3 = false;
        } else {
            remoteViews.setTextViewText(R.id.text, charSequence2);
            z3 = true;
        }
        boolean z10 = (z9 || bitmap == null) ? false : true;
        if (charSequence3 != null) {
            remoteViews.setTextViewText(R.id.info, charSequence3);
            remoteViews.setViewVisibility(R.id.info, 0);
            z10 = true;
            z4 = true;
        } else if (i > 0) {
            if (i > resources.getInteger(R.integer.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(R.id.info, resources.getString(R.string.status_bar_notification_info_overflow));
            } else {
                remoteViews.setTextViewText(R.id.info, NumberFormat.getIntegerInstance().format(i));
            }
            remoteViews.setViewVisibility(R.id.info, 0);
            z10 = true;
            z4 = true;
        } else {
            remoteViews.setViewVisibility(R.id.info, 8);
            z4 = z3;
        }
        if (charSequence4 != null && z8) {
            remoteViews.setTextViewText(R.id.text, charSequence4);
            if (charSequence2 != null) {
                remoteViews.setTextViewText(R.id.text2, charSequence2);
                remoteViews.setViewVisibility(R.id.text2, 0);
                z5 = true;
                if (z5 && z8) {
                    if (z2) {
                        remoteViews.setTextViewTextSize(R.id.text, 0, resources.getDimensionPixelSize(R.dimen.notification_subtext_size));
                    }
                    remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
                }
                if (j == 0) {
                    if (z && z8) {
                        remoteViews.setViewVisibility(R.id.chronometer, 0);
                        remoteViews.setLong(R.id.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + j);
                        remoteViews.setBoolean(R.id.chronometer, "setStarted", true);
                    } else {
                        remoteViews.setViewVisibility(R.id.time, 0);
                        remoteViews.setLong(R.id.time, "setTime", j);
                    }
                    z6 = true;
                } else {
                    z6 = z10;
                }
                remoteViews.setViewVisibility(R.id.right_side, !z6 ? 0 : 8);
                remoteViews.setViewVisibility(R.id.line3, !z4 ? 0 : 8);
                return remoteViews;
            }
            remoteViews.setViewVisibility(R.id.text2, 8);
        }
        z5 = false;
        if (z5) {
            if (z2) {
            }
            remoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
        }
        if (j == 0) {
        }
        remoteViews.setViewVisibility(R.id.right_side, !z6 ? 0 : 8);
        remoteViews.setViewVisibility(R.id.line3, !z4 ? 0 : 8);
        return remoteViews;
    }

    public static Bitmap a(Context context, int i, int i2, int i3, int i4) {
        int i5 = R.drawable.notification_icon_background;
        if (i4 == 0) {
            i4 = 0;
        }
        Bitmap a = a(context, i5, i4, i2);
        Canvas canvas = new Canvas(a);
        Drawable mutate = context.getResources().getDrawable(i).mutate();
        mutate.setFilterBitmap(true);
        int i6 = (i2 - i3) / 2;
        mutate.setBounds(i6, i6, i3 + i6, i3 + i6);
        mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        mutate.draw(canvas);
        return a;
    }

    public static void a(Context context, RemoteViews remoteViews, RemoteViews remoteViews2) {
        a(remoteViews);
        remoteViews.removeAllViews(R.id.notification_main_column);
        remoteViews.addView(R.id.notification_main_column, remoteViews2.clone());
        remoteViews.setViewVisibility(R.id.notification_main_column, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            remoteViews.setViewPadding(R.id.notification_main_column_container, 0, V(context), 0, 0);
        }
    }

    private static void a(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.title, 8);
        remoteViews.setViewVisibility(R.id.text2, 8);
        remoteViews.setViewVisibility(R.id.text, 8);
    }

    public static int V(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.notification_top_pad);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
        float constrain = (constrain(context.getResources().getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
        return Math.round((dimensionPixelSize * (1.0f - constrain)) + (dimensionPixelSize2 * constrain));
    }

    public static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }
}
