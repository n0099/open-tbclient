package com.baidu.ar.external;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.Fragment;
import com.baidu.ar.external.a.a.c;
import com.baidu.ar.external.a.a.d;
import com.baidu.ar.external.a.a.e;
import com.baidu.ar.external.app.IARCallback;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.b;
import com.baidu.graph.sdk.framework.ARFinishResult;
import com.baidu.graph.sdk.framework.IExtFragmentCallback;
import com.baidu.graph.sdk.framework.ar.ARConstants;
import com.baidu.graph.sdk.framework.bdbox.AccountPluginManager;
import com.baidu.graph.sdk.framework.bdbox.IBDBoxHostInvokeCallback;
import com.baidu.graph.sdk.framework.bdbox.PluginInvokeException;
import com.baidu.graph.sdk.framework.bdbox.SharePluginManager;
import com.baidu.graph.sdk.ui.FragmentType;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class a implements IARCallback {
    private IExtFragmentCallback a;

    /* renamed from: com.baidu.ar.external.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0028a implements SharePluginManager.PluginShareResultListener {
        e a;

        C0028a(e eVar) {
            this.a = eVar;
        }

        @Override // com.baidu.graph.sdk.framework.bdbox.SharePluginManager.PluginShareResultListener
        public void onCancel(String str) {
            if (this.a != null) {
                this.a.a(str);
            }
        }

        @Override // com.baidu.graph.sdk.framework.bdbox.SharePluginManager.PluginShareResultListener
        public void onComplete(String str) {
            if (this.a != null) {
                this.a.b(str);
            }
        }

        @Override // com.baidu.graph.sdk.framework.bdbox.SharePluginManager.PluginShareResultListener
        public void onError(String str) {
            if (this.a != null) {
                this.a.c(str);
            }
        }

        @Override // com.baidu.graph.sdk.framework.bdbox.SharePluginManager.PluginShareResultListener
        public void onItemClicked(String str) {
            if (this.a != null) {
                this.a.d(str);
            }
        }
    }

    public a(IExtFragmentCallback iExtFragmentCallback) {
        this.a = iExtFragmentCallback;
    }

    private static void openUrl(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        this.a = null;
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void executeCommand(Context context, String str) {
        if (this.a == null) {
            b.a("GraphExternalCallbackClient: GraphExternalCallbackClient executeCommand");
            openUrl(context, str);
            return;
        }
        b.a("GraphExternalCallbackClient: bdbox graph callback executeCommand");
        this.a.finish(new ARFinishResult(str, FragmentType.ARView, ARConstants.ARFinishMode.JumpToBrowserMode));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0085 -> B:6:0x007b). Please submit an issue!!! */
    @Override // com.baidu.ar.external.app.IARCallback
    public void executeCommandWithO2O(Context context, String str) {
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            StringBuilder sb = new StringBuilder("{\"mode\":\"0\",\"intent\":\"intent:#Intent;component=com.baidu.searchbox/.lightbrowser.LightBrowserActivity;S.bdsb_light_start_url=;B.bdsb_append_param=true;S.showtitlebar=0;S.showtoolbar=1;S.toolbaricons=%7b%22toolids%22%3a%5b%222%22%2c%223%22%5d%7d;S.extra_actionbar_color_str=%23f23d56;B.create_menu_key=0;end\",\"min_v\":\"16789248\"}");
            int length = "S.bdsb_light_start_url=".length() + "{\"mode\":\"0\",\"intent\":\"intent:#Intent;component=com.baidu.searchbox/.lightbrowser.LightBrowserActivity;S.bdsb_light_start_url=;B.bdsb_append_param=true;S.showtitlebar=0;S.showtoolbar=1;S.toolbaricons=%7b%22toolids%22%3a%5b%222%22%2c%223%22%5d%7d;S.extra_actionbar_color_str=%23f23d56;B.create_menu_key=0;end\",\"min_v\":\"16789248\"}".indexOf("S.bdsb_light_start_url=");
            sb.insert(length, encode);
            b.a("bdar: index = " + length + ", command = " + sb.toString());
            if (this.a != null) {
                b.a("GraphExternalCallbackClient: bdbox graph callback executeCommandWithO2O");
                try {
                    this.a.pluginInvokerProxy().invokeHost(6, "invokeCommand", new Class[]{String.class}, new Object[]{sb.toString()}, Constants.AR_APP_NAME, new IBDBoxHostInvokeCallback() { // from class: com.baidu.ar.external.a.1
                        @Override // com.baidu.graph.sdk.framework.bdbox.IBDBoxHostInvokeCallback
                        public void onResult(int i, Object obj) {
                            b.a("GraphExternalCallbackClient: loadUrlWithLightBrowser status code = " + i + ", result = " + obj);
                        }
                    });
                    return;
                } catch (PluginInvokeException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                    return;
                }
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        b.a("GraphExternalCallbackClient: GraphExternalCallbackClient executeCommandWithO2O");
        openUrl(context, str);
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public Bitmap getPreviewBitmap() {
        if (this.a != null) {
            return this.a.getPreviewBitmap();
        }
        return null;
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public c getUserInfo() {
        return null;
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void getUserInfo(final d dVar) {
        if (this.a != null) {
            b.a("GraphExternalCallbackClient: bdbox graph callback getUserInfo");
            try {
                this.a.pluginInvokerProxy().invokeHost(2, "getBduss", null, null, Constants.AR_APP_NAME, new IBDBoxHostInvokeCallback() { // from class: com.baidu.ar.external.a.4
                    @Override // com.baidu.graph.sdk.framework.bdbox.IBDBoxHostInvokeCallback
                    public void onResult(int i, Object obj) {
                        b.a("GraphExternalCallbackClient: getBdussstatus code = " + i + ", result = " + obj);
                        if (i == 0) {
                            if (obj != null && !(obj instanceof String)) {
                                b.d("GraphExternalCallbackClient: result Object type error!");
                                return;
                            }
                            c cVar = new c();
                            cVar.a((String) obj);
                            if (dVar != null) {
                                dVar.a(cVar);
                            }
                        }
                    }
                });
            } catch (PluginInvokeException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void isLogin(final d dVar) {
        if (this.a != null) {
            b.a("GraphExternalCallbackClient: bdbox graph callback isLogin");
            try {
                this.a.pluginInvokerProxy().invokeHost(2, "isLogin", null, null, Constants.AR_APP_NAME, new IBDBoxHostInvokeCallback() { // from class: com.baidu.ar.external.a.2
                    @Override // com.baidu.graph.sdk.framework.bdbox.IBDBoxHostInvokeCallback
                    public void onResult(int i, Object obj) {
                        b.a("GraphExternalCallbackClient: isLoginstatus code = " + i + ", result = " + obj);
                        if (i == 0) {
                            if (!(obj instanceof Boolean)) {
                                b.d("GraphExternalCallbackClient: result Object type error!");
                            } else if (dVar != null) {
                                dVar.a(obj);
                            }
                        }
                    }
                });
            } catch (PluginInvokeException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public boolean isLogin() {
        return false;
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void login(final com.baidu.ar.external.a.a.b bVar) {
        if (this.a != null) {
            b.a("GraphExternalCallbackClient: bdbox graph callback login");
            this.a.pluginInvokerProxy().login(null, new AccountPluginManager.OnPluginLoginResultListener() { // from class: com.baidu.ar.external.a.3
                @Override // com.baidu.graph.sdk.framework.bdbox.AccountPluginManager.OnPluginLoginResultListener
                public void onResult(int i) {
                    b.a("GraphExternalCallbackClient: login result in OnPluginLoginResultListener is " + i);
                    if (bVar != null) {
                        bVar.a(null, i == 0);
                    }
                }
            });
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void openNuomiScheme(String str) {
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void quitAR(Fragment fragment, IARCallback.ARAction aRAction) {
        if (this.a == null) {
            if (fragment != null) {
                fragment.getActivity().finish();
            }
        } else if (aRAction != null && aRAction == IARCallback.ARAction.SWITCHTOBARCODE) {
            this.a.finish(new ARFinishResult(null, FragmentType.ARView, ARConstants.ARFinishMode.JumpToBarcode));
        } else {
            b.a("GraphExternalCallbackClient: mExternalCallback fragmentClose");
            this.a.finish(new ARFinishResult(null, FragmentType.ARView, ARConstants.ARFinishMode.BackMode));
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void rescan(Fragment fragment) {
        if (this.a != null) {
            this.a.finish(new ARFinishResult(null, FragmentType.ARView, ARConstants.ARFinishMode.RescanMode));
        } else if (fragment != null) {
            fragment.getActivity().finish();
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void setPreviewBitmap(Bitmap bitmap) {
        if (this.a != null) {
            this.a.setPreviewBitmap(bitmap);
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void share(String str, String str2, String str3, String str4, int i) {
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void shareSyncForPlugin(Context context, String str, String str2, String str3, Bitmap bitmap, String str4, String str5, boolean z, boolean z2, e eVar) {
        if (this.a != null) {
            b.a("GraphExternalCallbackClient: bdbox graph callback shareSyncForPlugin");
            this.a.pluginInvokerProxy().shareSyncForPlugin(context, str, str2, str3, bitmap, str4, str5, z, z2, new C0028a(eVar));
        }
    }

    @Override // com.baidu.ar.external.app.IARCallback
    public void transparentLink(String str) {
        b.a("GraphExternalCallbackClient: GraphExternalCallbackClient transparentLink");
    }
}
