package com.baidu.nadcore.webview.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.nadcore.connect.NetWorkUtils;
import com.baidu.nadcore.webview.view.NadBrowserStateView;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.a91;
import com.baidu.tieba.b51;
import com.baidu.tieba.d71;
import com.baidu.tieba.g41;
import com.baidu.tieba.k91;
import com.baidu.tieba.n91;
import com.baidu.tieba.q91;
import com.baidu.tieba.r91;
import com.baidu.tieba.v81;
import com.baidu.tieba.w81;
import com.baidu.tieba.w91;
import com.baidu.tieba.y91;
import com.baidu.tieba.z51;
import com.baidu.tieba.z91;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u009e\u0001\b&\u0018\u0000 ß\u00012\u00020\u00012\u00020\u0002:\u0004ß\u0001à\u0001B9\b\u0017\u0012\u0007\u0010\u0080\u0001\u001a\u00020\u007f\u0012\f\b\u0002\u0010Û\u0001\u001a\u0005\u0018\u00010Ú\u0001\u0012\t\b\u0002\u0010Ü\u0001\u001a\u00020\u001e\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001B\u001f\b\u0016\u0012\u0007\u0010\u0080\u0001\u001a\u00020\u007f\u0012\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003¢\u0006\u0006\bÝ\u0001\u0010\u0083\u0001J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u000bJ\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b!\u0010\u001dJ\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001eH\u0016¢\u0006\u0004\b%\u0010 J\u000f\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010\u000eJ\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u000bJ\r\u0010(\u001a\u00020\u0007¢\u0006\u0004\b(\u0010\u000bJ\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\u000bJ\u0019\u0010,\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010\u000bJ\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u000bJ\u000f\u00100\u001a\u00020\u0007H\u0002¢\u0006\u0004\b0\u0010\u000bJ\u000f\u00101\u001a\u00020\u0007H\u0016¢\u0006\u0004\b1\u0010\u000bJ\u000f\u00102\u001a\u00020\fH&¢\u0006\u0004\b2\u0010\u000eJ\u000f\u00103\u001a\u00020\fH\u0016¢\u0006\u0004\b3\u0010\u000eJ\u000f\u00104\u001a\u00020\fH\u0016¢\u0006\u0004\b4\u0010\u000eJ\u000f\u00105\u001a\u00020\fH&¢\u0006\u0004\b5\u0010\u000eJ\r\u00106\u001a\u00020\f¢\u0006\u0004\b6\u0010\u000eJ\u000f\u00107\u001a\u00020\fH&¢\u0006\u0004\b7\u0010\u000eJ+\u0010;\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000109H\u0017¢\u0006\u0004\b;\u0010<J?\u0010A\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u00052\u001a\b\u0002\u0010?\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010>2\b\b\u0002\u0010@\u001a\u00020\fH\u0017¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0000H\u0016¢\u0006\u0004\bD\u0010EJ'\u0010J\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020\u001e2\b\u0010I\u001a\u0004\u0018\u00010H¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0007H\u0016¢\u0006\u0004\bL\u0010\u000bJ\u000f\u0010M\u001a\u00020\u0007H\u0016¢\u0006\u0004\bM\u0010\u000bJ\u000f\u0010N\u001a\u00020\u0007H\u0016¢\u0006\u0004\bN\u0010\u000bJ\u000f\u0010O\u001a\u00020\u0007H\u0016¢\u0006\u0004\bO\u0010\u000bJ\u000f\u0010P\u001a\u00020\u0007H\u0016¢\u0006\u0004\bP\u0010\u000bJ\u000f\u0010Q\u001a\u00020\u0007H\u0016¢\u0006\u0004\bQ\u0010\u000bJ\u0017\u0010S\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\fH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u0007H\u0016¢\u0006\u0004\bU\u0010\u000bJ\u000f\u0010V\u001a\u00020\u0007H\u0016¢\u0006\u0004\bV\u0010\u000bJ\u000f\u0010W\u001a\u00020\u0007H\u0016¢\u0006\u0004\bW\u0010\u000bJ\u0015\u0010Y\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u001e¢\u0006\u0004\bY\u0010ZJ\u0017\u0010]\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b]\u0010^J#\u0010a\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u00052\b\u0010`\u001a\u0004\u0018\u00010_H\u0016¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020\u0007H\u0016¢\u0006\u0004\bc\u0010\u000bJ\u000f\u0010d\u001a\u00020\u0007H\u0016¢\u0006\u0004\bd\u0010\u000bJ\u0015\u0010f\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\f¢\u0006\u0004\bf\u0010TJ3\u0010m\u001a\u00020\u00072\n\b\u0002\u0010h\u001a\u0004\u0018\u00010g2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010i2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010kH\u0007¢\u0006\u0004\bm\u0010nJ\u000f\u0010o\u001a\u00020\u0007H\u0016¢\u0006\u0004\bo\u0010\u000bJ\u000f\u0010p\u001a\u00020\u0007H\u0016¢\u0006\u0004\bp\u0010\u000bJ\u0017\u0010r\u001a\u00020\u00072\u0006\u0010q\u001a\u00020\fH\u0016¢\u0006\u0004\br\u0010TJ\u0019\u0010u\u001a\u00020\u00072\b\u0010t\u001a\u0004\u0018\u00010sH\u0017¢\u0006\u0004\bu\u0010vJ\u0017\u0010x\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\fH\u0016¢\u0006\u0004\bx\u0010TJ\u0017\u0010z\u001a\u00020\u00072\u0006\u0010y\u001a\u00020\u001eH\u0016¢\u0006\u0004\bz\u0010ZJ\u0017\u0010|\u001a\u00020\u00072\u0006\u0010{\u001a\u00020\u001eH\u0016¢\u0006\u0004\b|\u0010ZJ\r\u0010}\u001a\u00020\u0007¢\u0006\u0004\b}\u0010\u000bJ\u000f\u0010~\u001a\u00020\u0007H\u0007¢\u0006\u0004\b~\u0010\u000bJ$\u0010\u0082\u0001\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u007f2\u0007\u0010\u0081\u0001\u001a\u00020\u0003H\u0016¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082D¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R,\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R(\u0010+\u001a\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\b+\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0005\b\u0090\u0001\u0010-R,\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R'\u0010\u0098\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0005\b\u0098\u0001\u0010\u000e\"\u0005\b\u009a\u0001\u0010TR'\u0010\u009b\u0001\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\b\u009b\u0001\u0010\u0099\u0001\u001a\u0005\b\u009c\u0001\u0010\u000e\"\u0005\b\u009d\u0001\u0010TR\u001a\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R,\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R*\u0010©\u0001\u001a\u00030¨\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R\u001a\u0010°\u0001\u001a\u00030¯\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R,\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b³\u0001\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R,\u0010º\u0001\u001a\u0005\u0018\u00010¹\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R'\u0010e\u001a\u00020\f2\u0007\u0010À\u0001\u001a\u00020\f8\u0002@BX\u0082\u000e¢\u0006\u000e\n\u0005\be\u0010\u0099\u0001\"\u0005\bÁ\u0001\u0010TR'\u0010Â\u0001\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bÂ\u0001\u0010\u0099\u0001\u001a\u0005\bÃ\u0001\u0010\u000e\"\u0005\bÄ\u0001\u0010TR+\u0010Å\u0001\u001a\u0004\u0018\u00010k8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÅ\u0001\u0010Æ\u0001\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R'\u0010Ë\u0001\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bË\u0001\u0010\u0099\u0001\u001a\u0005\bÌ\u0001\u0010\u000e\"\u0005\bÍ\u0001\u0010TR+\u0010Î\u0001\u001a\u0004\u0018\u00010i8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÎ\u0001\u0010Ï\u0001\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\"\u0006\bÒ\u0001\u0010Ó\u0001R+\u0010Ô\u0001\u001a\u0004\u0018\u00010g8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001¨\u0006á\u0001"}, d2 = {"Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;", "Lcom/baidu/tieba/a91;", "Landroid/widget/FrameLayout;", "", "obj", "", "name", "", "addJavaScriptInterface", "(Ljava/lang/Object;Ljava/lang/String;)V", "addWebViewToParent", "()V", "", "canGoBack", "()Z", "canGoForward", "Landroid/view/MotionEvent;", Config.EVENT_PART, "canSlide", "(Landroid/view/MotionEvent;)Z", "clearHistory", "clearView", "freeMemory", "isForward", "getPrePageUrl", "(Z)Ljava/lang/String;", "getSettings", "()Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "", "getTouchMode", "()I", "getUrl", "Landroid/view/View;", "getWebView", "()Landroid/view/View;", "getWebViewScrollY", "handleBack", "hideErrorView", "hideLoadingView", "initJsAbility", "Lcom/baidu/nadcore/webview/prerender/ConsumeData;", "consumeData", "initPreRenderData", "(Lcom/baidu/nadcore/webview/prerender/ConsumeData;)V", "initSettings", "initStateView", "initView", "initWebView", "isDestroyed", "isPreRender", "isSailor", "isScrolledTop", "isValid", "isZeusLoaded", "js", "Landroid/webkit/ValueCallback;", WebChromeClient.KEY_ARG_CALLBACK, "loadJavaScript", "(Ljava/lang/String;Landroid/webkit/ValueCallback;)V", "url", "", Constants.EXTRA_PARAM, StickerDataChangeType.REPLACE, "loadUrl", "(Ljava/lang/String;Ljava/util/Map;Z)V", NativeConstants.TYPE_VIEW, "notifyPreRenderPageFinished", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBrowserViewInitFinished", MissionEvent.MESSAGE_DESTROY, "onHideLoading", "onKernelInitFinished", "onLoadFailure", "onLoadSuccess", "isNight", "onNightModeChanged", "(Z)V", MissionEvent.MESSAGE_PAUSE, "onResume", "onRetryClick", "newProgress", "pageLoadProgressChanged", "(I)V", "Lorg/json/JSONObject;", "performanceData", "postSailor24577", "(Lorg/json/JSONObject;)V", "", "postData", "postUrl", "(Ljava/lang/String;[B)V", "reload", "removeWebViewFromParent", "stateViewVisible", "setStateViewVisibility", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientProxy;", "webViewClient", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientExtProxy;", "webViewClientExt", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebChromeClientProxy;", "webChromeClient", "setWebViewClientProxies", "(Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientProxy;Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientExtProxy;Lcom/baidu/nadcore/webview/webviewclient/AbsWebChromeClientProxy;)V", "setWebViewClients", "setWebViewDownloadListener", "horizontalScrollBarEnabled", "setWebViewHorizontalScrollBarEnabled", "Landroid/view/View$OnTouchListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setWebViewTouchListener", "(Landroid/view/View$OnTouchListener;)V", "verticalScrollBarEnabled", "setWebViewVerticalScrollBarEnabled", "visibility", "setWebViewVisibility", "errorCode", "showErrorView", "showLoadingView", "showToastIfNoNeedPermissions", "Landroid/content/Context;", "context", "asWebView", "wrapHostWebView", "(Landroid/content/Context;Ljava/lang/Object;)V", "TAG", "Ljava/lang/String;", "Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;", "closeWindowListener", "Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;", "getCloseWindowListener", "()Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;", "setCloseWindowListener", "(Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;)V", "Lcom/baidu/nadcore/webview/prerender/ConsumeData;", "getConsumeData", "()Lcom/baidu/nadcore/webview/prerender/ConsumeData;", "setConsumeData", "Lcom/baidu/nadcore/webview/interfaces/IBrowserDownloadListener;", "downloadListener", "Lcom/baidu/nadcore/webview/interfaces/IBrowserDownloadListener;", "getDownloadListener", "()Lcom/baidu/nadcore/webview/interfaces/IBrowserDownloadListener;", "setDownloadListener", "(Lcom/baidu/nadcore/webview/interfaces/IBrowserDownloadListener;)V", "isFirstPage", "Z", "setFirstPage", "needPageLifeCycle", "getNeedPageLifeCycle", "setNeedPageLifeCycle", "com/baidu/nadcore/webview/view/AbsNadBrowserView$pageHandler$1", "pageHandler", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView$pageHandler$1;", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView$IPageSessionCollector;", "pageSessionCollector", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView$IPageSessionCollector;", "getPageSessionCollector", "()Lcom/baidu/nadcore/webview/view/AbsNadBrowserView$IPageSessionCollector;", "setPageSessionCollector", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView$IPageSessionCollector;)V", "", "preRenderArrival", "J", "getPreRenderArrival", "()J", "setPreRenderArrival", "(J)V", "Landroid/view/View$OnClickListener;", "retryClickLister", "Landroid/view/View$OnClickListener;", "Lcom/baidu/nadcore/webview/interfaces/PageStateChangeCallback;", "stateChangeCallback", "Lcom/baidu/nadcore/webview/interfaces/PageStateChangeCallback;", "getStateChangeCallback", "()Lcom/baidu/nadcore/webview/interfaces/PageStateChangeCallback;", "setStateChangeCallback", "(Lcom/baidu/nadcore/webview/interfaces/PageStateChangeCallback;)V", "Lcom/baidu/nadcore/webview/view/NadBrowserStateView;", "stateView", "Lcom/baidu/nadcore/webview/view/NadBrowserStateView;", "getStateView", "()Lcom/baidu/nadcore/webview/view/NadBrowserStateView;", "setStateView", "(Lcom/baidu/nadcore/webview/view/NadBrowserStateView;)V", "value", "setStateViewVisible", "usePreRender", "getUsePreRender", "setUsePreRender", "webChromeClientProxy", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebChromeClientProxy;", "getWebChromeClientProxy", "()Lcom/baidu/nadcore/webview/webviewclient/AbsWebChromeClientProxy;", "setWebChromeClientProxy", "(Lcom/baidu/nadcore/webview/webviewclient/AbsWebChromeClientProxy;)V", "webViewCanGoBack", "getWebViewCanGoBack", "setWebViewCanGoBack", "webViewClientExtProxy", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientExtProxy;", "getWebViewClientExtProxy", "()Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientExtProxy;", "setWebViewClientExtProxy", "(Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientExtProxy;)V", "webViewClientProxy", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientProxy;", "getWebViewClientProxy", "()Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientProxy;", "setWebViewClientProxy", "(Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientProxy;)V", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/baidu/nadcore/webview/prerender/ConsumeData;)V", "Companion", "IPageSessionCollector", "lib-webview_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public abstract class AbsNadBrowserView extends FrameLayout implements a91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public a91 b;
    public final q91 c;
    public final View.OnClickListener d;
    public NadBrowserStateView e;
    public boolean f;
    public z91 g;
    public y91 h;
    public w91 i;
    public v81 j;
    public boolean k;
    public boolean l;
    public boolean m;
    public a n;
    public k91 o;
    public boolean p;
    public long q;
    public w81 r;

    /* loaded from: classes2.dex */
    public interface a {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2120259540, "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2120259540, "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsNadBrowserView(Context context) {
        this(context, null, 0, null, 14, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (k91) objArr2[3], ((Integer) objArr2[4]).intValue(), (DefaultConstructorMarker) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsNadBrowserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (k91) objArr2[3], ((Integer) objArr2[4]).intValue(), (DefaultConstructorMarker) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsNadBrowserView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, 8, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (k91) objArr2[3], ((Integer) objArr2[4]).intValue(), (DefaultConstructorMarker) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public void F(AbsNadBrowserView view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void P(JSONObject performanceData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, performanceData) == null) {
            Intrinsics.checkNotNullParameter(performanceData, "performanceData");
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public abstract void a(Object obj, String str);

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public abstract boolean d();

    public boolean e(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    public abstract Object getSettings();

    public abstract String getTitle();

    public abstract int getTouchMode();

    public abstract View getWebView();

    public int getWebViewScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
        }
    }

    public void n(k91 k91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, k91Var) == null) {
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    public abstract boolean s();

    @JvmOverloads
    public final void setWebViewClientProxies() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            setWebViewClientProxies$default(this, null, null, null, 7, null);
        }
    }

    @JvmOverloads
    public final void setWebViewClientProxies(z91 z91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, z91Var) == null) {
            setWebViewClientProxies$default(this, z91Var, null, null, 6, null);
        }
    }

    @JvmOverloads
    public final void setWebViewClientProxies(z91 z91Var, y91 y91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048647, this, z91Var, y91Var) == null) {
            setWebViewClientProxies$default(this, z91Var, y91Var, null, 4, null);
        }
    }

    public void setWebViewDownloadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
        }
    }

    public void setWebViewHorizontalScrollBarEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setWebViewTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, onTouchListener) == null) {
        }
    }

    public void setWebViewVerticalScrollBarEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
        }
    }

    public void setWebViewVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i) == null) {
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean x();

    public abstract boolean z();

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsNadBrowserView a;

        public b(AbsNadBrowserView absNadBrowserView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absNadBrowserView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absNadBrowserView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.N();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsNadBrowserView(Context context, AttributeSet attributeSet, int i, k91 k91Var) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), k91Var};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = "AbsNadBrowserView";
        this.c = new q91(this);
        this.d = new r91(this);
        this.f = true;
        this.k = true;
        this.q = -1L;
        n(k91Var);
        q();
    }

    public /* synthetic */ AbsNadBrowserView(Context context, AttributeSet attributeSet, int i, k91 k91Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : k91Var);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.nadcore.webview.view.AbsNadBrowserView */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void E(AbsNadBrowserView absNadBrowserView, String str, Map map, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                map = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            absNadBrowserView.D(str, map, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadUrl");
    }

    public static /* synthetic */ void setWebViewClientProxies$default(AbsNadBrowserView absNadBrowserView, z91 z91Var, y91 y91Var, w91 w91Var, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z91Var = null;
            }
            if ((i & 2) != 0) {
                y91Var = null;
            }
            if ((i & 4) != 0) {
                w91Var = null;
            }
            absNadBrowserView.setWebViewClientProxies(z91Var, y91Var, w91Var);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWebViewClientProxies");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.nadcore.webview.view.AbsNadBrowserView */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void C(AbsNadBrowserView absNadBrowserView, String str, ValueCallback valueCallback, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                valueCallback = null;
            }
            absNadBrowserView.A(str, valueCallback);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadJavaScript");
    }

    private final void setStateViewVisible(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            this.f = z;
            NadBrowserStateView nadBrowserStateView = this.e;
            if (nadBrowserStateView != null) {
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                nadBrowserStateView.setVisibility(i);
            }
        }
    }

    public final void O(int i) {
        NadBrowserStateView nadBrowserStateView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (nadBrowserStateView = this.e) != null) {
            nadBrowserStateView.e(i);
        }
    }

    public final void setCloseWindowListener(w81 w81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, w81Var) == null) {
            this.r = w81Var;
        }
    }

    public final void setConsumeData(k91 k91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, k91Var) == null) {
            this.o = k91Var;
        }
    }

    public final void setDownloadListener(v81 v81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, v81Var) == null) {
            this.j = v81Var;
        }
    }

    public final void setFirstPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.l = z;
        }
    }

    public final void setNeedPageLifeCycle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.m = z;
        }
    }

    public final void setPageSessionCollector(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, aVar) == null) {
            this.n = aVar;
        }
    }

    public final void setPreRenderArrival(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048637, this, j) == null) {
            this.q = j;
        }
    }

    public final void setStateChangeCallback(a91 a91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, a91Var) == null) {
            this.b = a91Var;
        }
    }

    public final void setStateView(NadBrowserStateView nadBrowserStateView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, nadBrowserStateView) == null) {
            this.e = nadBrowserStateView;
        }
    }

    public final void setStateViewVisibility(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            setStateViewVisible(z);
            NadBrowserStateView nadBrowserStateView = this.e;
            if (nadBrowserStateView != null) {
                Intrinsics.checkNotNull(nadBrowserStateView);
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                nadBrowserStateView.setVisibility(i);
            }
        }
    }

    public final void setUsePreRender(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z) == null) {
            this.p = z;
        }
    }

    public final void setWebChromeClientProxy(w91 w91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, w91Var) == null) {
            this.i = w91Var;
        }
    }

    public final void setWebViewCanGoBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.k = z;
        }
    }

    public final void setWebViewClientExtProxy(y91 y91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, y91Var) == null) {
            this.h = y91Var;
        }
    }

    public final void setWebViewClientProxy(z91 z91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, z91Var) == null) {
            this.g = z91Var;
        }
    }

    @JvmOverloads
    public void A(String str, ValueCallback<String> valueCallback) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, valueCallback) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z || s()) {
            }
        }
    }

    @JvmOverloads
    public void D(String str, Map<String, String> map, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map, z) == null) {
            if (str != null && str.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2 && !s()) {
                return;
            }
            n91.d(new IllegalArgumentException("try to loading an empty url!"));
        }
    }

    public final void G(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            d71 c = d71.c();
            Context context = getContext();
            if (context != null) {
                c.g((Activity) context, i, i2, intent);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
    }

    @JvmOverloads
    public final void setWebViewClientProxies(z91 z91Var, y91 y91Var, w91 w91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048648, this, z91Var, y91Var, w91Var) == null) {
            this.g = z91Var;
            this.h = y91Var;
            this.i = w91Var;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setWebViewClients();
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            n91.a(this.a, "销毁 browserView");
            d71.c().f((Activity) getContext());
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || !NetWorkUtils.b(getContext())) {
            return;
        }
        Q();
        U();
    }

    public final void U() {
        NadBrowserStateView nadBrowserStateView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.f && (nadBrowserStateView = this.e) != null) {
                nadBrowserStateView.setVisibility(0);
            }
            NadBrowserStateView nadBrowserStateView2 = this.e;
            if (nadBrowserStateView2 != null) {
                nadBrowserStateView2.f(NadBrowserStateView.ViewState.LOADING);
            }
            NadBrowserStateView nadBrowserStateView3 = this.e;
            if (nadBrowserStateView3 != null) {
                nadBrowserStateView3.b(NadBrowserStateView.ViewState.ERROR);
            }
        }
    }

    public final w81 getCloseWindowListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.r;
        }
        return (w81) invokeV.objValue;
    }

    public final k91 getConsumeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.o;
        }
        return (k91) invokeV.objValue;
    }

    public final v81 getDownloadListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.j;
        }
        return (v81) invokeV.objValue;
    }

    public final boolean getNeedPageLifeCycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final a getPageSessionCollector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.n;
        }
        return (a) invokeV.objValue;
    }

    public final long getPreRenderArrival() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.q;
        }
        return invokeV.longValue;
    }

    public final a91 getStateChangeCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.b;
        }
        return (a91) invokeV.objValue;
    }

    public final NadBrowserStateView getStateView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.e;
        }
        return (NadBrowserStateView) invokeV.objValue;
    }

    public final boolean getUsePreRender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public final w91 getWebChromeClientProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.i;
        }
        return (w91) invokeV.objValue;
    }

    public final boolean getWebViewCanGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public final y91 getWebViewClientExtProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.h;
        }
        return (y91) invokeV.objValue;
    }

    public final z91 getWebViewClientProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.g;
        }
        return (z91) invokeV.objValue;
    }

    public void k() {
        NadBrowserStateView nadBrowserStateView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (nadBrowserStateView = this.e) != null) {
            nadBrowserStateView.b(NadBrowserStateView.ViewState.ERROR);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            onHideLoading();
            NadBrowserStateView nadBrowserStateView = this.e;
            if (nadBrowserStateView != null) {
                nadBrowserStateView.b(NadBrowserStateView.ViewState.LOADING);
            }
        }
    }

    @Override // com.baidu.tieba.a91
    public void onHideLoading() {
        a91 a91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (a91Var = this.b) != null) {
            a91Var.onHideLoading();
        }
    }

    @Override // com.baidu.tieba.a91
    public void onLoadFailure() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            Message obtain = Message.obtain(this.c, 2, -6, 0);
            n91.a(this.a, "load fail");
            this.c.sendMessage(obtain);
            a91 a91Var = this.b;
            if (a91Var != null) {
                a91Var.onLoadFailure();
            }
        }
    }

    @Override // com.baidu.tieba.a91
    public void onLoadSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            n91.a(this.a, "load success");
            this.c.sendEmptyMessage(1);
            a91 a91Var = this.b;
            if (a91Var != null) {
                a91Var.onLoadSuccess();
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (!(getContext() instanceof Activity)) {
                n91.d(new RuntimeException("Context must be instanceOf Activity"));
            }
            r();
            p();
            J();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            setWebViewDownloadListener();
            o();
            m();
            c();
        }
    }

    public void setWebViewClients() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            n91.a(this.a, "setWebViewClients");
        }
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return !s();
        }
        return invokeV.booleanValue;
    }

    public void T(int i) {
        NadBrowserStateView nadBrowserStateView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (i == 0) {
                k();
                return;
            }
            if (this.f && (nadBrowserStateView = this.e) != null) {
                nadBrowserStateView.setVisibility(0);
            }
            NadBrowserStateView nadBrowserStateView2 = this.e;
            if (nadBrowserStateView2 != null) {
                nadBrowserStateView2.f(NadBrowserStateView.ViewState.ERROR);
            }
            NadBrowserStateView nadBrowserStateView3 = this.e;
            if (nadBrowserStateView3 != null) {
                nadBrowserStateView3.b(NadBrowserStateView.ViewState.LOADING);
            }
        }
    }

    @TargetApi(23)
    public final void V() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !b51.b.d()) {
            return;
        }
        if (z51.a(getContext(), PermissionRequest.RESOURCE_AUDIO_CAPTURE) != 0 || z51.a(getContext(), PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            g41.a().a(getContext(), R.string.input_file_no_permission_note_text);
        }
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            Thread currentThread = Thread.currentThread();
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
            if (!Intrinsics.areEqual(currentThread, mainLooper.getThread())) {
                n91.d(new IllegalStateException("get url in wrong thread"));
                return null;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void p() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            NadBrowserStateView nadBrowserStateView = new NadBrowserStateView(context, null, 2, null);
            this.e = nadBrowserStateView;
            if (nadBrowserStateView != null) {
                nadBrowserStateView.setErrorViewClickListener(this.d);
            }
            NadBrowserStateView nadBrowserStateView2 = this.e;
            if (nadBrowserStateView2 != null) {
                view2 = nadBrowserStateView2.a(NadBrowserStateView.ViewState.ERROR);
            } else {
                view2 = null;
            }
            if (view2 != null) {
                view2.setOnClickListener(new b(this));
                NadBrowserStateView nadBrowserStateView3 = this.e;
                if (nadBrowserStateView3 != null) {
                    nadBrowserStateView3.setErrorViewClickListener(null);
                }
            }
            addView(this.e, new FrameLayout.LayoutParams(-1, -1));
        }
    }
}
