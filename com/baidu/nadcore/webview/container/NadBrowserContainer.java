package com.baidu.nadcore.webview.container;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.http.Headers;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.webarch.NadLongPressView;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.a61;
import com.baidu.tieba.a71;
import com.baidu.tieba.b71;
import com.baidu.tieba.c51;
import com.baidu.tieba.d21;
import com.baidu.tieba.g61;
import com.baidu.tieba.h61;
import com.baidu.tieba.i51;
import com.baidu.tieba.ij0;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.j51;
import com.baidu.tieba.j61;
import com.baidu.tieba.k51;
import com.baidu.tieba.l51;
import com.baidu.tieba.m51;
import com.baidu.tieba.m61;
import com.baidu.tieba.o51;
import com.baidu.tieba.o61;
import com.baidu.tieba.p51;
import com.baidu.tieba.p61;
import com.baidu.tieba.py0;
import com.baidu.tieba.q51;
import com.baidu.tieba.r51;
import com.baidu.tieba.s21;
import com.baidu.tieba.s51;
import com.baidu.tieba.s81;
import com.baidu.tieba.ti0;
import com.baidu.tieba.u31;
import com.baidu.tieba.v21;
import com.baidu.tieba.v51;
import com.baidu.tieba.w11;
import com.baidu.tieba.w31;
import com.baidu.tieba.w61;
import com.baidu.tieba.x61;
import com.baidu.tieba.xi0;
import com.baidu.tieba.y31;
import com.baidu.tieba.y51;
import com.baidu.tieba.y61;
import com.baidu.tieba.z51;
import com.baidu.tieba.z61;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0006£\u0002¤\u0002¥\u0002B)\u0012\b\u0010ñ\u0001\u001a\u00030ð\u0001\u0012\b\u0010ô\u0001\u001a\u00030ó\u0001\u0012\n\u0010÷\u0001\u001a\u0005\u0018\u00010ö\u0001¢\u0006\u0006\b¡\u0002\u0010¢\u0002J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\b\u0018\u00010\u0017R\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010\u0013J\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\tJ\u0011\u0010$\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b$\u0010\u0016J\r\u0010%\u001a\u00020\u0007¢\u0006\u0004\b%\u0010\tJ\u000f\u0010&\u001a\u00020\u0007H\u0014¢\u0006\u0004\b&\u0010\tJ\r\u0010(\u001a\u00020'¢\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.J\u0011\u0010/\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b/\u0010+J\u0011\u00100\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b0\u0010+J\r\u00102\u001a\u000201¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0011H\u0002¢\u0006\u0004\b4\u0010\u0013J\u0011\u00105\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b5\u0010+J\u0019\u00108\u001a\u0004\u0018\u00010\r2\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020,¢\u0006\u0004\b:\u0010.J\r\u0010<\u001a\u00020;¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0007H\u0002¢\u0006\u0004\b>\u0010\tJ\u000f\u0010?\u001a\u00020\u0007H\u0002¢\u0006\u0004\b?\u0010\tJ\u000f\u0010@\u001a\u00020\u0014H\u0014¢\u0006\u0004\b@\u0010\u0016J\u000f\u0010A\u001a\u00020\u0007H\u0002¢\u0006\u0004\bA\u0010\tJ\u000f\u0010B\u001a\u00020\u0007H\u0002¢\u0006\u0004\bB\u0010\tJ\u0017\u0010C\u001a\u00020\u00072\u0006\u00107\u001a\u000206H\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0007H\u0002¢\u0006\u0004\bG\u0010\tJ\u000f\u0010H\u001a\u00020\u0007H\u0002¢\u0006\u0004\bH\u0010\tJ\u0017\u0010I\u001a\u00020\u00072\u0006\u00107\u001a\u000206H\u0003¢\u0006\u0004\bI\u0010DJ\u000f\u0010J\u001a\u00020\u0007H\u0002¢\u0006\u0004\bJ\u0010\tJ\u000f\u0010K\u001a\u00020\u0007H\u0002¢\u0006\u0004\bK\u0010\tJ\u000f\u0010L\u001a\u00020\u0007H\u0002¢\u0006\u0004\bL\u0010\tJ\u0017\u0010M\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\bM\u0010FJ\u0017\u0010N\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\bN\u0010FJ\u0011\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b7\u0010OJ\u000f\u0010P\u001a\u00020\u0011H\u0016¢\u0006\u0004\bP\u0010\u0013J!\u0010S\u001a\u00020\u00072\u0010\u0010R\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010QH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u0011H\u0016¢\u0006\u0004\bU\u0010\u0013J\r\u0010V\u001a\u00020\u0011¢\u0006\u0004\bV\u0010\u0013J\u000f\u0010W\u001a\u00020\u0007H\u0014¢\u0006\u0004\bW\u0010\tJ)\u0010W\u001a\u00020\u00072\u0018\u0010Y\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010XH\u0004¢\u0006\u0004\bW\u0010ZJ!\u0010]\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\b\u0010\\\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b]\u0010^J+\u0010b\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\b\u0010`\u001a\u0004\u0018\u00010_2\b\u0010a\u001a\u0004\u0018\u00010_H\u0016¢\u0006\u0004\bb\u0010cJ)\u0010f\u001a\u00020\u00072\b\u0010[\u001a\u0004\u0018\u00010\u001b2\u0006\u0010d\u001a\u00020,2\u0006\u0010e\u001a\u00020,H\u0016¢\u0006\u0004\bf\u0010gJ#\u0010i\u001a\u0004\u0018\u00010h2\u0006\u0010[\u001a\u00020\u001b2\b\u0010\\\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bi\u0010jJ!\u0010k\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\b\u0010\\\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bk\u0010^J!\u0010n\u001a\u00020\u00112\u0006\u0010[\u001a\u00020\u001b2\b\u0010m\u001a\u0004\u0018\u00010lH\u0016¢\u0006\u0004\bn\u0010oJ!\u0010p\u001a\u00020\u00112\u0006\u0010[\u001a\u00020\u001b2\b\u0010\\\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bp\u0010qJ\u001f\u0010s\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\u0006\u0010r\u001a\u00020,H\u0016¢\u0006\u0004\bs\u0010tJ!\u0010u\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\b\u0010\\\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bu\u0010^J+\u0010x\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\b\u0010\\\u001a\u0004\u0018\u00010\r2\b\u0010w\u001a\u0004\u0018\u00010vH\u0016¢\u0006\u0004\bx\u0010yJ\u001f\u0010{\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\u0006\u0010z\u001a\u00020,H\u0016¢\u0006\u0004\b{\u0010tJ4\u0010\u007f\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\u0006\u0010|\u001a\u00020,2\b\u0010}\u001a\u0004\u0018\u00010\r2\b\u0010~\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0005\b\u007f\u0010\u0080\u0001J:\u0010\u0085\u0001\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\b\u0010\u0082\u0001\u001a\u00030\u0081\u00012\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J;\u0010\u0089\u0001\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J2\u0010\u008e\u0001\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u008b\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0016¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J$\u0010\u0091\u0001\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0005\b\u0091\u0001\u0010^J\u0019\u0010\u0092\u0001\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001bH\u0016¢\u0006\u0005\b\u0092\u0001\u0010FJ.\u0010\u0096\u0001\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\b\u0010\u0094\u0001\u001a\u00030\u0093\u00012\b\u0010\u0095\u0001\u001a\u00030\u0093\u0001H\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J$\u0010\u0098\u0001\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\b\u0010m\u001a\u0004\u0018\u00010lH\u0016¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J-\u0010\u009b\u0001\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\b\u0010\\\u001a\u0004\u0018\u00010\r2\u0007\u0010\u009a\u0001\u001a\u00020\u0011H\u0016¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J0\u0010\u009f\u0001\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u001b2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u0011\u0010¡\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b¡\u0001\u0010\tJ\u0011\u0010¢\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b¢\u0001\u0010\tJ/\u0010¦\u0001\u001a\u00020\u00072\u0007\u0010£\u0001\u001a\u00020,2\u0007\u0010¤\u0001\u001a\u00020,2\t\u0010¥\u0001\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0011\u0010¨\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b¨\u0001\u0010\tJ\u0011\u0010©\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b©\u0001\u0010\tJ\u0011\u0010ª\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\bª\u0001\u0010\tJ\u001b\u0010¬\u0001\u001a\u00020\u00072\u0007\u0010«\u0001\u001a\u00020,H\u0016¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\u0011\u0010®\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b®\u0001\u0010\tJ\u0011\u0010¯\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b¯\u0001\u0010\tJ\u001b\u0010°\u0001\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0005\b°\u0001\u0010DJ\u0011\u0010±\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b±\u0001\u0010\tJ\u0011\u0010²\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b²\u0001\u0010\u0013J\u0011\u0010³\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b³\u0001\u0010\tJ\u0011\u0010´\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b´\u0001\u0010\tJ\u0011\u0010µ\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\bµ\u0001\u0010\tJ\u0011\u0010¶\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b¶\u0001\u0010\tJ\u001c\u0010¹\u0001\u001a\u00020\u00072\b\u0010¸\u0001\u001a\u00030·\u0001H\u0014¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u0011\u0010»\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b»\u0001\u0010\tJ\u0011\u0010¼\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b¼\u0001\u0010\tJ\u0015\u0010¾\u0001\u001a\u0005\u0018\u00010½\u0001H\u0016¢\u0006\u0006\b¾\u0001\u0010¿\u0001J\u001c\u0010Â\u0001\u001a\u00020\u00072\b\u0010Á\u0001\u001a\u00030À\u0001H\u0016¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u001a\u0010Ä\u0001\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020\rH\u0016¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J\u001d\u0010Æ\u0001\u001a\u00020\u00072\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u0011\u0010È\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\bÈ\u0001\u0010\tJ\u0011\u0010É\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\bÉ\u0001\u0010\tR\u0019\u0010Ê\u0001\u001a\u00020\r8\u0002@\u0002X\u0082D¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R(\u0010Ì\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0005\bÎ\u0001\u0010\u0013\"\u0006\bÏ\u0001\u0010Ð\u0001R(\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0015\u0010Ñ\u0001\u001a\u0005\bÒ\u0001\u0010\u0016\"\u0006\bÓ\u0001\u0010Ô\u0001R\u001d\u0010\u0019\u001a\b\u0018\u00010\u0017R\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0019\u0010Õ\u0001R'\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u001c\u0010Ö\u0001\u001a\u0005\b×\u0001\u0010\u001d\"\u0005\bØ\u0001\u0010FR(\u0010Ù\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÙ\u0001\u0010Í\u0001\u001a\u0005\bÚ\u0001\u0010\u0013\"\u0006\bÛ\u0001\u0010Ð\u0001R,\u0010Ý\u0001\u001a\u0005\u0018\u00010Ü\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÝ\u0001\u0010Þ\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R(\u0010ã\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bã\u0001\u0010Í\u0001\u001a\u0005\bä\u0001\u0010\u0013\"\u0006\bå\u0001\u0010Ð\u0001R\u001a\u0010ç\u0001\u001a\u00030æ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R(\u0010$\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b$\u0010Ñ\u0001\u001a\u0005\bé\u0001\u0010\u0016\"\u0006\bê\u0001\u0010Ô\u0001R,\u0010ë\u0001\u001a\u0005\u0018\u00010À\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bë\u0001\u0010ì\u0001\u001a\u0006\bí\u0001\u0010î\u0001\"\u0006\bï\u0001\u0010Ã\u0001R\u001a\u0010ñ\u0001\u001a\u00030ð\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bñ\u0001\u0010ò\u0001R\u001a\u0010ô\u0001\u001a\u00030ó\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bô\u0001\u0010õ\u0001R\u001c\u0010÷\u0001\u001a\u0005\u0018\u00010ö\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b÷\u0001\u0010ø\u0001R\u0019\u0010ù\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R(\u0010û\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bû\u0001\u0010Í\u0001\u001a\u0005\bû\u0001\u0010\u0013\"\u0006\bü\u0001\u0010Ð\u0001R(\u0010ý\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bý\u0001\u0010Í\u0001\u001a\u0005\bý\u0001\u0010\u0013\"\u0006\bþ\u0001\u0010Ð\u0001R(\u0010ÿ\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÿ\u0001\u0010Í\u0001\u001a\u0005\b\u0080\u0002\u0010\u0013\"\u0006\b\u0081\u0002\u0010Ð\u0001R,\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0082\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0083\u0002\u0010\u0084\u0002\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002\"\u0006\b\u0087\u0002\u0010\u0088\u0002R\u001f\u0010\u008a\u0002\u001a\u00030\u0089\u00028\u0006@\u0006¢\u0006\u0010\n\u0006\b\u008a\u0002\u0010\u008b\u0002\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002R,\u0010¾\u0001\u001a\u0005\u0018\u00010½\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¾\u0001\u0010\u008e\u0002\u001a\u0006\b\u008f\u0002\u0010¿\u0001\"\u0006\b\u0090\u0002\u0010\u0091\u0002R(\u0010\u0092\u0002\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0092\u0002\u0010Í\u0001\u001a\u0005\b\u0093\u0002\u0010\u0013\"\u0006\b\u0094\u0002\u0010Ð\u0001R#\u0010\u0096\u0002\u001a\f\u0012\u0005\u0012\u00030À\u0001\u0018\u00010\u0095\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u0097\u0002R\u0019\u0010\\\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\\\u0010Ë\u0001R\u001e\u0010\u0099\u0002\u001a\u00070\u0098\u0002R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0002\u0010\u009a\u0002R\u001e\u0010\u009c\u0002\u001a\u00070\u009b\u0002R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0002\u0010\u009d\u0002R\u001e\u0010\u009f\u0002\u001a\u00070\u009e\u0002R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0002\u0010 \u0002¨\u0006¦\u0002"}, d2 = {"Lcom/baidu/nadcore/webview/container/NadBrowserContainer;", "Lcom/baidu/tieba/l51;", "Lcom/baidu/tieba/w61;", "Lcom/baidu/nadcore/webview/container/AbsBrowserContainer;", "Landroid/app/Activity;", "activity", "()Landroid/app/Activity;", "", "addBrowserLayout", "()V", "addJavaScriptInterface", "", "obj", "", "name", "addJavaScriptScriptInterface", "(Ljava/lang/Object;Ljava/lang/String;)V", "", "applyKeyboardConfig", "()Z", "Landroid/widget/LinearLayout;", "browserLayout", "()Landroid/widget/LinearLayout;", "Lcom/baidu/nadcore/webview/data/NadBrowserModelHelper$NadBrowserModel;", "Lcom/baidu/nadcore/webview/data/NadBrowserModelHelper;", "browserModel", "()Lcom/baidu/nadcore/webview/data/NadBrowserModelHelper$NadBrowserModel;", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;", "browserView", "()Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;", "Landroid/view/MotionEvent;", "e", "canSlide", "(Landroid/view/MotionEvent;)Z", "checkNeedAppendPublicParamFromIntent", "closeFrame", "containerLayout", "forbidKeyboardAdjust", "forceHideSoftInput", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "getLpRealUrlFromIntent", "()Ljava/lang/String;", "", "getNairobiKernelType", "()I", "getPageTitle", "getRefererUrlFromIntent", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "getTransparentBarSwitch", "getUrl", "Landroid/content/Intent;", "intent", "getUrlFromIntent", "(Landroid/content/Intent;)Ljava/lang/String;", "getWebViewScrollY", "Landroid/view/Window;", "getWindow", "()Landroid/view/Window;", "hideNavigationBarView", "hideTransparentNavigationBar", "initBrowserLayout", "initBrowserView", "initBusiness", "initFullScreen", "(Landroid/content/Intent;)V", "initJsAbility", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;)V", "initNavigationBar", "initNormalNavigationBar", "initOrientation", "initTransparentNavigationBar", "initUIWithIntent", "initUIWithoutIntent", "initWebSettings", "initWebSettingsWithIntent", "()Landroid/content/Intent;", "isCloseBtnClicked", "Lcom/baidu/nadcore/webview/interfaces/INadBrowserCommonCallback;", WebChromeClient.KEY_ARG_CALLBACK, "isFavorExistByUrl", "(Lcom/baidu/nadcore/webview/interfaces/INadBrowserCommonCallback;)V", "isKernelDowngrade", "isValidWebView", "loadUrl", "", "params", "(Ljava/util/Map;)V", "webView", "url", "notifyFirstScreenPaintFinishedExt", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;)V", "Landroid/os/Message;", "dontResend", "resend", "notifyFormResubmission", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/os/Message;Landroid/os/Message;)V", "scrollOffsetY", "scrollExtentY", "notifyGestureScrollEnded", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;II)V", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebResourceResponseWrapper;", "notifyInterceptRequest", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;)Lcom/baidu/nadcore/webview/webviewclient/AbsWebResourceResponseWrapper;", "notifyLoadResource", "Landroid/view/KeyEvent;", "event", "notifyOverrideKeyEvent", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/view/KeyEvent;)Z", "notifyOverrideUrlLoading", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;)Z", "step", "notifyPageBackOrForwardExt", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;I)V", "notifyPageFinished", "Landroid/graphics/Bitmap;", "favicon", "notifyPageStarted", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "newProgress", "notifyProgressChanged", CloudStabilityUBCUtils.KEY_ERROR_CODE, "description", "failingUrl", "notifyReceivedError", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;ILjava/lang/String;Ljava/lang/String;)V", "Lcom/baidu/nadcore/webview/webviewclient/AbsHttpAuthHandlerWrapper;", "handler", "host", "realm", "notifyReceivedHttpAuthRequest", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Lcom/baidu/nadcore/webview/webviewclient/AbsHttpAuthHandlerWrapper;Ljava/lang/String;Ljava/lang/String;)V", "account", WebChromeClient.KEY_ARG_ARRAY, "notifyReceivedLoginRequest", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "error", "notifyReceivedSslError", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", "title", "notifyReceivedTitle", "notifyRequestFocus", "", "oldScale", "newScale", "notifyScaleChanged", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;FF)V", "notifyUnhandledKeyEvent", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/view/KeyEvent;)V", "isReload", "notifyUpdateVisitedHistory", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Z)V", "originalUrl", "redirectedUrl", "notifyUrlRedirectedExt", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Ljava/lang/String;)V", "notifyWebViewInitFinished", "notifyWebViewRelease", AiBotChatDispatcher.AI_SINGLE_REQUEST_CODE, "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onCreate", MissionEvent.MESSAGE_DESTROY, "onHideLoading", "itemType", "onLightBrowserViewMenuClickType", "(I)V", "onLoadFailure", "onLoadSuccess", "onNewIntent", MissionEvent.MESSAGE_PAUSE, "onPreLoadUrl", "onResume", "pageBack", "parseBrowserModel", Headers.REFRESH, "Lcom/baidu/nadcore/webview/business/IContainerUrlLoadAction;", "action", "registerAction", "(Lcom/baidu/nadcore/webview/business/IContainerUrlLoadAction;)V", "registerBusinessPlugins", "registerH5CallBack", "Landroid/widget/FrameLayout;", "rootView", "()Landroid/widget/FrameLayout;", "Landroid/view/View;", "view", "setContentView", "(Landroid/view/View;)V", "shouldOverrideUrlLoading", "(Ljava/lang/String;)Z", "updateTitle", "(Ljava/lang/String;)V", "urlShare", "webViewGoBack", "TAG", "Ljava/lang/String;", "applyKeyboardAdjust", "Z", "getApplyKeyboardAdjust", "setApplyKeyboardAdjust", "(Z)V", "Landroid/widget/LinearLayout;", "getBrowserLayout", "setBrowserLayout", "(Landroid/widget/LinearLayout;)V", "Lcom/baidu/nadcore/webview/data/NadBrowserModelHelper$NadBrowserModel;", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;", "getBrowserView", "setBrowserView", "clickedCloseBtn", "getClickedCloseBtn", "setClickedCloseBtn", "Landroid/widget/ImageView;", "closeBtn", "Landroid/widget/ImageView;", "getCloseBtn", "()Landroid/widget/ImageView;", "setCloseBtn", "(Landroid/widget/ImageView;)V", "configStatusBar", "getConfigStatusBar", "setConfigStatusBar", "Lcom/baidu/nadcore/webview/prerender/ConsumeData;", "consumeData", "Lcom/baidu/nadcore/webview/prerender/ConsumeData;", "getContainerLayout", "setContainerLayout", "contentLayout", "Landroid/view/View;", "getContentLayout", "()Landroid/view/View;", "setContentLayout", "Lcom/baidu/nadcore/webview/interfaces/IFrameContext;", "frameContext", "Lcom/baidu/nadcore/webview/interfaces/IFrameContext;", "Lcom/baidu/nadcore/webview/interfaces/IFrameExtHandler;", "frameExtHandler", "Lcom/baidu/nadcore/webview/interfaces/IFrameExtHandler;", "Lcom/baidu/nadcore/webview/webevent/IWebEventNotifier;", "frameWebEventNotifier", "Lcom/baidu/nadcore/webview/webevent/IWebEventNotifier;", "h5CallBackEventObject", "Ljava/lang/Object;", "isInjectGoBack", "setInjectGoBack", "isVideoPage", "setVideoPage", "kernelDowngrade", "getKernelDowngrade", "setKernelDowngrade", "Lcom/baidu/nadcore/webview/util/BdPageDialogsHandler;", "pageDialogsHandler", "Lcom/baidu/nadcore/webview/util/BdPageDialogsHandler;", "getPageDialogsHandler", "()Lcom/baidu/nadcore/webview/util/BdPageDialogsHandler;", "setPageDialogsHandler", "(Lcom/baidu/nadcore/webview/util/BdPageDialogsHandler;)V", "Lcom/baidu/nadcore/webview/business/PluginManager;", "pluginManager", "Lcom/baidu/nadcore/webview/business/PluginManager;", "getPluginManager", "()Lcom/baidu/nadcore/webview/business/PluginManager;", "Landroid/widget/FrameLayout;", "getRootView", "setRootView", "(Landroid/widget/FrameLayout;)V", "showNavigationBar", "getShowNavigationBar", "setShowNavigationBar", "Lcom/baidu/nadcore/widget/optimize/NadViewOptStubWrapper;", "transparentTitleBarStubWrapper", "Lcom/baidu/nadcore/widget/optimize/NadViewOptStubWrapper;", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebChromeClientProxy;", "webChromeClientProxy", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebChromeClientProxy;", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebViewClientExtProxy;", "webViewClientExtProxy", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebViewClientExtProxy;", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebViewClientProxy;", "webViewClientProxy", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebViewClientProxy;", "<init>", "(Lcom/baidu/nadcore/webview/interfaces/IFrameContext;Lcom/baidu/nadcore/webview/interfaces/IFrameExtHandler;Lcom/baidu/nadcore/webview/webevent/IWebEventNotifier;)V", "WebChromeClientProxy", "WebViewClientExtProxy", "WebViewClientProxy", "lib-webview_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public class NadBrowserContainer extends AbsBrowserContainer implements l51, w61 {
    public final a61 A;
    public final w61 B;
    public final String c;
    public View d;
    public FrameLayout e;
    public LinearLayout f;
    public LinearLayout g;
    public AbsNadBrowserView h;
    public s81<View> i;
    public ImageView j;
    public final c k;
    public final b l;
    public final a m;
    public boolean n;
    public boolean o;
    public String p;
    public v51.d q;
    public o61 r;
    public final r51 s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public final m61 x;
    public final Object y;
    public final z51 z;

    public void k0(AbsNadBrowserView browserView) {
        Intrinsics.checkNotNullParameter(browserView, "browserView");
    }

    /* loaded from: classes3.dex */
    public final class c extends b71 {

        /* loaded from: classes3.dex */
        public static final class a implements g61 {
            public final /* synthetic */ AbsNadBrowserView b;
            public final /* synthetic */ SslErrorHandler c;
            public final /* synthetic */ SslError d;

            public a(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError) {
                this.b = absNadBrowserView;
                this.c = sslErrorHandler;
                this.d = sslError;
            }

            @Override // com.baidu.tieba.g61
            public final void cancel() {
                NadBrowserContainer.this.k.j(this.b, this.c, this.d);
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.baidu.tieba.b71
        public void a(AbsNadBrowserView webView, Message message, Message message2) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.f0(webView, message, message2);
        }

        @Override // com.baidu.tieba.b71
        public void j(AbsNadBrowserView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            if (webView.z()) {
                a aVar = new a(webView, sslErrorHandler, sslError);
                o61 T2 = NadBrowserContainer.this.T();
                if (T2 != null) {
                    T2.t(aVar, sslErrorHandler, sslError);
                }
            }
            NadBrowserContainer.this.s0(webView, sslErrorHandler, sslError);
        }

        @Override // com.baidu.tieba.b71
        public void k(AbsNadBrowserView webView, float f, float f2) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.x(webView, f, f2);
        }

        @Override // com.baidu.tieba.b71
        public void m(AbsNadBrowserView webView, String str, boolean z) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.p0(webView, str, z);
        }

        @Override // com.baidu.tieba.b71
        public z61 b(AbsNadBrowserView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            return NadBrowserContainer.this.X(webView, str);
        }

        @Override // com.baidu.tieba.b71
        public void c(AbsNadBrowserView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.f(webView, str);
        }

        @Override // com.baidu.tieba.b71
        public boolean d(AbsNadBrowserView webView, KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            return NadBrowserContainer.this.F(webView, keyEvent);
        }

        @Override // com.baidu.tieba.b71
        public boolean e(AbsNadBrowserView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            return NadBrowserContainer.this.G0(webView, str);
        }

        @Override // com.baidu.tieba.b71
        public void l(AbsNadBrowserView webView, KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.C0(webView, keyEvent);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
            if (kotlin.text.StringsKt__StringsKt.contains((java.lang.CharSequence) r6, (java.lang.CharSequence) r2, false) == true) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.b71
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void f(AbsNadBrowserView webView, String str) {
            int i;
            Intrinsics.checkNotNullParameter(webView, "webView");
            p61.c(NadBrowserContainer.this.p(), "PAGE FINISHED");
            p61.a(NadBrowserContainer.this.c, "page finished");
            Object tag = webView.getTag(R.id.nad_webcontent_error_code);
            if (!(tag instanceof Integer)) {
                tag = null;
            }
            Integer num = (Integer) tag;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            String url = webView.getUrl();
            if (!Intrinsics.areEqual(str, url)) {
                if (str != null) {
                    if (url == null) {
                        url = "";
                    }
                }
                webView.onHideLoading();
                NadBrowserContainer.this.F0(webView.getTitle());
                NadBrowserContainer.this.r(webView, str);
                if (!webView.v()) {
                    webView.G(webView);
                    return;
                }
                return;
            }
            if (i == 0) {
                webView.onLoadSuccess();
            } else {
                webView.onLoadFailure();
            }
            webView.onHideLoading();
            NadBrowserContainer.this.F0(webView.getTitle());
            NadBrowserContainer.this.r(webView, str);
            if (!webView.v()) {
            }
        }

        @Override // com.baidu.tieba.b71
        public void g(AbsNadBrowserView webView, String str, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            p61.c(NadBrowserContainer.this.p(), "PAGE STARTED");
            p61.a(NadBrowserContainer.this.c, "page started");
            if (webView.u()) {
                webView.setTag(R.id.nad_webcontent_error_code, 0);
            }
            webView.setFirstPage(false);
            webView.V();
            if (webView.c()) {
                ImageView Q = NadBrowserContainer.this.Q();
                if (Q != null) {
                    Q.setVisibility(0);
                }
            } else {
                ImageView Q2 = NadBrowserContainer.this.Q();
                if (Q2 != null) {
                    Q2.setVisibility(4);
                }
            }
            NadBrowserContainer.this.N0(webView, str, bitmap);
        }

        @Override // com.baidu.tieba.b71
        public void h(AbsNadBrowserView webView, int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            webView.setTag(R.id.nad_webcontent_error_code, Integer.valueOf(i));
            NadBrowserContainer.this.e(webView, i, str, str2);
        }

        @Override // com.baidu.tieba.b71
        public void i(AbsNadBrowserView webView, x61 handler, String str, String str2) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(handler, "handler");
            NadBrowserContainer.this.O0(webView, handler, str, str2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements p51.a {
        public d() {
        }

        /* loaded from: classes3.dex */
        public static final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AbsNadBrowserView P = NadBrowserContainer.this.P();
                if (P != null && P.c()) {
                    NadBrowserContainer.this.i();
                    return;
                }
                y51 q = NadBrowserContainer.this.q();
                if (q != null) {
                    q.p();
                }
            }
        }

        @Override // com.baidu.tieba.p51.a
        public final void a() {
            AbsNadBrowserView P = NadBrowserContainer.this.P();
            if (P != null) {
                P.post(new a());
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class a extends y61 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.y61
        public void c(AbsNadBrowserView webView) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.g(webView);
        }

        @Override // com.baidu.tieba.y61
        public void a(AbsNadBrowserView webView, int i) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.g1(webView, i);
            webView.P(i);
        }

        @Override // com.baidu.tieba.y61
        public void b(AbsNadBrowserView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.F0(str);
            NadBrowserContainer.this.J(webView, str);
        }
    }

    /* loaded from: classes3.dex */
    public final class b extends a71 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements NadLongPressView.b {
        public final /* synthetic */ NadLongPressView a;
        public final /* synthetic */ NadBrowserContainer b;

        public e(NadLongPressView nadLongPressView, NadBrowserContainer nadBrowserContainer, int i) {
            this.a = nadLongPressView;
            this.b = nadBrowserContainer;
        }

        @Override // com.baidu.nadcore.webarch.NadLongPressView.b
        public final void a() {
            String str;
            v21 clipboardManager = v21.a(this.a.getContext());
            AbsNadBrowserView P = this.b.P();
            if (P != null && P.w()) {
                str = BdSailorPlatform.SAILOR_MODULE_NAME;
            } else {
                str = "native";
            }
            Intrinsics.checkNotNullExpressionValue(clipboardManager, "clipboardManager");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("kernel", str);
            jSONObject.put("model", this.b.q);
            Unit unit = Unit.INSTANCE;
            clipboardManager.b(jSONObject.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements Runnable {
        public final /* synthetic */ AbsNadBrowserView a;

        public f(AbsNadBrowserView absNadBrowserView) {
            this.a = absNadBrowserView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.a.K();
            } catch (Exception unused) {
                p61.b("NadBrowserContainer", "releaseWebView - exception");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends xi0<u31> {
        public g(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi0
        public void onEvent(u31 event) {
            AbsNadBrowserView P;
            Intrinsics.checkNotNullParameter(event, "event");
            if (!TextUtils.isEmpty(event.a) && (P = NadBrowserContainer.this.P()) != null) {
                AbsNadBrowserView.C(P, event.a, null, 2, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadBrowserContainer(z51 frameContext, a61 frameExtHandler, w61 w61Var) {
        super(frameContext);
        Intrinsics.checkNotNullParameter(frameContext, "frameContext");
        Intrinsics.checkNotNullParameter(frameExtHandler, "frameExtHandler");
        this.z = frameContext;
        this.A = frameExtHandler;
        this.B = w61Var;
        this.c = "NadBrowserContainer";
        this.k = new c();
        this.l = new b();
        this.m = new a();
        this.n = true;
        this.o = true;
        this.s = new r51(this);
        this.x = new m61();
        this.y = new Object();
        this.x.a(System.currentTimeMillis());
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer
    public void C(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.C(view2);
        this.d = view2;
        this.e = (FrameLayout) view2.findViewById(R.id.container_rootview);
        this.f = (LinearLayout) view2.findViewById(R.id.container_layout);
        this.i = new s81<>(view2, R.id.obfuscated_res_0x7f090807, R.id.obfuscated_res_0x7f0927ab);
    }

    public final void D0(boolean z) {
        this.o = z;
    }

    public final void E0(boolean z) {
        this.n = z;
    }

    public final void F0(String str) {
        if (this.e == null) {
            p61.d(new RuntimeException("rootView 为空！"));
        } else if (!this.A.g0()) {
        } else {
            FrameLayout frameLayout = this.e;
            Intrinsics.checkNotNull(frameLayout);
            TextView textView = (TextView) frameLayout.findViewById(R.id.tv_title);
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public final boolean L(MotionEvent motionEvent) {
        AbsNadBrowserView absNadBrowserView;
        if (!v0() || (absNadBrowserView = this.h) == null) {
            return false;
        }
        return absNadBrowserView.d(motionEvent);
    }

    @Override // com.baidu.tieba.l51
    public boolean a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return this.s.g(url);
    }

    public final String a0(Intent intent) {
        String str;
        v51.d dVar = this.q;
        if (dVar != null) {
            str = dVar.m();
        } else {
            str = null;
        }
        String e2 = s21.e(str);
        M();
        if (TextUtils.isEmpty(e2) || !s21.h(s21.c(e2))) {
            return "";
        }
        return e2;
    }

    @Override // com.baidu.tieba.w61
    public void g(AbsNadBrowserView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.g(webView);
        }
    }

    public void n(m51 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.s.n(action);
    }

    public final void t0(AbsNadBrowserView absNadBrowserView) {
        p61.a(this.c, "initWebSettings");
        absNadBrowserView.setWebViewClientProxies(this.k, this.l, this.m);
        absNadBrowserView.setStateChangeCallback(this);
        k0(absNadBrowserView);
    }

    public final void u0(AbsNadBrowserView absNadBrowserView) {
        absNadBrowserView.setStateViewVisibility(!Intrinsics.areEqual(YYOption.IsLive.VALUE_TRUE, s().getStringExtra("hide_state_view")));
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer
    public void w(Intent intent) {
        super.w(intent);
        p61.a(this.c, "onNewIntent");
        p().setIntent(intent);
        z0();
        this.p = a0(s());
        q0();
        this.s.k(intent);
    }

    @Override // com.baidu.tieba.w61
    public void C0(AbsNadBrowserView webView, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.C0(webView, keyEvent);
        }
    }

    @Override // com.baidu.tieba.w61
    public boolean F(AbsNadBrowserView webView, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        w61 w61Var = this.B;
        if (w61Var != null) {
            return w61Var.F(webView, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.tieba.w61
    public boolean G0(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (this.s.b(webView, str)) {
            return true;
        }
        w61 w61Var = this.B;
        if (w61Var != null) {
            return w61Var.G0(webView, str);
        }
        return false;
    }

    @Override // com.baidu.tieba.w61
    public void J(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.s.f(webView, str);
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.J(webView, str);
        }
    }

    @Override // com.baidu.tieba.w61
    public z61 X(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        w61 w61Var = this.B;
        if (w61Var != null) {
            return w61Var.X(webView, str);
        }
        return null;
    }

    @Override // com.baidu.tieba.w61
    public void f(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.f(webView, str);
        }
    }

    @Override // com.baidu.tieba.w61
    public void g1(AbsNadBrowserView webView, int i) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.g1(webView, i);
        }
    }

    @Override // com.baidu.tieba.w61
    public void r(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        p61.a(this.c, "onPageFinished");
        this.s.c(webView, str);
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.r(webView, str);
        }
        if (!this.w) {
            AbsNadBrowserView absNadBrowserView = this.h;
            if (absNadBrowserView != null) {
                AbsNadBrowserView.E(absNadBrowserView, "javascript:(function go_back_js_interface_name(){window.history.back=function(){javascript:(function(){if(typeof(window.go_back_js_interface_name)=='undefined'){window.prompt('BdboxApp:'+JSON.stringify({obj:'go_back_js_interface_name',func:'onGoBack',args:[]}));}else{window.go_back_js_interface_name.onGoBack();}})()};})()", null, false, 6, null);
            }
            this.w = true;
        }
    }

    public final void A0() {
        this.s.o(new j51(this));
        this.s.o(new q51(this));
        this.s.o(new k51(this));
        this.s.o(new i51(this));
        this.s.o(new o51(this));
        this.s.o(new s51(this));
    }

    public final void I() {
        ViewParent viewParent;
        LinearLayout linearLayout = this.g;
        ViewParent viewParent2 = null;
        if (linearLayout != null) {
            viewParent = linearLayout.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            LinearLayout linearLayout2 = this.g;
            if (linearLayout2 != null) {
                viewParent2 = linearLayout2.getParent();
            }
            if (viewParent2 != null) {
                ((ViewGroup) viewParent2).removeView(this.g);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout3 = this.f;
        if (linearLayout3 != null) {
            linearLayout3.addView(this.g, layoutParams);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r0 == false) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Z() {
        boolean z;
        v51.d dVar;
        boolean z2;
        boolean z3;
        int a2 = ij0.b().a().a("ad_transparent_bar_switch", 0);
        if (a2 != 0) {
            if (a2 != 1) {
                if (a2 == 2) {
                    v51.d dVar2 = this.q;
                    if (dVar2 != null) {
                        z3 = dVar2.o();
                    } else {
                        z3 = false;
                    }
                }
            }
            z = true;
            dVar = this.q;
            if (dVar == null) {
                z2 = dVar.l();
            } else {
                z2 = true;
            }
            if (!z && z2) {
                return true;
            }
        }
        z = false;
        dVar = this.q;
        if (dVar == null) {
        }
        return !z ? false : false;
    }

    public final void h0() {
        y31 e2;
        if (this.g != null) {
            return;
        }
        this.g = g0();
        if (!v0()) {
            return;
        }
        AbsNadBrowserView absNadBrowserView = this.h;
        Intrinsics.checkNotNull(absNadBrowserView);
        t0(absNadBrowserView);
        if (this.o && (e2 = h61.e()) != null) {
            e2.a(p());
        }
        if (this.r != null) {
            this.r = new o61(this.z.getActivity());
        }
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer
    public void v() {
        p61.c(p(), "启动内罗毕框架");
        p61.a(this.c, "onCreate");
        super.v();
        View view2 = View.inflate(this.z.getActivity(), R.layout.nad_browser_activity, null);
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        C(view2);
        r0();
        i0();
        this.p = a0(s());
        q0();
        this.s.i();
    }

    public final void B0() {
        ti0.a().d(this.y, 1, new g(u31.class));
    }

    public void H0() {
        AbsNadBrowserView absNadBrowserView;
        N();
        if (v0() && (absNadBrowserView = this.h) != null && absNadBrowserView.j()) {
            return;
        }
        this.z.n();
    }

    public final void K() {
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            absNadBrowserView.a(new p51(new d()), "go_back_js_interface_name");
        }
    }

    public final boolean M() {
        boolean z;
        v51.a c2;
        v51.d dVar = this.q;
        if (dVar != null && (c2 = dVar.c()) != null) {
            z = c2.b();
        } else {
            z = false;
        }
        if (!z && !this.A.Y0()) {
            return false;
        }
        return true;
    }

    public void N() {
        Context O = O();
        Window window = p().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getActivity().window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getActivity().window.decorView");
        d21.a(O, decorView.getWindowToken());
    }

    public final Context O() {
        return h61.a();
    }

    public final AbsNadBrowserView P() {
        return this.h;
    }

    public final ImageView Q() {
        return this.j;
    }

    public final String R() {
        Bundle extras = s().getExtras();
        if (extras != null) {
            Intrinsics.checkNotNullExpressionValue(extras, "getIntent().extras ?: return null");
            Serializable serializable = extras.getSerializable("map");
            if (!(serializable instanceof HashMap)) {
                serializable = null;
            }
            HashMap hashMap = (HashMap) serializable;
            if (hashMap != null && hashMap != null && !hashMap.isEmpty()) {
                return (String) py0.b(hashMap, "lp_real_url");
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.w61
    public void S0() {
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.S0();
        }
    }

    public final o61 T() {
        return this.r;
    }

    @Override // com.baidu.tieba.w61
    public void U() {
        this.s.h();
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.U();
        }
    }

    public final String V() {
        Bundle extras = s().getExtras();
        if (extras != null) {
            Intrinsics.checkNotNullExpressionValue(extras, "getIntent().extras ?: return null");
            Serializable serializable = extras.getSerializable("map");
            if (!(serializable instanceof HashMap)) {
                serializable = null;
            }
            HashMap hashMap = (HashMap) serializable;
            if (hashMap != null && hashMap != null && !hashMap.isEmpty()) {
                return (String) py0.b(hashMap, "charge_url");
            }
        }
        return null;
    }

    public final Resources W() {
        Resources resources = p().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getActivity().resources");
        return resources;
    }

    public final FrameLayout Y() {
        return this.e;
    }

    @Override // com.baidu.tieba.l51
    public Activity b() {
        return p();
    }

    public final int b0() {
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            return absNadBrowserView.getWebViewScrollY();
        }
        return -1;
    }

    @Override // com.baidu.tieba.l51
    public boolean c() {
        return this.v;
    }

    public final Window c0() {
        Window window = p().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getActivity().window");
        return window;
    }

    @Override // com.baidu.tieba.l51
    public LinearLayout d() {
        return this.f;
    }

    public final void d0() {
        View view2;
        FrameLayout frameLayout = this.e;
        if (frameLayout == null) {
            p61.d(new RuntimeException("rootView 为空！"));
            return;
        }
        if (frameLayout != null) {
            view2 = frameLayout.findViewById(R.id.container_titlebar);
        } else {
            view2 = null;
        }
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public final void e0() {
        s81<View> s81Var;
        View c2;
        s81<View> s81Var2 = this.i;
        if (s81Var2 == null) {
            p61.d(new RuntimeException("transparentTitleBarStubWrapper 为空！"));
        } else if (s81Var2 != null && s81Var2.d() && (s81Var = this.i) != null && (c2 = s81Var.c()) != null) {
            c2.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.l51
    public boolean h() {
        return this.u;
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer, com.baidu.tieba.x31
    public void i() {
        if (v0()) {
            H0();
        }
    }

    public final void i0() {
        z0();
        A0();
    }

    @Override // com.baidu.tieba.l51
    public FrameLayout j() {
        return this.e;
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer, com.baidu.tieba.x31
    public void k() {
        if (!this.v) {
            this.v = true;
        }
        super.k();
    }

    @Override // com.baidu.tieba.l51
    public v51.d l() {
        return this.q;
    }

    public final void l0() {
        if (this.n) {
            if (Z()) {
                d0();
                o0();
                return;
            }
            e0();
            m0();
            return;
        }
        e0();
        d0();
    }

    @Override // com.baidu.tieba.l51
    public AbsNadBrowserView m() {
        return this.h;
    }

    @Override // com.baidu.tieba.c61
    public void onHideLoading() {
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.onHideLoading();
        }
    }

    @Override // com.baidu.tieba.c61
    public void onLoadFailure() {
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.onLoadFailure();
        }
    }

    @Override // com.baidu.tieba.c61
    public void onLoadSuccess() {
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.onLoadSuccess();
        }
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer, com.baidu.tieba.b61
    public void onPause() {
        p61.a(this.c, MissionEvent.MESSAGE_PAUSE);
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            absNadBrowserView.M();
        }
        this.s.l();
        super.onPause();
    }

    public final void q0() {
        Intent s = s();
        l0();
        n0(s);
        j0(s);
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView == null) {
            p61.d(new RuntimeException("browserView 为空！"));
            return;
        }
        Intrinsics.checkNotNull(absNadBrowserView);
        u0(absNadBrowserView);
        U();
        w0();
        K();
    }

    public final void r0() {
        h0();
        AbsNadBrowserView absNadBrowserView = this.h;
        Intrinsics.checkNotNull(absNadBrowserView);
        absNadBrowserView.I();
        I();
        B0();
    }

    public final boolean v0() {
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            return absNadBrowserView.z();
        }
        return false;
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer
    public void y() {
        p61.a(this.c, "onResume");
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            absNadBrowserView.N();
        }
        this.s.m();
        super.y();
    }

    public final boolean y0() {
        if (this.s.a() || this.A.X0()) {
            return true;
        }
        return false;
    }

    public final void z0() {
        v51.d b2 = new v51(s()).b();
        this.q = b2;
        if (b2 != null) {
            b2.q(this.t);
        }
        p61.a(this.c, String.valueOf(this.q));
    }

    @Override // com.baidu.tieba.w61
    public void N0(AbsNadBrowserView webView, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        p61.a(this.c, "onPageStarted");
        this.s.d(webView, str, bitmap);
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.N0(webView, str, bitmap);
        }
    }

    @Override // com.baidu.tieba.w61
    public void f0(AbsNadBrowserView webView, Message message, Message message2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.f0(webView, message, message2);
        }
    }

    @Override // com.baidu.tieba.w61
    public void p0(AbsNadBrowserView webView, String str, boolean z) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.p0(webView, str, z);
        }
    }

    @Override // com.baidu.tieba.w61
    public void s0(AbsNadBrowserView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.s0(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer
    public void t(int i, int i2, Intent intent) {
        super.t(i, i2, intent);
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            absNadBrowserView.H(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.w61
    public void x(AbsNadBrowserView webView, float f2, float f3) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.x(webView, f2, f3);
        }
    }

    @Override // com.baidu.tieba.w61
    public void O0(AbsNadBrowserView webView, x61 handler, String str, String str2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(handler, "handler");
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.O0(webView, handler, str, str2);
        }
    }

    @Override // com.baidu.tieba.w61
    public void e(AbsNadBrowserView webView, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.s.e(webView, i, str, str2);
        w61 w61Var = this.B;
        if (w61Var != null) {
            w61Var.e(webView, i, str, str2);
        }
    }

    public final int S() {
        Serializable serializable;
        j61 d2 = h61.d();
        if (d2 != null && d2.a()) {
            Bundle extras = s().getExtras();
            HashMap hashMap = null;
            if (extras != null) {
                serializable = extras.getSerializable("map");
            } else {
                serializable = null;
            }
            if (serializable instanceof HashMap) {
                hashMap = serializable;
            }
            if (TextUtils.equals((CharSequence) py0.b(hashMap, "downgrade_to_native"), "1")) {
                if (!this.u) {
                    this.u = true;
                }
                return c51.c();
            }
            return ij0.b().a().a("nairobi_kernel_type", c51.b());
        }
        return c51.c();
    }

    public LinearLayout g0() {
        LinearLayout linearLayout = new LinearLayout(p());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        if (this.h == null) {
            this.x.c(R());
            this.x.b(V());
            this.h = c51.a().c(p(), this.x, S());
        }
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            linearLayout.addView(absNadBrowserView, layoutParams);
        } else {
            p61.c(p(), "创建 browserView 失败，退出落地页框架");
            this.z.n();
            p61.d(new IllegalArgumentException("browserView is null, cannot be added to browserLayout"));
        }
        p61.a(this.c, "created new browserView");
        return linearLayout;
    }

    public final void o0() {
        View view2;
        ImageView imageView;
        w31 f2;
        w31 f3;
        s81<View> s81Var = this.i;
        if (s81Var == null) {
            p61.d(new RuntimeException("transparentTitleBarStubWrapper 为空！"));
            return;
        }
        ImageView imageView2 = null;
        if (s81Var != null) {
            view2 = s81Var.c();
        } else {
            view2 = null;
        }
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (view2 != null) {
            imageView = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092b0c);
        } else {
            imageView = null;
        }
        if (view2 != null) {
            imageView2 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092b0d);
        }
        this.j = imageView2;
        if (imageView != null) {
            imageView.setTag(Integer.valueOf((int) R.drawable.nad_web_back));
        }
        ImageView imageView3 = this.j;
        if (imageView3 != null) {
            imageView3.setTag(Integer.valueOf((int) R.drawable.nad_web_close));
        }
        ImageView imageView4 = this.j;
        if (imageView4 != null) {
            imageView4.setVisibility(4);
        }
        if (imageView != null && (f3 = h61.f()) != null) {
            f3.a(imageView, this);
        }
        ImageView imageView5 = this.j;
        if (imageView5 != null && (f2 = h61.f()) != null) {
            f2.a(imageView5, this);
        }
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer, com.baidu.tieba.b61
    public void onDestroy() {
        p61.a(this.c, MissionEvent.MESSAGE_DESTROY);
        S0();
        this.s.j();
        this.s.p();
        ti0.a().a(this.y);
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView == null) {
            return;
        }
        Intrinsics.checkNotNull(absNadBrowserView);
        if (absNadBrowserView.getParent() instanceof ViewGroup) {
            AbsNadBrowserView absNadBrowserView2 = this.h;
            Intrinsics.checkNotNull(absNadBrowserView2);
            ViewParent parent = absNadBrowserView2.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.h);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        AbsNadBrowserView absNadBrowserView3 = this.h;
        Intrinsics.checkNotNull(absNadBrowserView3);
        if (!w11.b.c()) {
            new Handler().postDelayed(new f(absNadBrowserView3), 1500L);
        } else {
            try {
                try {
                    absNadBrowserView3.K();
                } catch (Exception unused) {
                    p61.b("NadBrowserContainer", "releaseWebView - exception");
                }
            } catch (Exception unused2) {
                absNadBrowserView3.K();
            }
        }
        this.h = null;
        p61.c(p(), "销毁 内罗毕框架");
        super.onDestroy();
    }

    public void w0() {
        String str;
        AbsNadBrowserView absNadBrowserView;
        if (y0()) {
            return;
        }
        if (v0() && (absNadBrowserView = this.h) != null) {
            absNadBrowserView.h();
        }
        p61.a(this.c, "start to load url >>> " + this.p);
        if (v0()) {
            v51.d dVar = this.q;
            String str2 = null;
            if (dVar != null) {
                str = dVar.i();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                Pair[] pairArr = new Pair[1];
                v51.d dVar2 = this.q;
                if (dVar2 != null) {
                    str2 = dVar2.i();
                }
                pairArr[0] = new Pair("Referer", str2);
                x0(MapsKt__MapsKt.mutableMapOf(pairArr));
                return;
            }
            AbsNadBrowserView absNadBrowserView2 = this.h;
            if (absNadBrowserView2 != null) {
                AbsNadBrowserView.E(absNadBrowserView2, this.p, null, false, 6, null);
            }
        }
    }

    public final void j0(Intent intent) {
        if (!TextUtils.equals(intent.getStringExtra("layoutfullscreen"), "1")) {
            return;
        }
        TextUtils.equals("1", intent.getStringExtra("statusbar"));
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = c0().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getWindow().decorView");
            c0().getDecorView().setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 8192);
            c0().addFlags(Integer.MIN_VALUE);
            c0().setStatusBarColor(W().getColor(R.color.nad_transparent, null));
        }
    }

    public final void m0() {
        int[] c2;
        ImageView imageView;
        FrameLayout frameLayout = this.e;
        if (frameLayout == null) {
            p61.d(new RuntimeException("rootView 为空！"));
            return;
        }
        Intrinsics.checkNotNull(frameLayout);
        View findViewById = frameLayout.findViewById(R.id.container_titlebar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView!!.findViewById(R.id.container_titlebar)");
        findViewById.setVisibility(0);
        FrameLayout frameLayout2 = this.e;
        Intrinsics.checkNotNull(frameLayout2);
        View findViewById2 = frameLayout2.findViewById(R.id.titlebar_left_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView!!.findViewById(R.id.titlebar_left_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById2;
        FrameLayout frameLayout3 = this.e;
        Intrinsics.checkNotNull(frameLayout3);
        View findViewById3 = frameLayout3.findViewById(R.id.titlebar_right_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView!!.findViewById(…id.titlebar_right_layout)");
        LinearLayout linearLayout2 = (LinearLayout) findViewById3;
        w31 f2 = h61.f();
        Intrinsics.checkNotNull(f2);
        int[] b2 = f2.b();
        int length = b2.length;
        int i = 0;
        while (true) {
            ImageView imageView2 = null;
            if (i >= length) {
                break;
            }
            int i2 = b2[i];
            if (i2 == R.drawable.nad_web_back) {
                imageView = new ImageView(new ContextThemeWrapper(p(), (int) R.style.obfuscated_res_0x7f100144), null, R.style.obfuscated_res_0x7f100144);
            } else if (i2 == R.drawable.nad_web_close) {
                imageView = new ImageView(new ContextThemeWrapper(p(), (int) R.style.obfuscated_res_0x7f100145), null, R.style.obfuscated_res_0x7f100145);
            } else {
                imageView = null;
            }
            if (imageView != null) {
                imageView.setImageResource(i2);
                imageView.setTag(Integer.valueOf(i2));
                imageView2 = imageView;
            }
            w31 f3 = h61.f();
            Intrinsics.checkNotNull(f3);
            f3.a(imageView2, this);
            linearLayout.addView(imageView2);
            if (i2 == R.drawable.nad_web_close) {
                this.j = imageView2;
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
            }
            i++;
        }
        w31 f4 = h61.f();
        Intrinsics.checkNotNull(f4);
        for (int i3 : f4.c()) {
            NadLongPressView nadLongPressView = new NadLongPressView(new ContextThemeWrapper(p(), (int) R.style.obfuscated_res_0x7f100144), null, R.style.obfuscated_res_0x7f100144);
            nadLongPressView.setImageResource(i3);
            nadLongPressView.setTag(Integer.valueOf(i3));
            nadLongPressView.setHandler(new e(nadLongPressView, this, i3));
            w31 f5 = h61.f();
            Intrinsics.checkNotNull(f5);
            f5.a(nadLongPressView, this);
            linearLayout2.addView(nadLongPressView);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void n0(Intent intent) {
        String str;
        v51.a c2;
        v51.d dVar = this.q;
        if (dVar != null && (c2 = dVar.c()) != null) {
            str = c2.a();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (Build.VERSION.SDK_INT == 26 && (p() instanceof BaseActivity)) {
            Activity p = p();
            if (p != null) {
                ((BaseActivity) p).setCurrentActivityNoTransparent();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.nadcore.appframework.BaseActivity");
            }
        }
        if (str != null) {
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0") && p().getRequestedOrientation() != -1) {
                        p().setRequestedOrientation(-1);
                        return;
                    }
                    return;
                case 49:
                    if (str.equals("1") && p().getRequestedOrientation() != 1) {
                        p().setRequestedOrientation(1);
                        return;
                    }
                    return;
                case 50:
                    if (str.equals("2") && p().getRequestedOrientation() != 0) {
                        p().setRequestedOrientation(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void x0(Map<String, String> map) {
        AbsNadBrowserView absNadBrowserView;
        if (y0()) {
            return;
        }
        String str = this.c;
        p61.a(str, "start to load url >>> " + this.p);
        if (v0() && (absNadBrowserView = this.h) != null) {
            AbsNadBrowserView.E(absNadBrowserView, this.p, map, false, 4, null);
        }
    }
}
