package com.baidu.searchbox.debug;

import android.view.View;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.debug.PermissionDialogProvider;
import com.baidu.searchbox.debug.annotation.DebugInfoProvider;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.debug.data.TextItemInfo;
import com.baidu.searchbox.permission.DangerousPermissionManager;
import com.baidu.searchbox.permission.DangerousPermissionUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.PermissionRequest;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/debug/PermissionDialogProvider;", "Lcom/baidu/searchbox/debug/data/DebugDataGroupProvider;", "()V", "mItemInfoList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "addItem", "", "title", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "getChildItemList", "getGroupName", "Companion", "lib-oem-permission_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    /* renamed from: getChildItemList$lambda-1$lambda-0  reason: not valid java name */
    public static final void m62getChildItemList$lambda1$lambda0(int i, String[] strArr, int[] iArr) {
    }

    /* renamed from: getChildItemList$lambda-11$lambda-10  reason: not valid java name */
    public static final void m64getChildItemList$lambda11$lambda10(int i, String[] strArr, int[] iArr) {
    }

    /* renamed from: getChildItemList$lambda-3$lambda-2  reason: not valid java name */
    public static final void m66getChildItemList$lambda3$lambda2(int i, String[] strArr, int[] iArr) {
    }

    /* renamed from: getChildItemList$lambda-5$lambda-4  reason: not valid java name */
    public static final void m68getChildItemList$lambda5$lambda4(int i, String[] strArr, int[] iArr) {
    }

    /* renamed from: getChildItemList$lambda-7$lambda-6  reason: not valid java name */
    public static final void m70getChildItemList$lambda7$lambda6(int i, String[] strArr, int[] iArr) {
    }

    /* renamed from: getChildItemList$lambda-9$lambda-8  reason: not valid java name */
    public static final void m72getChildItemList$lambda9$lambda8(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public String getGroupName() {
        return GROUP_NAME;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/debug/PermissionDialogProvider$Companion;", "", "()V", "GROUP_NAME", "", "REQUEST_CAMER", "REQUEST_CONTACTS", "REQUEST_LOCATION", "REQUEST_MIC", "REQUEST_READ_PHPNE_STATE", "REQUEST_STORAGE", "TAG", "lib-oem-permission_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final void addItem(String str, View.OnClickListener onClickListener) {
        this.mItemInfoList.add(new TextItemInfo(null, str, onClickListener));
    }

    /* renamed from: getChildItemList$lambda-1  reason: not valid java name */
    public static final void m61getChildItemList$lambda1(View view2) {
        String[] strArr = {g.c};
        if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
            DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.tieba.uh1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr2, iArr) == null) {
                        PermissionDialogProvider.m62getChildItemList$lambda1$lambda0(i, strArr2, iArr);
                    }
                }
            });
        } else {
            Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
        }
    }

    /* renamed from: getChildItemList$lambda-11  reason: not valid java name */
    public static final void m63getChildItemList$lambda11(View view2) {
        String[] strArr = {g.i};
        if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
            DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.tieba.ai1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr2, iArr) == null) {
                        PermissionDialogProvider.m64getChildItemList$lambda11$lambda10(i, strArr2, iArr);
                    }
                }
            });
        } else {
            Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
        }
    }

    /* renamed from: getChildItemList$lambda-3  reason: not valid java name */
    public static final void m65getChildItemList$lambda3(View view2) {
        String[] strArr = {PermissionRequest.RESOURCE_VIDEO_CAPTURE};
        if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
            DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.tieba.bi1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr2, iArr) == null) {
                        PermissionDialogProvider.m66getChildItemList$lambda3$lambda2(i, strArr2, iArr);
                    }
                }
            });
        } else {
            Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
        }
    }

    /* renamed from: getChildItemList$lambda-5  reason: not valid java name */
    public static final void m67getChildItemList$lambda5(View view2) {
        String[] strArr = {PermissionRequest.RESOURCE_AUDIO_CAPTURE};
        if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
            DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.tieba.wh1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr2, iArr) == null) {
                        PermissionDialogProvider.m68getChildItemList$lambda5$lambda4(i, strArr2, iArr);
                    }
                }
            });
        } else {
            Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
        }
    }

    /* renamed from: getChildItemList$lambda-7  reason: not valid java name */
    public static final void m69getChildItemList$lambda7(View view2) {
        String[] strArr = {"android.permission.READ_CONTACTS"};
        if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
            DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.tieba.zh1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr2, iArr) == null) {
                        PermissionDialogProvider.m70getChildItemList$lambda7$lambda6(i, strArr2, iArr);
                    }
                }
            });
        } else {
            Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
        }
    }

    /* renamed from: getChildItemList$lambda-9  reason: not valid java name */
    public static final void m71getChildItemList$lambda9(View view2) {
        String[] strArr = {g.g};
        if (!DangerousPermissionUtils.isPermissionGroupGranted(AppRuntime.getAppContext(), strArr)) {
            DangerousPermissionUtils.requestPermissions("basic", AppRuntime.getAppContext(), strArr, 100, new DangerousPermissionManager.RequestSystemPermissionCallBack() { // from class: com.baidu.tieba.di1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.searchbox.permission.DangerousPermissionManager.RequestSystemPermissionCallBack
                public final void onRequestPermissionsResult(int i, String[] strArr2, int[] iArr) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeILL(1048576, this, i, strArr2, iArr) == null) {
                        PermissionDialogProvider.m72getChildItemList$lambda9$lambda8(i, strArr2, iArr);
                    }
                }
            });
        } else {
            Toast.makeText(AppRuntime.getAppContext(), "权限已授予", 1).show();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public ArrayList<DebugItemInfo> getChildItemList() {
        addItem(REQUEST_READ_PHPNE_STATE, new View.OnClickListener() { // from class: com.baidu.tieba.vh1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    PermissionDialogProvider.m61getChildItemList$lambda1(view2);
                }
            }
        });
        addItem(REQUEST_CAMER, new View.OnClickListener() { // from class: com.baidu.tieba.ei1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    PermissionDialogProvider.m65getChildItemList$lambda3(view2);
                }
            }
        });
        addItem(REQUEST_MIC, new View.OnClickListener() { // from class: com.baidu.tieba.ci1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    PermissionDialogProvider.m67getChildItemList$lambda5(view2);
                }
            }
        });
        addItem(REQUEST_CONTACTS, new View.OnClickListener() { // from class: com.baidu.tieba.xh1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    PermissionDialogProvider.m69getChildItemList$lambda7(view2);
                }
            }
        });
        addItem(REQUEST_LOCATION, new View.OnClickListener() { // from class: com.baidu.tieba.th1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    PermissionDialogProvider.m71getChildItemList$lambda9(view2);
                }
            }
        });
        addItem(REQUEST_STORAGE, new View.OnClickListener() { // from class: com.baidu.tieba.yh1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    PermissionDialogProvider.m63getChildItemList$lambda11(view2);
                }
            }
        });
        return this.mItemInfoList;
    }
}
