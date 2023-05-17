package com.baidu.searchbox.permission.popupwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.skin.ioc.ISkinResourcesContext;
import com.baidu.searchbox.skin.ioc.SkinResourcesRuntime;
import com.baidu.tieba.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b'\u0010\u000bJ\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\b\b\u0001\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0018J1\u0010\u001b\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u000bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010 ¨\u0006("}, d2 = {"Lcom/baidu/searchbox/permission/popupwindow/PermissionInAppWindow;", "Lcom/baidu/android/ext/widget/PopupWindow;", "", NotificationCompat.WearableExtender.KEY_GRAVITY, "y", "getOffSetY", "(II)I", "Landroid/content/Context;", "context", "", "init", "(Landroid/content/Context;)V", "", "content", "setContentText", "(Ljava/lang/String;)V", "title", "setTitleText", "Landroid/view/View;", "anchor", "showAsDropDown", "(Landroid/view/View;)V", "xoff", "yoff", "(Landroid/view/View;II)V", "parent", "x", "showAtLocation", "(Landroid/view/View;III)V", "updateUI", "Landroid/widget/TextView;", "mContentView", "Landroid/widget/TextView;", "mContext", "Landroid/content/Context;", "Landroid/widget/LinearLayout;", "mPermissionRootView", "Landroid/widget/LinearLayout;", "mTitleView", "<init>", "lib-oem-permission_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PermissionInAppWindow extends PopupWindow {
    public TextView mContentView;
    public Context mContext;
    public LinearLayout mPermissionRootView;
    public TextView mTitleView;

    public PermissionInAppWindow(Context context) {
        super(context);
        init(context);
    }

    public final void setContentText(@NonNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        TextView textView = this.mContentView;
        if (textView != null) {
            textView.setText(content);
        }
    }

    public final void setTitleText(@NonNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(title);
        }
    }

    @Override // com.baidu.android.ext.widget.PopupWindow
    public void showAsDropDown(View view2) {
        if (view2 != null) {
            super.showAsDropDown(view2);
        }
    }

    private final int getOffSetY(int i, int i2) {
        if (i == 48) {
            return i2 + DeviceUtils.ScreenInfo.getStatusBarHeight();
        }
        return i2;
    }

    private final void init(Context context) {
        if (context != null) {
            this.mContext = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d077b, (ViewGroup) null);
            setContentView(inflate);
            setWidth(-1);
            setHeight(-2);
            setBackgroundDrawable(new ColorDrawable(0));
            setAnimationStyle(R.style.obfuscated_res_0x7f1003ef);
            this.mTitleView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ab0);
            this.mContentView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091aa8);
            this.mPermissionRootView = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091aaf);
            updateUI(context);
        }
    }

    private final void updateUI(Context context) {
        Resources resources;
        ISkinResourcesContext skinResourceContext = SkinResourcesRuntime.getSkinResourceContext();
        if (skinResourceContext != null) {
            resources = skinResourceContext.getSkinResources();
        } else {
            resources = null;
        }
        if (resources == null) {
            resources = context.getResources();
        }
        if (resources != null) {
            TextView textView = this.mTitleView;
            if (textView != null) {
                textView.setTextColor(ResourcesCompat.getColor(resources, R.color.obfuscated_res_0x7f0601f3, null));
            }
            TextView textView2 = this.mContentView;
            if (textView2 != null) {
                textView2.setTextColor(ResourcesCompat.getColor(resources, R.color.obfuscated_res_0x7f0601f3, null));
            }
            LinearLayout linearLayout = this.mPermissionRootView;
            if (linearLayout != null) {
                linearLayout.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f08131e, null));
            }
        }
    }

    @Override // com.baidu.android.ext.widget.PopupWindow
    public void showAsDropDown(View view2, int i, int i2) {
        if (view2 != null) {
            super.showAsDropDown(view2, i, i2);
        }
    }

    @Override // com.baidu.android.ext.widget.PopupWindow
    public void showAtLocation(View view2, int i, int i2, int i3) {
        if (view2 != null) {
            try {
                super.showAtLocation(view2, i, i2, getOffSetY(i, i3));
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
            }
        }
    }
}
