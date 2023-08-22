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
import com.baidu.mobstat.Config;
import com.baidu.nadcore.connect.NetWorkUtils;
import com.baidu.nadcore.webview.view.NadBrowserStateView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.cb1;
import com.baidu.tieba.fb1;
import com.baidu.tieba.ib1;
import com.baidu.tieba.jb1;
import com.baidu.tieba.m61;
import com.baidu.tieba.na1;
import com.baidu.tieba.o51;
import com.baidu.tieba.o71;
import com.baidu.tieba.oa1;
import com.baidu.tieba.ob1;
import com.baidu.tieba.qb1;
import com.baidu.tieba.rb1;
import com.baidu.tieba.s81;
import com.baidu.tieba.sa1;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.baidu.webkit.sdk.PermissionRequest;
import com.baidu.webkit.sdk.WebChromeClient;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002¡\u0001\b&\u0018\u0000 â\u00012\u00020\u00012\u00020\u0002:\u0004â\u0001ã\u0001B:\b\u0017\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\f\b\u0002\u0010Þ\u0001\u001a\u0005\u0018\u00010Ý\u0001\u0012\t\b\u0002\u0010ß\u0001\u001a\u00020\u001e\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0006\bà\u0001\u0010á\u0001B \b\u0016\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003¢\u0006\u0006\bà\u0001\u0010\u0086\u0001J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u000bJ\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b!\u0010\u001dJ\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001eH\u0016¢\u0006\u0004\b%\u0010 J\u000f\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010\u000eJ\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u000bJ\r\u0010(\u001a\u00020\u0007¢\u0006\u0004\b(\u0010\u000bJ\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\u000bJ\u0019\u0010,\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010\u000bJ\u000f\u0010/\u001a\u00020\u0007H\u0002¢\u0006\u0004\b/\u0010\u000bJ\u000f\u00100\u001a\u00020\u0007H\u0002¢\u0006\u0004\b0\u0010\u000bJ\u000f\u00101\u001a\u00020\u0007H\u0016¢\u0006\u0004\b1\u0010\u000bJ\u000f\u00102\u001a\u00020\fH&¢\u0006\u0004\b2\u0010\u000eJ\u000f\u00103\u001a\u00020\fH\u0016¢\u0006\u0004\b3\u0010\u000eJ\u000f\u00104\u001a\u00020\fH\u0016¢\u0006\u0004\b4\u0010\u000eJ\u000f\u00105\u001a\u00020\fH&¢\u0006\u0004\b5\u0010\u000eJ\r\u00106\u001a\u00020\f¢\u0006\u0004\b6\u0010\u000eJ\u000f\u00107\u001a\u00020\fH&¢\u0006\u0004\b7\u0010\u000eJ+\u0010;\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000109H\u0017¢\u0006\u0004\b;\u0010<J?\u0010A\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u00052\u001a\b\u0002\u0010?\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010>2\b\b\u0002\u0010@\u001a\u00020\fH\u0017¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0000H\u0016¢\u0006\u0004\bD\u0010EJ'\u0010J\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020\u001e2\b\u0010I\u001a\u0004\u0018\u00010H¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0007H\u0016¢\u0006\u0004\bL\u0010\u000bJ\u000f\u0010M\u001a\u00020\u0007H\u0016¢\u0006\u0004\bM\u0010\u000bJ\u000f\u0010N\u001a\u00020\u0007H\u0016¢\u0006\u0004\bN\u0010\u000bJ\u000f\u0010O\u001a\u00020\u0007H\u0016¢\u0006\u0004\bO\u0010\u000bJ\u000f\u0010P\u001a\u00020\u0007H\u0016¢\u0006\u0004\bP\u0010\u000bJ\u000f\u0010Q\u001a\u00020\u0007H\u0016¢\u0006\u0004\bQ\u0010\u000bJ\u0017\u0010S\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\fH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u0007H\u0016¢\u0006\u0004\bU\u0010\u000bJ\u000f\u0010V\u001a\u00020\u0007H\u0016¢\u0006\u0004\bV\u0010\u000bJ\u000f\u0010W\u001a\u00020\u0007H\u0016¢\u0006\u0004\bW\u0010\u000bJ\u0015\u0010Y\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u001e¢\u0006\u0004\bY\u0010ZJ\u0017\u0010]\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b]\u0010^J#\u0010a\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u00052\b\u0010`\u001a\u0004\u0018\u00010_H\u0016¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020\u0007H\u0016¢\u0006\u0004\bc\u0010\u000bJ\u000f\u0010d\u001a\u00020\u0007H\u0016¢\u0006\u0004\bd\u0010\u000bJ\u0015\u0010f\u001a\u00020\u00072\u0006\u0010e\u001a\u00020\f¢\u0006\u0004\bf\u0010TJ\u0017\u0010h\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u0005H&¢\u0006\u0004\bh\u0010iJ3\u0010p\u001a\u00020\u00072\n\b\u0002\u0010k\u001a\u0004\u0018\u00010j2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010l2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010nH\u0007¢\u0006\u0004\bp\u0010qJ\u000f\u0010r\u001a\u00020\u0007H\u0016¢\u0006\u0004\br\u0010\u000bJ\u000f\u0010s\u001a\u00020\u0007H\u0016¢\u0006\u0004\bs\u0010\u000bJ\u0017\u0010u\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\fH\u0016¢\u0006\u0004\bu\u0010TJ\u0019\u0010x\u001a\u00020\u00072\b\u0010w\u001a\u0004\u0018\u00010vH\u0017¢\u0006\u0004\bx\u0010yJ\u0017\u0010{\u001a\u00020\u00072\u0006\u0010z\u001a\u00020\fH\u0016¢\u0006\u0004\b{\u0010TJ\u0017\u0010}\u001a\u00020\u00072\u0006\u0010|\u001a\u00020\u001eH\u0016¢\u0006\u0004\b}\u0010ZJ\u0017\u0010\u007f\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u007f\u0010ZJ\u000f\u0010\u0080\u0001\u001a\u00020\u0007¢\u0006\u0005\b\u0080\u0001\u0010\u000bJ\u0011\u0010\u0081\u0001\u001a\u00020\u0007H\u0007¢\u0006\u0005\b\u0081\u0001\u0010\u000bJ%\u0010\u0085\u0001\u001a\u00020\u00072\b\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u0003H\u0016¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u0087\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082D¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R,\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R(\u0010+\u001a\u0004\u0018\u00010*8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0005\b+\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0005\b\u0093\u0001\u0010-R,\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R'\u0010\u009b\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0005\b\u009b\u0001\u0010\u000e\"\u0005\b\u009d\u0001\u0010TR'\u0010\u009e\u0001\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\b\u009e\u0001\u0010\u009c\u0001\u001a\u0005\b\u009f\u0001\u0010\u000e\"\u0005\b \u0001\u0010TR\u001a\u0010¢\u0001\u001a\u00030¡\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R,\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R*\u0010¬\u0001\u001a\u00030«\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u001a\u0010³\u0001\u001a\u00030²\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R,\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¶\u0001\u0010·\u0001\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R,\u0010½\u0001\u001a\u0005\u0018\u00010¼\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b½\u0001\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R'\u0010e\u001a\u00020\f2\u0007\u0010Ã\u0001\u001a\u00020\f8\u0002@BX\u0082\u000e¢\u0006\u000e\n\u0005\be\u0010\u009c\u0001\"\u0005\bÄ\u0001\u0010TR'\u0010Å\u0001\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bÅ\u0001\u0010\u009c\u0001\u001a\u0005\bÆ\u0001\u0010\u000e\"\u0005\bÇ\u0001\u0010TR+\u0010È\u0001\u001a\u0004\u0018\u00010n8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R'\u0010Î\u0001\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0016\n\u0006\bÎ\u0001\u0010\u009c\u0001\u001a\u0005\bÏ\u0001\u0010\u000e\"\u0005\bÐ\u0001\u0010TR+\u0010Ñ\u0001\u001a\u0004\u0018\u00010l8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÑ\u0001\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R+\u0010×\u0001\u001a\u0004\u0018\u00010j8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\b×\u0001\u0010Ø\u0001\u001a\u0006\bÙ\u0001\u0010Ú\u0001\"\u0006\bÛ\u0001\u0010Ü\u0001¨\u0006ä\u0001"}, d2 = {"Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;", "Lcom/baidu/tieba/sa1;", "Landroid/widget/FrameLayout;", "", "obj", "", "name", "", "addJavaScriptInterface", "(Ljava/lang/Object;Ljava/lang/String;)V", "addWebViewToParent", "()V", "", "canGoBack", "()Z", "canGoForward", "Landroid/view/MotionEvent;", Config.EVENT_PART, "canSlide", "(Landroid/view/MotionEvent;)Z", "clearHistory", "clearView", "freeMemory", "isForward", "getPrePageUrl", "(Z)Ljava/lang/String;", "getSettings", "()Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "", "getTouchMode", "()I", "getUrl", "Landroid/view/View;", "getWebView", "()Landroid/view/View;", "getWebViewScrollY", "handleBack", "hideErrorView", "hideLoadingView", "initJsAbility", "Lcom/baidu/nadcore/webview/prerender/ConsumeData;", "consumeData", "initPreRenderData", "(Lcom/baidu/nadcore/webview/prerender/ConsumeData;)V", "initSettings", "initStateView", "initView", "initWebView", "isDestroyed", "isPreRender", "isSailor", "isScrolledTop", "isValid", "isZeusLoaded", "js", "Landroid/webkit/ValueCallback;", WebChromeClient.KEY_ARG_CALLBACK, "loadJavaScript", "(Ljava/lang/String;Landroid/webkit/ValueCallback;)V", "url", "", "param", StickerDataChangeType.REPLACE, "loadUrl", "(Ljava/lang/String;Ljava/util/Map;Z)V", "view", "notifyPreRenderPageFinished", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBrowserViewInitFinished", MissionEvent.MESSAGE_DESTROY, "onHideLoading", "onKernelInitFinished", "onLoadFailure", "onLoadSuccess", "isNight", "onNightModeChanged", "(Z)V", MissionEvent.MESSAGE_PAUSE, "onResume", "onRetryClick", "newProgress", "pageLoadProgressChanged", "(I)V", "Lorg/json/JSONObject;", "performanceData", "postSailor24577", "(Lorg/json/JSONObject;)V", "", "postData", "postUrl", "(Ljava/lang/String;[B)V", "reload", "removeWebViewFromParent", "stateViewVisible", "setStateViewVisibility", TTDownloadField.TT_USERAGENT, "setUserAgentString", "(Ljava/lang/String;)V", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientProxy;", "webViewClient", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientExtProxy;", "webViewClientExt", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebChromeClientProxy;", "webChromeClient", "setWebViewClientProxies", "(Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientProxy;Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientExtProxy;Lcom/baidu/nadcore/webview/webviewclient/AbsWebChromeClientProxy;)V", "setWebViewClients", "setWebViewDownloadListener", "horizontalScrollBarEnabled", "setWebViewHorizontalScrollBarEnabled", "Landroid/view/View$OnTouchListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setWebViewTouchListener", "(Landroid/view/View$OnTouchListener;)V", "verticalScrollBarEnabled", "setWebViewVerticalScrollBarEnabled", "visibility", "setWebViewVisibility", "errorCode", "showErrorView", "showLoadingView", "showToastIfNoNeedPermissions", "Landroid/content/Context;", "context", "asWebView", "wrapHostWebView", "(Landroid/content/Context;Ljava/lang/Object;)V", "TAG", "Ljava/lang/String;", "Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;", "closeWindowListener", "Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;", "getCloseWindowListener", "()Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;", "setCloseWindowListener", "(Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;)V", "Lcom/baidu/nadcore/webview/prerender/ConsumeData;", "getConsumeData", "()Lcom/baidu/nadcore/webview/prerender/ConsumeData;", "setConsumeData", "Lcom/baidu/nadcore/webview/interfaces/IBrowserDownloadListener;", "downloadListener", "Lcom/baidu/nadcore/webview/interfaces/IBrowserDownloadListener;", "getDownloadListener", "()Lcom/baidu/nadcore/webview/interfaces/IBrowserDownloadListener;", "setDownloadListener", "(Lcom/baidu/nadcore/webview/interfaces/IBrowserDownloadListener;)V", "isFirstPage", "Z", "setFirstPage", "needPageLifeCycle", "getNeedPageLifeCycle", "setNeedPageLifeCycle", "com/baidu/nadcore/webview/view/AbsNadBrowserView$pageHandler$1", "pageHandler", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView$pageHandler$1;", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView$IPageSessionCollector;", "pageSessionCollector", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView$IPageSessionCollector;", "getPageSessionCollector", "()Lcom/baidu/nadcore/webview/view/AbsNadBrowserView$IPageSessionCollector;", "setPageSessionCollector", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView$IPageSessionCollector;)V", "", "preRenderArrival", "J", "getPreRenderArrival", "()J", "setPreRenderArrival", "(J)V", "Landroid/view/View$OnClickListener;", "retryClickLister", "Landroid/view/View$OnClickListener;", "Lcom/baidu/nadcore/webview/interfaces/PageStateChangeCallback;", "stateChangeCallback", "Lcom/baidu/nadcore/webview/interfaces/PageStateChangeCallback;", "getStateChangeCallback", "()Lcom/baidu/nadcore/webview/interfaces/PageStateChangeCallback;", "setStateChangeCallback", "(Lcom/baidu/nadcore/webview/interfaces/PageStateChangeCallback;)V", "Lcom/baidu/nadcore/webview/view/NadBrowserStateView;", "stateView", "Lcom/baidu/nadcore/webview/view/NadBrowserStateView;", "getStateView", "()Lcom/baidu/nadcore/webview/view/NadBrowserStateView;", "setStateView", "(Lcom/baidu/nadcore/webview/view/NadBrowserStateView;)V", "value", "setStateViewVisible", "usePreRender", "getUsePreRender", "setUsePreRender", "webChromeClientProxy", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebChromeClientProxy;", "getWebChromeClientProxy", "()Lcom/baidu/nadcore/webview/webviewclient/AbsWebChromeClientProxy;", "setWebChromeClientProxy", "(Lcom/baidu/nadcore/webview/webviewclient/AbsWebChromeClientProxy;)V", "webViewCanGoBack", "getWebViewCanGoBack", "setWebViewCanGoBack", "webViewClientExtProxy", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientExtProxy;", "getWebViewClientExtProxy", "()Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientExtProxy;", "setWebViewClientExtProxy", "(Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientExtProxy;)V", "webViewClientProxy", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientProxy;", "getWebViewClientProxy", "()Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientProxy;", "setWebViewClientProxy", "(Lcom/baidu/nadcore/webview/webviewclient/AbsWebViewClientProxy;)V", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/baidu/nadcore/webview/prerender/ConsumeData;)V", "Companion", "IPageSessionCollector", "lib-webview_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class AbsNadBrowserView extends FrameLayout implements sa1 {
    public final String a;
    public sa1 b;
    public final ib1 c;
    public final View.OnClickListener d;
    public NadBrowserStateView e;
    public boolean f;
    public rb1 g;
    public qb1 h;
    public ob1 i;
    public na1 j;
    public boolean k;
    public boolean l;
    public boolean m;
    public a n;
    public cb1 o;
    public boolean p;
    public long q;
    public oa1 r;

    /* loaded from: classes3.dex */
    public interface a {
    }

    @JvmOverloads
    public AbsNadBrowserView(Context context) {
        this(context, null, 0, null, 14, null);
    }

    @JvmOverloads
    public AbsNadBrowserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
    }

    @JvmOverloads
    public AbsNadBrowserView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, 8, null);
    }

    public void F(AbsNadBrowserView view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
    }

    public void J() {
    }

    public void K() {
    }

    public void M() {
    }

    public void P(JSONObject performanceData) {
        Intrinsics.checkNotNullParameter(performanceData, "performanceData");
    }

    public void R() {
    }

    public void S() {
    }

    public abstract void a(Object obj, String str);

    public void b() {
    }

    public abstract boolean d();

    public boolean g(MotionEvent motionEvent) {
        return true;
    }

    public abstract Object getSettings();

    public abstract String getTitle();

    public abstract int getTouchMode();

    public abstract View getWebView();

    public int getWebViewScrollY() {
        return 0;
    }

    public void h() {
    }

    public void i() {
    }

    public boolean j() {
        return false;
    }

    public void m() {
    }

    public void n(cb1 cb1Var) {
    }

    public void o() {
    }

    public abstract void setUserAgentString(String str);

    @JvmOverloads
    public final void setWebViewClientProxies() {
        setWebViewClientProxies$default(this, null, null, null, 7, null);
    }

    @JvmOverloads
    public final void setWebViewClientProxies(rb1 rb1Var) {
        setWebViewClientProxies$default(this, rb1Var, null, null, 6, null);
    }

    @JvmOverloads
    public final void setWebViewClientProxies(rb1 rb1Var, qb1 qb1Var) {
        setWebViewClientProxies$default(this, rb1Var, qb1Var, null, 4, null);
    }

    public void setWebViewDownloadListener() {
    }

    public void setWebViewHorizontalScrollBarEnabled(boolean z) {
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setWebViewTouchListener(View.OnTouchListener onTouchListener) {
    }

    public void setWebViewVerticalScrollBarEnabled(boolean z) {
    }

    public void setWebViewVisibility(int i) {
    }

    public abstract boolean t();

    public boolean v() {
        return false;
    }

    public boolean w() {
        return false;
    }

    public abstract boolean x();

    public abstract boolean z();

    /* loaded from: classes3.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            AbsNadBrowserView.this.N();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsNadBrowserView(Context context, AttributeSet attributeSet, int i, cb1 cb1Var) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = "AbsNadBrowserView";
        this.c = new ib1(this);
        this.d = new jb1(this);
        this.f = true;
        this.k = true;
        this.q = -1L;
        n(cb1Var);
        q();
    }

    public /* synthetic */ AbsNadBrowserView(Context context, AttributeSet attributeSet, int i, cb1 cb1Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : cb1Var);
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

    public static /* synthetic */ void setWebViewClientProxies$default(AbsNadBrowserView absNadBrowserView, rb1 rb1Var, qb1 qb1Var, ob1 ob1Var, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                rb1Var = null;
            }
            if ((i & 2) != 0) {
                qb1Var = null;
            }
            if ((i & 4) != 0) {
                ob1Var = null;
            }
            absNadBrowserView.setWebViewClientProxies(rb1Var, qb1Var, ob1Var);
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
            absNadBrowserView.B(str, valueCallback);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadJavaScript");
    }

    private final void setStateViewVisible(boolean z) {
        int i;
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

    public final void O(int i) {
        NadBrowserStateView nadBrowserStateView = this.e;
        if (nadBrowserStateView != null) {
            nadBrowserStateView.e(i);
        }
    }

    public void T(int i) {
        NadBrowserStateView nadBrowserStateView;
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

    public final void setCloseWindowListener(oa1 oa1Var) {
        this.r = oa1Var;
    }

    public final void setConsumeData(cb1 cb1Var) {
        this.o = cb1Var;
    }

    public final void setDownloadListener(na1 na1Var) {
        this.j = na1Var;
    }

    public final void setFirstPage(boolean z) {
        this.l = z;
    }

    public final void setNeedPageLifeCycle(boolean z) {
        this.m = z;
    }

    public final void setPageSessionCollector(a aVar) {
        this.n = aVar;
    }

    public final void setPreRenderArrival(long j) {
        this.q = j;
    }

    public final void setStateChangeCallback(sa1 sa1Var) {
        this.b = sa1Var;
    }

    public final void setStateView(NadBrowserStateView nadBrowserStateView) {
        this.e = nadBrowserStateView;
    }

    public final void setStateViewVisibility(boolean z) {
        int i;
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

    public final void setUsePreRender(boolean z) {
        this.p = z;
    }

    public final void setWebChromeClientProxy(ob1 ob1Var) {
        this.i = ob1Var;
    }

    public final void setWebViewCanGoBack(boolean z) {
        this.k = z;
    }

    public final void setWebViewClientExtProxy(qb1 qb1Var) {
        this.h = qb1Var;
    }

    public final void setWebViewClientProxy(rb1 rb1Var) {
        this.g = rb1Var;
    }

    @JvmOverloads
    public void B(String str, ValueCallback<String> valueCallback) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z || t()) {
        }
    }

    @JvmOverloads
    public void D(String str, Map<String, String> map, boolean z) {
        boolean z2;
        if (str != null && str.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 && !t()) {
            return;
        }
        fb1.d(new IllegalArgumentException("try to loading an empty url!"));
    }

    public final void G(int i, int i2, Intent intent) {
        s81 c = s81.c();
        Context context = getContext();
        if (context != null) {
            c.g((Activity) context, i, i2, intent);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    @JvmOverloads
    public final void setWebViewClientProxies(rb1 rb1Var, qb1 qb1Var, ob1 ob1Var) {
        this.g = rb1Var;
        this.h = qb1Var;
        this.i = ob1Var;
    }

    public void H() {
        setWebViewClients();
    }

    public void I() {
        fb1.a(this.a, "销毁 browserView");
        s81.c().f((Activity) getContext());
    }

    public void N() {
        if (!NetWorkUtils.b(getContext())) {
            return;
        }
        R();
        U();
    }

    public final void U() {
        NadBrowserStateView nadBrowserStateView;
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

    @TargetApi(23)
    public final void V() {
        if (!m61.b.d()) {
            return;
        }
        if (o71.a(getContext(), PermissionRequest.RESOURCE_AUDIO_CAPTURE) != 0 || o71.a(getContext(), PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            o51.a().a(getContext(), R.string.input_file_no_permission_note_text);
        }
    }

    public final oa1 getCloseWindowListener() {
        return this.r;
    }

    public final cb1 getConsumeData() {
        return this.o;
    }

    public final na1 getDownloadListener() {
        return this.j;
    }

    public final boolean getNeedPageLifeCycle() {
        return this.m;
    }

    public final a getPageSessionCollector() {
        return this.n;
    }

    public final long getPreRenderArrival() {
        return this.q;
    }

    public final sa1 getStateChangeCallback() {
        return this.b;
    }

    public final NadBrowserStateView getStateView() {
        return this.e;
    }

    public String getUrl() {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        if (!Intrinsics.areEqual(currentThread, mainLooper.getThread())) {
            fb1.d(new IllegalStateException("get url in wrong thread"));
            return null;
        }
        return "";
    }

    public final boolean getUsePreRender() {
        return this.p;
    }

    public final ob1 getWebChromeClientProxy() {
        return this.i;
    }

    public final boolean getWebViewCanGoBack() {
        return this.k;
    }

    public final qb1 getWebViewClientExtProxy() {
        return this.h;
    }

    public final rb1 getWebViewClientProxy() {
        return this.g;
    }

    public void k() {
        NadBrowserStateView nadBrowserStateView = this.e;
        if (nadBrowserStateView != null) {
            nadBrowserStateView.b(NadBrowserStateView.ViewState.ERROR);
        }
    }

    public final void l() {
        onHideLoading();
        NadBrowserStateView nadBrowserStateView = this.e;
        if (nadBrowserStateView != null) {
            nadBrowserStateView.b(NadBrowserStateView.ViewState.LOADING);
        }
    }

    @Override // com.baidu.tieba.sa1
    public void onHideLoading() {
        sa1 sa1Var = this.b;
        if (sa1Var != null) {
            sa1Var.onHideLoading();
        }
    }

    @Override // com.baidu.tieba.sa1
    public void onLoadFailure() {
        Message obtain = Message.obtain(this.c, 2, -6, 0);
        fb1.a(this.a, "load fail");
        this.c.sendMessage(obtain);
        sa1 sa1Var = this.b;
        if (sa1Var != null) {
            sa1Var.onLoadFailure();
        }
    }

    @Override // com.baidu.tieba.sa1
    public void onLoadSuccess() {
        fb1.a(this.a, "load success");
        this.c.sendEmptyMessage(1);
        sa1 sa1Var = this.b;
        if (sa1Var != null) {
            sa1Var.onLoadSuccess();
        }
    }

    public final void q() {
        if (!(getContext() instanceof Activity)) {
            fb1.d(new RuntimeException("Context must be instanceOf Activity"));
        }
        r();
        p();
        J();
    }

    public void r() {
        setWebViewDownloadListener();
        o();
        m();
        b();
    }

    public void setWebViewClients() {
        fb1.a(this.a, "setWebViewClients");
    }

    public final boolean u() {
        return this.l;
    }

    public final boolean y() {
        return !t();
    }

    public final void p() {
        View view2;
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
            view2.setOnClickListener(new b());
            NadBrowserStateView nadBrowserStateView3 = this.e;
            if (nadBrowserStateView3 != null) {
                nadBrowserStateView3.setErrorViewClickListener(null);
            }
        }
        addView(this.e, new FrameLayout.LayoutParams(-1, -1));
    }
}
