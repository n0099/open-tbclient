package com.baidu.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;
import java.util.Map;
/* loaded from: classes5.dex */
public class a implements MethodChannel.MethodCallHandler, PlatformView {
    private View aoj;
    private String aok = "-1";
    private com.baidu.tieba.square.a aol;
    private final MethodChannel methodChannel;
    private int viewId;

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(17)
    public a(Context context, BinaryMessenger binaryMessenger, int i, Map<String, Object> map) {
        d(context, map);
        this.viewId = i;
        this.methodChannel = new MethodChannel(binaryMessenger, "common_platform_view_" + this.aok);
        this.methodChannel.setMethodCallHandler(this);
    }

    private void d(Context context, Map<String, Object> map) {
        if (map != null && (map instanceof Map)) {
            Object obj = map.get(Config.EVENT_HEAT_X);
            if (obj != null) {
                Double.valueOf(obj.toString()).doubleValue();
            }
            Object obj2 = map.get("y");
            if (obj2 != null) {
                Double.valueOf(obj2.toString()).doubleValue();
            }
            Object obj3 = map.get("width");
            if (obj3 != null) {
                Double.valueOf(obj3.toString()).doubleValue();
            }
            Object obj4 = map.get("height");
            if (obj4 != null) {
                Double.valueOf(obj4.toString()).doubleValue();
            }
            this.aok = String.valueOf(map.get("persistentViewId"));
            if ("BarSquare".equals(String.valueOf(map.get("nativeViewType")))) {
                this.aol = new com.baidu.tieba.square.a(TbadkApplication.getInst().getCurrentActivity(), ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext());
                this.aol.dJe();
                this.aol.startLoadData();
                this.aoj = this.aol.nfy.getRootLayout();
            }
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public View getView() {
        return this.aoj;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("removePlatformView")) {
            b.bI(this.viewId);
            result.success(true);
        } else if (methodCall.method.equals("selectForumCategory")) {
            String str = (String) methodCall.arguments;
            if (this.aol != null && !TextUtils.isEmpty(str)) {
                this.aol.RI(str);
            }
            result.success(null);
        } else {
            result.notImplemented();
        }
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewAttached(@NonNull View view) {
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onFlutterViewDetached() {
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionLocked() {
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void onInputConnectionUnlocked() {
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void dispose() {
        Log.d("CommonPlatformView", "dispose() called");
    }
}
