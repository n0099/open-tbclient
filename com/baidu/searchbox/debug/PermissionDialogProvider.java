package com.baidu.searchbox.debug;

import android.view.View;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.annotation.DebugInfoProvider;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.permission.DangerousPermissionManager;
import com.baidu.searchbox.permission.DangerousPermissionUtils;
import com.baidu.webkit.sdk.PermissionRequest;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kuaishou.weapon.p0.h;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/debug/PermissionDialogProvider;", "Lcom/baidu/searchbox/debug/data/DebugDataGroupProvider;", "", "title", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addItem", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "getChildItemList", "()Ljava/util/ArrayList;", "getGroupName", "()Ljava/lang/String;", "mItemInfoList", "Ljava/util/ArrayList;", "<init>", "()V", "Companion", "lib-oem-permission_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@DebugInfoProvider(enable = false, type = "Debug_Fetures")
/* loaded from: classes3.dex */
public final class PermissionDialogProvider extends DebugDataGroupProvider {
    public static final Companion Companion = new Companion(null);
    public static final String GROUP_NAME = "高危权限SDK";
    public static final String REQUEST_CAMER = "申请摄像头权限";
    public static final String REQUEST_CONTACTS = "申请通讯录权限";
    public static final String REQUEST_LOCATION = "申请位置权限";
    public static final String REQUEST_MIC = "申请麦克风权限";
    public static final String REQUEST_READ_PHPNE_STATE = "申请设备权限";
    public static final String REQUEST_STORAGE = "申请存储权限";
    public static final String TAG = "PermissionDialogProvider";
    public final ArrayList<DebugItemInfo> mItemInfoList = new ArrayList<>();

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public String getGroupName() {
        return GROUP_NAME;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/debug/PermissionDialogProvider$Companion;", "", "GROUP_NAME", "Ljava/lang/String;", "REQUEST_CAMER", "REQUEST_CONTACTS", "REQUEST_LOCATION", "REQUEST_MIC", "REQUEST_READ_PHPNE_STATE", "REQUEST_STORAGE", "TAG", "<init>", "()V", "lib-oem-permission_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void addItem(String str, View.OnClickListener onClickListener) {
        this.mItemInfoList.add(new TextItemInfo(null, str, onClickListener));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public ArrayList<DebugItemInfo> getChildItemList() {
        addItem(REQUEST_READ_PHPNE_STATE, new View.OnClickListener() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String[] strArr = {h.c};
                if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
                    DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$1.1
                        @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                        public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                        }
                    });
                } else {
                    Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
                }
            }
        });
        addItem(REQUEST_CAMER, new View.OnClickListener() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String[] strArr = {PermissionRequest.RESOURCE_VIDEO_CAPTURE};
                if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
                    DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$2.1
                        @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                        public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                        }
                    });
                } else {
                    Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
                }
            }
        });
        addItem(REQUEST_MIC, new View.OnClickListener() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String[] strArr = {PermissionRequest.RESOURCE_AUDIO_CAPTURE};
                if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
                    DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$3.1
                        @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                        public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                        }
                    });
                } else {
                    Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
                }
            }
        });
        addItem(REQUEST_CONTACTS, new View.OnClickListener() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String[] strArr = {"android.permission.READ_CONTACTS"};
                if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
                    DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$4.1
                        @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                        public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                        }
                    });
                } else {
                    Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
                }
            }
        });
        addItem(REQUEST_LOCATION, new View.OnClickListener() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String[] strArr = {h.g};
                if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
                    DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$5.1
                        @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                        public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                        }
                    });
                } else {
                    Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
                }
            }
        });
        addItem(REQUEST_STORAGE, new View.OnClickListener() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String[] strArr = {h.i};
                if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
                    DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.searchbox.debug.PermissionDialogProvider$getChildItemList$6.1
                        @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                        public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                        }
                    });
                } else {
                    Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
                }
            }
        });
        return this.mItemInfoList;
    }
}
