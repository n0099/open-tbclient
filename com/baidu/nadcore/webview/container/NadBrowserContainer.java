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
import com.baidu.tieba.ab1;
import com.baidu.tieba.bb1;
import com.baidu.tieba.ca1;
import com.baidu.tieba.da1;
import com.baidu.tieba.db1;
import com.baidu.tieba.ea1;
import com.baidu.tieba.fa1;
import com.baidu.tieba.fn0;
import com.baidu.tieba.ga1;
import com.baidu.tieba.gb1;
import com.baidu.tieba.ia1;
import com.baidu.tieba.ib1;
import com.baidu.tieba.j31;
import com.baidu.tieba.ja1;
import com.baidu.tieba.jb1;
import com.baidu.tieba.jn0;
import com.baidu.tieba.ka1;
import com.baidu.tieba.la1;
import com.baidu.tieba.m71;
import com.baidu.tieba.ma1;
import com.baidu.tieba.o81;
import com.baidu.tieba.p71;
import com.baidu.tieba.pa1;
import com.baidu.tieba.q61;
import com.baidu.tieba.q81;
import com.baidu.tieba.qb1;
import com.baidu.tieba.rb1;
import com.baidu.tieba.s81;
import com.baidu.tieba.sa1;
import com.baidu.tieba.sb1;
import com.baidu.tieba.ta1;
import com.baidu.tieba.tb1;
import com.baidu.tieba.ua1;
import com.baidu.tieba.ub1;
import com.baidu.tieba.un0;
import com.baidu.tieba.vb1;
import com.baidu.tieba.w61;
import com.baidu.tieba.w91;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u009b\u0002\u009c\u0002\u009d\u0002B)\u0012\b\u0010ì\u0001\u001a\u00030ë\u0001\u0012\b\u0010ï\u0001\u001a\u00030î\u0001\u0012\n\u0010ò\u0001\u001a\u0005\u0018\u00010ñ\u0001¢\u0006\u0006\b\u0099\u0002\u0010\u009a\u0002J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\b\u0018\u00010\u0017R\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010\u0013J\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\tJ\u0011\u0010$\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b$\u0010\u0016J\r\u0010%\u001a\u00020\u0007¢\u0006\u0004\b%\u0010\tJ\u000f\u0010&\u001a\u00020\u0007H\u0014¢\u0006\u0004\b&\u0010\tJ\r\u0010(\u001a\u00020'¢\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b-\u0010.J\u0011\u0010/\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b/\u0010+J\u0011\u00100\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b0\u0010+J\r\u00102\u001a\u000201¢\u0006\u0004\b2\u00103J\u0011\u00104\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b4\u0010+J\u0019\u00107\u001a\u0004\u0018\u00010\r2\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020,¢\u0006\u0004\b9\u0010.J\r\u0010;\u001a\u00020:¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0014H\u0014¢\u0006\u0004\b=\u0010\u0016J\u000f\u0010>\u001a\u00020\u0007H\u0002¢\u0006\u0004\b>\u0010\tJ\u000f\u0010?\u001a\u00020\u0007H\u0002¢\u0006\u0004\b?\u0010\tJ\u0017\u0010@\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0007H\u0002¢\u0006\u0004\bD\u0010\tJ\u0017\u0010E\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0003¢\u0006\u0004\bE\u0010AJ\u000f\u0010F\u001a\u00020\u0007H\u0002¢\u0006\u0004\bF\u0010\tJ\u000f\u0010G\u001a\u00020\u0007H\u0002¢\u0006\u0004\bG\u0010\tJ\u0017\u0010H\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\bH\u0010CJ\u0017\u0010I\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\bI\u0010CJ\u0011\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b6\u0010JJ\u000f\u0010K\u001a\u00020\u0011H\u0016¢\u0006\u0004\bK\u0010\u0013J!\u0010N\u001a\u00020\u00072\u0010\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010LH\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0011H\u0016¢\u0006\u0004\bP\u0010\u0013J\r\u0010Q\u001a\u00020\u0011¢\u0006\u0004\bQ\u0010\u0013J\u000f\u0010R\u001a\u00020\u0007H\u0014¢\u0006\u0004\bR\u0010\tJ)\u0010R\u001a\u00020\u00072\u0018\u0010T\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010SH\u0004¢\u0006\u0004\bR\u0010UJ!\u0010X\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\b\u0010W\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bX\u0010YJ+\u0010]\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\b\u0010[\u001a\u0004\u0018\u00010Z2\b\u0010\\\u001a\u0004\u0018\u00010ZH\u0016¢\u0006\u0004\b]\u0010^J)\u0010a\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010\u001b2\u0006\u0010_\u001a\u00020,2\u0006\u0010`\u001a\u00020,H\u0016¢\u0006\u0004\ba\u0010bJ#\u0010d\u001a\u0004\u0018\u00010c2\u0006\u0010V\u001a\u00020\u001b2\b\u0010W\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bd\u0010eJ!\u0010f\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\b\u0010W\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bf\u0010YJ!\u0010i\u001a\u00020\u00112\u0006\u0010V\u001a\u00020\u001b2\b\u0010h\u001a\u0004\u0018\u00010gH\u0016¢\u0006\u0004\bi\u0010jJ!\u0010k\u001a\u00020\u00112\u0006\u0010V\u001a\u00020\u001b2\b\u0010W\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bk\u0010lJ\u001f\u0010n\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\u0006\u0010m\u001a\u00020,H\u0016¢\u0006\u0004\bn\u0010oJ!\u0010p\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\b\u0010W\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bp\u0010YJ+\u0010s\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\b\u0010W\u001a\u0004\u0018\u00010\r2\b\u0010r\u001a\u0004\u0018\u00010qH\u0016¢\u0006\u0004\bs\u0010tJ\u001f\u0010v\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\u0006\u0010u\u001a\u00020,H\u0016¢\u0006\u0004\bv\u0010oJ3\u0010z\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\u0006\u0010w\u001a\u00020,2\b\u0010x\u001a\u0004\u0018\u00010\r2\b\u0010y\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bz\u0010{J6\u0010\u0080\u0001\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\u0006\u0010}\u001a\u00020|2\b\u0010~\u001a\u0004\u0018\u00010\r2\b\u0010\u007f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J:\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\b\u0010\u007f\u001a\u0004\u0018\u00010\r2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J1\u0010\u0089\u0001\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\t\u0010}\u001a\u0005\u0018\u00010\u0086\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0016¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J$\u0010\u008c\u0001\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0005\b\u008c\u0001\u0010YJ\u0019\u0010\u008d\u0001\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001bH\u0016¢\u0006\u0005\b\u008d\u0001\u0010CJ.\u0010\u0091\u0001\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\b\u0010\u008f\u0001\u001a\u00030\u008e\u00012\b\u0010\u0090\u0001\u001a\u00030\u008e\u0001H\u0016¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J$\u0010\u0093\u0001\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\b\u0010h\u001a\u0004\u0018\u00010gH\u0016¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J-\u0010\u0096\u0001\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\b\u0010W\u001a\u0004\u0018\u00010\r2\u0007\u0010\u0095\u0001\u001a\u00020\u0011H\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J0\u0010\u009a\u0001\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u001b2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0011\u0010\u009c\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b\u009c\u0001\u0010\tJ\u0011\u0010\u009d\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b\u009d\u0001\u0010\tJ/\u0010¡\u0001\u001a\u00020\u00072\u0007\u0010\u009e\u0001\u001a\u00020,2\u0007\u0010\u009f\u0001\u001a\u00020,2\t\u0010 \u0001\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u0011\u0010£\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b£\u0001\u0010\tJ\u0011\u0010¤\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b¤\u0001\u0010\tJ\u0011\u0010¥\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b¥\u0001\u0010\tJ\u001b\u0010§\u0001\u001a\u00020\u00072\u0007\u0010¦\u0001\u001a\u00020,H\u0016¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u0011\u0010©\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b©\u0001\u0010\tJ\u0011\u0010ª\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\bª\u0001\u0010\tJ\u001b\u0010«\u0001\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0005\b«\u0001\u0010AJ\u0011\u0010¬\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b¬\u0001\u0010\tJ\u0011\u0010\u00ad\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0005\b\u00ad\u0001\u0010\u0013J\u0011\u0010®\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b®\u0001\u0010\tJ\u0011\u0010¯\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b¯\u0001\u0010\tJ\u0011\u0010°\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b°\u0001\u0010\tJ\u0011\u0010±\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b±\u0001\u0010\tJ\u001c\u0010´\u0001\u001a\u00020\u00072\b\u0010³\u0001\u001a\u00030²\u0001H\u0014¢\u0006\u0006\b´\u0001\u0010µ\u0001J\u0011\u0010¶\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b¶\u0001\u0010\tJ\u0011\u0010·\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b·\u0001\u0010\tJ\u0015\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u0001H\u0016¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u001c\u0010½\u0001\u001a\u00020\u00072\b\u0010¼\u0001\u001a\u00030»\u0001H\u0016¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u001a\u0010¿\u0001\u001a\u00020\u00112\u0006\u0010W\u001a\u00020\rH\u0016¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u001d\u0010Á\u0001\u001a\u00020\u00072\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J\u0011\u0010Ã\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\bÃ\u0001\u0010\tJ\u0011\u0010Ä\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\bÄ\u0001\u0010\tR\u0019\u0010Å\u0001\u001a\u00020\r8\u0002@\u0002X\u0082D¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R(\u0010Ç\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÇ\u0001\u0010È\u0001\u001a\u0005\bÉ\u0001\u0010\u0013\"\u0006\bÊ\u0001\u0010Ë\u0001R(\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0015\u0010Ì\u0001\u001a\u0005\bÍ\u0001\u0010\u0016\"\u0006\bÎ\u0001\u0010Ï\u0001R\u001d\u0010\u0019\u001a\b\u0018\u00010\u0017R\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0019\u0010Ð\u0001R'\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u001c\u0010Ñ\u0001\u001a\u0005\bÒ\u0001\u0010\u001d\"\u0005\bÓ\u0001\u0010CR(\u0010Ô\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÔ\u0001\u0010È\u0001\u001a\u0005\bÕ\u0001\u0010\u0013\"\u0006\bÖ\u0001\u0010Ë\u0001R,\u0010Ø\u0001\u001a\u0005\u0018\u00010×\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R(\u0010Þ\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÞ\u0001\u0010È\u0001\u001a\u0005\bß\u0001\u0010\u0013\"\u0006\bà\u0001\u0010Ë\u0001R\u001a\u0010â\u0001\u001a\u00030á\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R(\u0010$\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b$\u0010Ì\u0001\u001a\u0005\bä\u0001\u0010\u0016\"\u0006\bå\u0001\u0010Ï\u0001R,\u0010æ\u0001\u001a\u0005\u0018\u00010»\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bæ\u0001\u0010ç\u0001\u001a\u0006\bè\u0001\u0010é\u0001\"\u0006\bê\u0001\u0010¾\u0001R\u001a\u0010ì\u0001\u001a\u00030ë\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bì\u0001\u0010í\u0001R\u001a\u0010ï\u0001\u001a\u00030î\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u001c\u0010ò\u0001\u001a\u0005\u0018\u00010ñ\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u0019\u0010ô\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bô\u0001\u0010õ\u0001R(\u0010ö\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bö\u0001\u0010È\u0001\u001a\u0005\bö\u0001\u0010\u0013\"\u0006\b÷\u0001\u0010Ë\u0001R(\u0010ø\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bø\u0001\u0010È\u0001\u001a\u0005\bø\u0001\u0010\u0013\"\u0006\bù\u0001\u0010Ë\u0001R(\u0010ú\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bú\u0001\u0010È\u0001\u001a\u0005\bû\u0001\u0010\u0013\"\u0006\bü\u0001\u0010Ë\u0001R,\u0010þ\u0001\u001a\u0005\u0018\u00010ý\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bþ\u0001\u0010ÿ\u0001\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002\"\u0006\b\u0082\u0002\u0010\u0083\u0002R\u001f\u0010\u0085\u0002\u001a\u00030\u0084\u00028\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0085\u0002\u0010\u0086\u0002\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002R,\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¹\u0001\u0010\u0089\u0002\u001a\u0006\b\u008a\u0002\u0010º\u0001\"\u0006\b\u008b\u0002\u0010\u008c\u0002R(\u0010\u008d\u0002\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u008d\u0002\u0010È\u0001\u001a\u0005\b\u008e\u0002\u0010\u0013\"\u0006\b\u008f\u0002\u0010Ë\u0001R\u0019\u0010W\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bW\u0010Æ\u0001R\u001e\u0010\u0091\u0002\u001a\u00070\u0090\u0002R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0002\u0010\u0092\u0002R\u001e\u0010\u0094\u0002\u001a\u00070\u0093\u0002R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0002\u0010\u0095\u0002R\u001e\u0010\u0097\u0002\u001a\u00070\u0096\u0002R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0002\u0010\u0098\u0002¨\u0006\u009e\u0002"}, d2 = {"Lcom/baidu/nadcore/webview/container/NadBrowserContainer;", "Lcom/baidu/tieba/fa1;", "Lcom/baidu/tieba/qb1;", "Lcom/baidu/nadcore/webview/container/AbsBrowserContainer;", "Landroid/app/Activity;", "activity", "()Landroid/app/Activity;", "", "addBrowserLayout", "()V", "addJavaScriptInterface", "", "obj", "", "name", "addJavaScriptScriptInterface", "(Ljava/lang/Object;Ljava/lang/String;)V", "", "applyKeyboardConfig", "()Z", "Landroid/widget/LinearLayout;", "browserLayout", "()Landroid/widget/LinearLayout;", "Lcom/baidu/nadcore/webview/data/NadBrowserModelHelper$NadBrowserModel;", "Lcom/baidu/nadcore/webview/data/NadBrowserModelHelper;", "browserModel", "()Lcom/baidu/nadcore/webview/data/NadBrowserModelHelper$NadBrowserModel;", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;", "browserView", "()Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;", "Landroid/view/MotionEvent;", "e", "canSlide", "(Landroid/view/MotionEvent;)Z", "checkNeedAppendPublicParamFromIntent", "closeFrame", "containerLayout", "forbidKeyboardAdjust", "forceHideSoftInput", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "getLpRealUrlFromIntent", "()Ljava/lang/String;", "", "getNairobiKernelType", "()I", "getPageTitle", "getRefererUrlFromIntent", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "getUrl", "Landroid/content/Intent;", "intent", "getUrlFromIntent", "(Landroid/content/Intent;)Ljava/lang/String;", "getWebViewScrollY", "Landroid/view/Window;", "getWindow", "()Landroid/view/Window;", "initBrowserLayout", "initBrowserView", "initBusiness", "initFullScreen", "(Landroid/content/Intent;)V", "initJsAbility", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;)V", "initNavigationBar", "initOrientation", "initUIWithIntent", "initUIWithoutIntent", "initWebSettings", "initWebSettingsWithIntent", "()Landroid/content/Intent;", "isCloseBtnClicked", "Lcom/baidu/nadcore/webview/interfaces/INadBrowserCommonCallback;", WebChromeClient.KEY_ARG_CALLBACK, "isFavorExistByUrl", "(Lcom/baidu/nadcore/webview/interfaces/INadBrowserCommonCallback;)V", "isKernelDowngrade", "isValidWebView", "loadUrl", "", "params", "(Ljava/util/Map;)V", "webView", "url", "notifyFirstScreenPaintFinishedExt", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;)V", "Landroid/os/Message;", "dontResend", "resend", "notifyFormResubmission", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/os/Message;Landroid/os/Message;)V", "scrollOffsetY", "scrollExtentY", "notifyGestureScrollEnded", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;II)V", "Lcom/baidu/nadcore/webview/webviewclient/AbsWebResourceResponseWrapper;", "notifyInterceptRequest", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;)Lcom/baidu/nadcore/webview/webviewclient/AbsWebResourceResponseWrapper;", "notifyLoadResource", "Landroid/view/KeyEvent;", "event", "notifyOverrideKeyEvent", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/view/KeyEvent;)Z", "notifyOverrideUrlLoading", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;)Z", "step", "notifyPageBackOrForwardExt", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;I)V", "notifyPageFinished", "Landroid/graphics/Bitmap;", "favicon", "notifyPageStarted", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "newProgress", "notifyProgressChanged", CloudStabilityUBCUtils.KEY_ERROR_CODE, "description", "failingUrl", "notifyReceivedError", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;ILjava/lang/String;Ljava/lang/String;)V", "Lcom/baidu/nadcore/webview/webviewclient/AbsHttpAuthHandlerWrapper;", "handler", "host", "realm", "notifyReceivedHttpAuthRequest", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Lcom/baidu/nadcore/webview/webviewclient/AbsHttpAuthHandlerWrapper;Ljava/lang/String;Ljava/lang/String;)V", "account", WebChromeClient.KEY_ARG_ARRAY, "notifyReceivedLoginRequest", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "error", "notifyReceivedSslError", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V", "title", "notifyReceivedTitle", "notifyRequestFocus", "", "oldScale", "newScale", "notifyScaleChanged", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;FF)V", "notifyUnhandledKeyEvent", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Landroid/view/KeyEvent;)V", "isReload", "notifyUpdateVisitedHistory", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Z)V", "originalUrl", "redirectedUrl", "notifyUrlRedirectedExt", "(Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;Ljava/lang/String;Ljava/lang/String;)V", "notifyWebViewInitFinished", "notifyWebViewRelease", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onCreate", MissionEvent.MESSAGE_DESTROY, "onHideLoading", "itemType", "onLightBrowserViewMenuClickType", "(I)V", "onLoadFailure", "onLoadSuccess", "onNewIntent", MissionEvent.MESSAGE_PAUSE, "onPreLoadUrl", "onResume", "pageBack", "parseBrowserModel", Headers.REFRESH, "Lcom/baidu/nadcore/webview/business/IContainerUrlLoadAction;", "action", "registerAction", "(Lcom/baidu/nadcore/webview/business/IContainerUrlLoadAction;)V", "registerBusinessPlugins", "registerH5CallBack", "Landroid/widget/FrameLayout;", "rootView", "()Landroid/widget/FrameLayout;", "Landroid/view/View;", "view", "setContentView", "(Landroid/view/View;)V", "shouldOverrideUrlLoading", "(Ljava/lang/String;)Z", "updateTitle", "(Ljava/lang/String;)V", "urlShare", "webViewGoBack", "TAG", "Ljava/lang/String;", "applyKeyboardAdjust", "Z", "getApplyKeyboardAdjust", "setApplyKeyboardAdjust", "(Z)V", "Landroid/widget/LinearLayout;", "getBrowserLayout", "setBrowserLayout", "(Landroid/widget/LinearLayout;)V", "Lcom/baidu/nadcore/webview/data/NadBrowserModelHelper$NadBrowserModel;", "Lcom/baidu/nadcore/webview/view/AbsNadBrowserView;", "getBrowserView", "setBrowserView", "clickedCloseBtn", "getClickedCloseBtn", "setClickedCloseBtn", "Landroid/widget/ImageView;", "closeBtn", "Landroid/widget/ImageView;", "getCloseBtn", "()Landroid/widget/ImageView;", "setCloseBtn", "(Landroid/widget/ImageView;)V", "configStatusBar", "getConfigStatusBar", "setConfigStatusBar", "Lcom/baidu/nadcore/webview/prerender/ConsumeData;", "consumeData", "Lcom/baidu/nadcore/webview/prerender/ConsumeData;", "getContainerLayout", "setContainerLayout", "contentLayout", "Landroid/view/View;", "getContentLayout", "()Landroid/view/View;", "setContentLayout", "Lcom/baidu/nadcore/webview/interfaces/IFrameContext;", "frameContext", "Lcom/baidu/nadcore/webview/interfaces/IFrameContext;", "Lcom/baidu/nadcore/webview/interfaces/IFrameExtHandler;", "frameExtHandler", "Lcom/baidu/nadcore/webview/interfaces/IFrameExtHandler;", "Lcom/baidu/nadcore/webview/webevent/IWebEventNotifier;", "frameWebEventNotifier", "Lcom/baidu/nadcore/webview/webevent/IWebEventNotifier;", "h5CallBackEventObject", "Ljava/lang/Object;", "isInjectGoBack", "setInjectGoBack", "isVideoPage", "setVideoPage", "kernelDowngrade", "getKernelDowngrade", "setKernelDowngrade", "Lcom/baidu/nadcore/webview/util/BdPageDialogsHandler;", "pageDialogsHandler", "Lcom/baidu/nadcore/webview/util/BdPageDialogsHandler;", "getPageDialogsHandler", "()Lcom/baidu/nadcore/webview/util/BdPageDialogsHandler;", "setPageDialogsHandler", "(Lcom/baidu/nadcore/webview/util/BdPageDialogsHandler;)V", "Lcom/baidu/nadcore/webview/business/PluginManager;", "pluginManager", "Lcom/baidu/nadcore/webview/business/PluginManager;", "getPluginManager", "()Lcom/baidu/nadcore/webview/business/PluginManager;", "Landroid/widget/FrameLayout;", "getRootView", "setRootView", "(Landroid/widget/FrameLayout;)V", "showNavigationBar", "getShowNavigationBar", "setShowNavigationBar", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebChromeClientProxy;", "webChromeClientProxy", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebChromeClientProxy;", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebViewClientExtProxy;", "webViewClientExtProxy", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebViewClientExtProxy;", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebViewClientProxy;", "webViewClientProxy", "Lcom/baidu/nadcore/webview/container/NadBrowserContainer$WebViewClientProxy;", "<init>", "(Lcom/baidu/nadcore/webview/interfaces/IFrameContext;Lcom/baidu/nadcore/webview/interfaces/IFrameExtHandler;Lcom/baidu/nadcore/webview/webevent/IWebEventNotifier;)V", "WebChromeClientProxy", "WebViewClientExtProxy", "WebViewClientProxy", "lib-webview_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public class NadBrowserContainer extends AbsBrowserContainer implements fa1, qb1 {
    public final qb1 A;
    public final String c;
    public View d;
    public FrameLayout e;
    public LinearLayout f;
    public LinearLayout g;
    public AbsNadBrowserView h;
    public ImageView i;
    public final c j;
    public final b k;
    public final a l;
    public boolean m;
    public boolean n;
    public String o;
    public pa1.d p;
    public ib1 q;
    public final la1 r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public final gb1 w;
    public final Object x;
    public final ta1 y;
    public final ua1 z;

    public void c0(AbsNadBrowserView browserView) {
        Intrinsics.checkNotNullParameter(browserView, "browserView");
    }

    /* loaded from: classes3.dex */
    public final class c extends vb1 {

        /* loaded from: classes3.dex */
        public static final class a implements ab1 {
            public final /* synthetic */ AbsNadBrowserView b;
            public final /* synthetic */ SslErrorHandler c;
            public final /* synthetic */ SslError d;

            public a(AbsNadBrowserView absNadBrowserView, SslErrorHandler sslErrorHandler, SslError sslError) {
                this.b = absNadBrowserView;
                this.c = sslErrorHandler;
                this.d = sslError;
            }

            @Override // com.baidu.tieba.ab1
            public final void cancel() {
                NadBrowserContainer.this.j.j(this.b, this.c, this.d);
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c() {
        }

        @Override // com.baidu.tieba.vb1
        public void a(AbsNadBrowserView webView, Message message, Message message2) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.s0(webView, message, message2);
        }

        @Override // com.baidu.tieba.vb1
        public void j(AbsNadBrowserView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            if (webView.y()) {
                a aVar = new a(webView, sslErrorHandler, sslError);
                ib1 S = NadBrowserContainer.this.S();
                if (S != null) {
                    S.t(aVar, sslErrorHandler, sslError);
                }
            }
            NadBrowserContainer.this.B0(webView, sslErrorHandler, sslError);
        }

        @Override // com.baidu.tieba.vb1
        public void k(AbsNadBrowserView webView, float f, float f2) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.z(webView, f, f2);
        }

        @Override // com.baidu.tieba.vb1
        public void m(AbsNadBrowserView webView, String str, boolean z) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.A0(webView, str, z);
        }

        @Override // com.baidu.tieba.vb1
        public tb1 b(AbsNadBrowserView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            return NadBrowserContainer.this.n0(webView, str);
        }

        @Override // com.baidu.tieba.vb1
        public void c(AbsNadBrowserView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.f(webView, str);
        }

        @Override // com.baidu.tieba.vb1
        public boolean d(AbsNadBrowserView webView, KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            return NadBrowserContainer.this.J(webView, keyEvent);
        }

        @Override // com.baidu.tieba.vb1
        public boolean e(AbsNadBrowserView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            return NadBrowserContainer.this.M0(webView, str);
        }

        @Override // com.baidu.tieba.vb1
        public void l(AbsNadBrowserView webView, KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.F0(webView, keyEvent);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
            if (kotlin.text.StringsKt__StringsKt.contains((java.lang.CharSequence) r6, (java.lang.CharSequence) r2, false) == true) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.tieba.vb1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void f(AbsNadBrowserView webView, String str) {
            int i;
            Intrinsics.checkNotNullParameter(webView, "webView");
            jb1.c(NadBrowserContainer.this.getActivity(), "PAGE FINISHED");
            jb1.a(NadBrowserContainer.this.c, "page finished");
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
                NadBrowserContainer.this.v0(webView.getTitle());
                NadBrowserContainer.this.s(webView, str);
                if (!webView.v()) {
                    webView.F(webView);
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
            NadBrowserContainer.this.v0(webView.getTitle());
            NadBrowserContainer.this.s(webView, str);
            if (!webView.v()) {
            }
        }

        @Override // com.baidu.tieba.vb1
        public void g(AbsNadBrowserView webView, String str, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            jb1.c(NadBrowserContainer.this.getActivity(), "PAGE STARTED");
            jb1.a(NadBrowserContainer.this.c, "page started");
            if (webView.u()) {
                webView.setTag(R.id.nad_webcontent_error_code, 0);
            }
            webView.setFirstPage(false);
            webView.U();
            if (webView.d()) {
                ImageView O = NadBrowserContainer.this.O();
                if (O != null) {
                    O.setVisibility(0);
                }
            } else {
                ImageView O2 = NadBrowserContainer.this.O();
                if (O2 != null) {
                    O2.setVisibility(4);
                }
            }
            NadBrowserContainer.this.T0(webView, str, bitmap);
        }

        @Override // com.baidu.tieba.vb1
        public void h(AbsNadBrowserView webView, int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            webView.setTag(R.id.nad_webcontent_error_code, Integer.valueOf(i));
            NadBrowserContainer.this.c(webView, i, str, str2);
        }

        @Override // com.baidu.tieba.vb1
        public void i(AbsNadBrowserView webView, rb1 handler, String str, String str2) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(handler, "handler");
            NadBrowserContainer.this.U0(webView, handler, str, str2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d implements ja1.a {
        public d() {
        }

        /* loaded from: classes3.dex */
        public static final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                AbsNadBrowserView N = NadBrowserContainer.this.N();
                if (N != null && N.d()) {
                    NadBrowserContainer.this.i();
                    return;
                }
                sa1 p = NadBrowserContainer.this.p();
                if (p != null) {
                    p.p();
                }
            }
        }

        @Override // com.baidu.tieba.ja1.a
        public final void a() {
            AbsNadBrowserView N = NadBrowserContainer.this.N();
            if (N != null) {
                N.post(new a());
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class a extends sb1 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.baidu.tieba.sb1
        public void c(AbsNadBrowserView webView) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.g(webView);
        }

        @Override // com.baidu.tieba.sb1
        public void a(AbsNadBrowserView webView, int i) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.m1(webView, i);
            webView.O(i);
        }

        @Override // com.baidu.tieba.sb1
        public void b(AbsNadBrowserView webView, String str) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            NadBrowserContainer.this.v0(str);
            NadBrowserContainer.this.Q(webView, str);
        }
    }

    /* loaded from: classes3.dex */
    public final class b extends ub1 {
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
            p71 clipboardManager = p71.a(this.a.getContext());
            AbsNadBrowserView N = this.b.N();
            if (N != null && N.w()) {
                str = BdSailorPlatform.SAILOR_MODULE_NAME;
            } else {
                str = "native";
            }
            Intrinsics.checkNotNullExpressionValue(clipboardManager, "clipboardManager");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("kernel", str);
            jSONObject.put("model", this.b.p);
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
                this.a.I();
            } catch (Exception unused) {
                jb1.b("NadBrowserContainer", "releaseWebView - exception");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends jn0<o81> {
        public g(Class cls) {
            super(cls);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jn0
        public void onEvent(o81 event) {
            AbsNadBrowserView N;
            Intrinsics.checkNotNullParameter(event, "event");
            if (!TextUtils.isEmpty(event.a) && (N = NadBrowserContainer.this.N()) != null) {
                AbsNadBrowserView.C(N, event.a, null, 2, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadBrowserContainer(ta1 frameContext, ua1 frameExtHandler, qb1 qb1Var) {
        super(frameContext);
        Intrinsics.checkNotNullParameter(frameContext, "frameContext");
        Intrinsics.checkNotNullParameter(frameExtHandler, "frameExtHandler");
        this.y = frameContext;
        this.z = frameExtHandler;
        this.A = qb1Var;
        this.c = "NadBrowserContainer";
        this.j = new c();
        this.k = new b();
        this.l = new a();
        this.m = true;
        this.n = true;
        this.r = new la1(this);
        this.w = new gb1();
        this.x = new Object();
        this.w.a(System.currentTimeMillis());
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer
    public void B(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.B(view2);
        this.d = view2;
        this.e = (FrameLayout) view2.findViewById(R.id.container_rootview);
        this.f = (LinearLayout) view2.findViewById(R.id.container_layout);
    }

    public final boolean I(MotionEvent motionEvent) {
        AbsNadBrowserView absNadBrowserView;
        if (!k0() || (absNadBrowserView = this.h) == null) {
            return false;
        }
        return absNadBrowserView.e(motionEvent);
    }

    public final String V(Intent intent) {
        String str;
        pa1.d dVar = this.p;
        if (dVar != null) {
            str = dVar.l();
        } else {
            str = null;
        }
        String e2 = m71.e(str);
        K();
        if (TextUtils.isEmpty(e2) || !m71.h(m71.c(e2))) {
            return "";
        }
        return e2;
    }

    @Override // com.baidu.tieba.fa1
    public boolean a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return this.r.g(url);
    }

    @Override // com.baidu.tieba.qb1
    public void g(AbsNadBrowserView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.g(webView);
        }
    }

    public final void i0(AbsNadBrowserView absNadBrowserView) {
        jb1.a(this.c, "initWebSettings");
        absNadBrowserView.setWebViewClientProxies(this.j, this.k, this.l);
        absNadBrowserView.setStateChangeCallback(this);
        c0(absNadBrowserView);
    }

    public final void j0(AbsNadBrowserView absNadBrowserView) {
        absNadBrowserView.setStateViewVisibility(!Intrinsics.areEqual(YYOption.IsLive.VALUE_TRUE, q().getStringExtra("hide_state_view")));
    }

    public void n(ga1 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.r.n(action);
    }

    public final void t0(boolean z) {
        this.n = z;
    }

    public final void u0(boolean z) {
        this.m = z;
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer
    public void v(Intent intent) {
        super.v(intent);
        jb1.a(this.c, "onNewIntent");
        getActivity().setIntent(intent);
        p0();
        this.o = V(q());
        f0();
        this.r.k(intent);
    }

    public final void v0(String str) {
        if (this.e == null) {
            jb1.d(new RuntimeException("rootView 为空！"));
        } else if (!this.z.t0()) {
        } else {
            FrameLayout frameLayout = this.e;
            Intrinsics.checkNotNull(frameLayout);
            TextView textView = (TextView) frameLayout.findViewById(R.id.tv_title);
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    @Override // com.baidu.tieba.qb1
    public void F0(AbsNadBrowserView webView, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.F0(webView, keyEvent);
        }
    }

    @Override // com.baidu.tieba.qb1
    public boolean J(AbsNadBrowserView webView, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            return qb1Var.J(webView, keyEvent);
        }
        return false;
    }

    @Override // com.baidu.tieba.qb1
    public boolean M0(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (this.r.b(webView, str)) {
            return true;
        }
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            return qb1Var.M0(webView, str);
        }
        return false;
    }

    @Override // com.baidu.tieba.qb1
    public void Q(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.r.f(webView, str);
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.Q(webView, str);
        }
    }

    @Override // com.baidu.tieba.qb1
    public void f(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.f(webView, str);
        }
    }

    @Override // com.baidu.tieba.qb1
    public void m1(AbsNadBrowserView webView, int i) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.m1(webView, i);
        }
    }

    @Override // com.baidu.tieba.qb1
    public tb1 n0(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            return qb1Var.n0(webView, str);
        }
        return null;
    }

    @Override // com.baidu.tieba.qb1
    public void s(AbsNadBrowserView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        jb1.a(this.c, "onPageFinished");
        this.r.c(webView, str);
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.s(webView, str);
        }
        if (!this.v) {
            AbsNadBrowserView absNadBrowserView = this.h;
            if (absNadBrowserView != null) {
                AbsNadBrowserView.E(absNadBrowserView, "javascript:(function go_back_js_interface_name(){window.history.back=function(){javascript:(function(){if(typeof(window.go_back_js_interface_name)=='undefined'){window.prompt('BdboxApp:'+JSON.stringify({obj:'go_back_js_interface_name',func:'onGoBack',args:[]}));}else{window.go_back_js_interface_name.onGoBack();}})()};})()", null, false, 6, null);
            }
            this.v = true;
        }
    }

    @Override // com.baidu.tieba.qb1
    public void A0(AbsNadBrowserView webView, String str, boolean z) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.A0(webView, str, z);
        }
    }

    @Override // com.baidu.tieba.qb1
    public void B0(AbsNadBrowserView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.B0(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.tieba.qb1
    public void T0(AbsNadBrowserView webView, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        jb1.a(this.c, "onPageStarted");
        this.r.d(webView, str, bitmap);
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.T0(webView, str, bitmap);
        }
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer
    public void r(int i, int i2, Intent intent) {
        super.r(i, i2, intent);
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            absNadBrowserView.G(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.qb1
    public void s0(AbsNadBrowserView webView, Message message, Message message2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.s0(webView, message, message2);
        }
    }

    @Override // com.baidu.tieba.qb1
    public void z(AbsNadBrowserView webView, float f2, float f3) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.z(webView, f2, f3);
        }
    }

    public final void G() {
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

    public final void q0() {
        this.r.o(new da1(this));
        this.r.o(new ka1(this));
        this.r.o(new ea1(this));
        this.r.o(new ca1(this));
        this.r.o(new ia1(this));
        this.r.o(new ma1(this));
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer
    public void u() {
        jb1.c(getActivity(), "启动内罗毕框架");
        jb1.a(this.c, "onCreate");
        super.u();
        View view2 = View.inflate(this.y.getActivity(), R.layout.nad_browser_activity, null);
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        B(view2);
        h0();
        a0();
        this.o = V(q());
        f0();
        this.r.i();
    }

    public final void H() {
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            absNadBrowserView.a(new ja1(new d()), "go_back_js_interface_name");
        }
    }

    public final boolean K() {
        boolean z;
        pa1.a c2;
        pa1.d dVar = this.p;
        if (dVar != null && (c2 = dVar.c()) != null) {
            z = c2.b();
        } else {
            z = false;
        }
        if (!z && !this.z.f1()) {
            return false;
        }
        return true;
    }

    public void L() {
        Context M = M();
        Window window = getActivity().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getActivity().window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getActivity().window.decorView");
        w61.a(M, decorView.getWindowToken());
    }

    public final Context M() {
        return bb1.a();
    }

    public final AbsNadBrowserView N() {
        return this.h;
    }

    public final ImageView O() {
        return this.i;
    }

    public final String P() {
        Bundle extras = q().getExtras();
        if (extras != null) {
            Intrinsics.checkNotNullExpressionValue(extras, "getIntent().extras ?: return null");
            Serializable serializable = extras.getSerializable("map");
            if (!(serializable instanceof HashMap)) {
                serializable = null;
            }
            HashMap hashMap = (HashMap) serializable;
            if (hashMap != null && hashMap != null && !hashMap.isEmpty()) {
                return (String) j31.b(hashMap, "lp_real_url");
            }
        }
        return null;
    }

    public final ib1 S() {
        return this.q;
    }

    public final String T() {
        Bundle extras = q().getExtras();
        if (extras != null) {
            Intrinsics.checkNotNullExpressionValue(extras, "getIntent().extras ?: return null");
            Serializable serializable = extras.getSerializable("map");
            if (!(serializable instanceof HashMap)) {
                serializable = null;
            }
            HashMap hashMap = (HashMap) serializable;
            if (hashMap != null && hashMap != null && !hashMap.isEmpty()) {
                return (String) j31.b(hashMap, "charge_url");
            }
        }
        return null;
    }

    public final FrameLayout U() {
        return this.e;
    }

    public final int W() {
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            return absNadBrowserView.getWebViewScrollY();
        }
        return -1;
    }

    public final Window X() {
        Window window = getActivity().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getActivity().window");
        return window;
    }

    @Override // com.baidu.tieba.qb1
    public void X0() {
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.X0();
        }
    }

    public final void a0() {
        p0();
        q0();
    }

    @Override // com.baidu.tieba.fa1
    public Activity b() {
        return getActivity();
    }

    @Override // com.baidu.tieba.fa1
    public boolean d() {
        return this.u;
    }

    @Override // com.baidu.tieba.fa1
    public LinearLayout e() {
        return this.f;
    }

    public final void f0() {
        Intent q = q();
        e0(q);
        b0(q);
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView == null) {
            jb1.d(new RuntimeException("browserView 为空！"));
            return;
        }
        Intrinsics.checkNotNull(absNadBrowserView);
        j0(absNadBrowserView);
        g0();
        l0();
        H();
    }

    @Override // com.baidu.tieba.qb1
    public void g0() {
        this.r.h();
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.g0();
        }
    }

    public final Resources getResources() {
        Resources resources = getActivity().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getActivity().resources");
        return resources;
    }

    @Override // com.baidu.tieba.fa1
    public boolean h() {
        return this.t;
    }

    public final void h0() {
        Z();
        AbsNadBrowserView absNadBrowserView = this.h;
        Intrinsics.checkNotNull(absNadBrowserView);
        absNadBrowserView.H();
        G();
        r0();
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer, com.baidu.tieba.r81
    public void i() {
        if (k0()) {
            w0();
        }
    }

    @Override // com.baidu.tieba.fa1
    public FrameLayout j() {
        return this.e;
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer, com.baidu.tieba.r81
    public void k() {
        if (!this.u) {
            this.u = true;
        }
        super.k();
    }

    public final boolean k0() {
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            return absNadBrowserView.y();
        }
        return false;
    }

    @Override // com.baidu.tieba.fa1
    public pa1.d l() {
        return this.p;
    }

    @Override // com.baidu.tieba.fa1
    public AbsNadBrowserView m() {
        return this.h;
    }

    public final boolean o0() {
        if (this.r.a() || this.z.e1()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.wa1
    public void onHideLoading() {
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.onHideLoading();
        }
    }

    @Override // com.baidu.tieba.wa1
    public void onLoadFailure() {
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.onLoadFailure();
        }
    }

    @Override // com.baidu.tieba.wa1
    public void onLoadSuccess() {
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.onLoadSuccess();
        }
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer, com.baidu.tieba.va1
    public void onPause() {
        jb1.a(this.c, MissionEvent.MESSAGE_PAUSE);
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            absNadBrowserView.L();
        }
        this.r.l();
        super.onPause();
    }

    public final void p0() {
        pa1.d b2 = new pa1(q()).b();
        this.p = b2;
        if (b2 != null) {
            b2.o(this.s);
        }
        jb1.a(this.c, String.valueOf(this.p));
    }

    public final void r0() {
        fn0.a().c(this.x, 1, new g(o81.class));
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer
    public void w() {
        jb1.a(this.c, "onResume");
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            absNadBrowserView.M();
        }
        this.r.m();
        super.w();
    }

    public void w0() {
        AbsNadBrowserView absNadBrowserView;
        L();
        if (k0() && (absNadBrowserView = this.h) != null && absNadBrowserView.j()) {
            return;
        }
        this.y.l();
    }

    public final int R() {
        Serializable serializable;
        db1 d2 = bb1.d();
        if (d2 != null && d2.a()) {
            Bundle extras = q().getExtras();
            HashMap hashMap = null;
            if (extras != null) {
                serializable = extras.getSerializable("map");
            } else {
                serializable = null;
            }
            if (serializable instanceof HashMap) {
                hashMap = serializable;
            }
            if (TextUtils.equals((CharSequence) j31.b(hashMap, "downgrade_to_native"), "1")) {
                if (!this.t) {
                    this.t = true;
                }
                return w91.c();
            }
            return un0.b().a().a("nairobi_kernel_type", w91.b());
        }
        return w91.c();
    }

    @Override // com.baidu.tieba.qb1
    public void U0(AbsNadBrowserView webView, rb1 handler, String str, String str2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(handler, "handler");
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.U0(webView, handler, str, str2);
        }
    }

    @Override // com.baidu.tieba.qb1
    public void c(AbsNadBrowserView webView, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.r.e(webView, i, str, str2);
        qb1 qb1Var = this.A;
        if (qb1Var != null) {
            qb1Var.c(webView, i, str, str2);
        }
    }

    public LinearLayout Y() {
        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        if (this.h == null) {
            this.w.c(P());
            this.w.b(T());
            this.h = w91.a().c(getActivity(), this.w, R());
        }
        AbsNadBrowserView absNadBrowserView = this.h;
        if (absNadBrowserView != null) {
            linearLayout.addView(absNadBrowserView, layoutParams);
        } else {
            jb1.c(getActivity(), "创建 browserView 失败，退出落地页框架");
            this.y.l();
            jb1.d(new IllegalArgumentException("browserView is null, cannot be added to browserLayout"));
        }
        jb1.a(this.c, "created new browserView");
        return linearLayout;
    }

    public final void Z() {
        s81 e2;
        if (this.g != null) {
            return;
        }
        this.g = Y();
        if (!k0()) {
            return;
        }
        AbsNadBrowserView absNadBrowserView = this.h;
        Intrinsics.checkNotNull(absNadBrowserView);
        i0(absNadBrowserView);
        if (this.n && (e2 = bb1.e()) != null) {
            e2.a(getActivity());
        }
        if (this.m) {
            d0();
        } else {
            FrameLayout frameLayout = this.e;
            if (frameLayout == null) {
                jb1.d(new RuntimeException("rootView 为空！"));
                return;
            }
            Intrinsics.checkNotNull(frameLayout);
            View findViewById = frameLayout.findViewById(R.id.container_titlebar);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView!!.findViewById(R.id.container_titlebar)");
            findViewById.setVisibility(8);
        }
        if (this.q != null) {
            this.q = new ib1(this.y.getActivity());
        }
    }

    public void l0() {
        String str;
        AbsNadBrowserView absNadBrowserView;
        if (o0()) {
            return;
        }
        if (k0() && (absNadBrowserView = this.h) != null) {
            absNadBrowserView.h();
        }
        jb1.a(this.c, "start to load url >>> " + this.o);
        if (k0()) {
            pa1.d dVar = this.p;
            String str2 = null;
            if (dVar != null) {
                str = dVar.i();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                Pair[] pairArr = new Pair[1];
                pa1.d dVar2 = this.p;
                if (dVar2 != null) {
                    str2 = dVar2.i();
                }
                pairArr[0] = new Pair("Referer", str2);
                m0(MapsKt__MapsKt.mutableMapOf(pairArr));
                return;
            }
            AbsNadBrowserView absNadBrowserView2 = this.h;
            if (absNadBrowserView2 != null) {
                AbsNadBrowserView.E(absNadBrowserView2, this.o, null, false, 6, null);
            }
        }
    }

    @Override // com.baidu.nadcore.webview.container.AbsBrowserContainer, com.baidu.tieba.va1
    public void onDestroy() {
        jb1.a(this.c, MissionEvent.MESSAGE_DESTROY);
        X0();
        this.r.j();
        this.r.p();
        fn0.a().unregister(this.x);
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
        if (!q61.b.c()) {
            new Handler().postDelayed(new f(absNadBrowserView3), 1500L);
        } else {
            try {
                try {
                    absNadBrowserView3.I();
                } catch (Exception unused) {
                    jb1.b("NadBrowserContainer", "releaseWebView - exception");
                }
            } catch (Exception unused2) {
                absNadBrowserView3.I();
            }
        }
        this.h = null;
        jb1.c(getActivity(), "销毁 内罗毕框架");
        super.onDestroy();
    }

    public final void b0(Intent intent) {
        if (!TextUtils.equals(intent.getStringExtra("layoutfullscreen"), "1")) {
            return;
        }
        TextUtils.equals("1", intent.getStringExtra("statusbar"));
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = X().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getWindow().decorView");
            X().getDecorView().setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 8192);
            X().addFlags(Integer.MIN_VALUE);
            X().setStatusBarColor(getResources().getColor(R.color.nad_transparent, null));
        }
    }

    public final void d0() {
        int[] c2;
        ImageView imageView;
        FrameLayout frameLayout = this.e;
        if (frameLayout == null) {
            jb1.d(new RuntimeException("rootView 为空！"));
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
        q81 f2 = bb1.f();
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
                imageView = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f100146), null, R.style.obfuscated_res_0x7f100146);
            } else if (i2 == R.drawable.nad_web_close) {
                imageView = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f100147), null, R.style.obfuscated_res_0x7f100147);
            } else {
                imageView = null;
            }
            if (imageView != null) {
                imageView.setImageResource(i2);
                imageView.setTag(Integer.valueOf(i2));
                imageView2 = imageView;
            }
            q81 f3 = bb1.f();
            Intrinsics.checkNotNull(f3);
            f3.a(imageView2, this);
            linearLayout.addView(imageView2);
            if (i2 == R.drawable.nad_web_close) {
                this.i = imageView2;
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
            }
            i++;
        }
        q81 f4 = bb1.f();
        Intrinsics.checkNotNull(f4);
        for (int i3 : f4.c()) {
            NadLongPressView nadLongPressView = new NadLongPressView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f100146), null, R.style.obfuscated_res_0x7f100146);
            nadLongPressView.setImageResource(i3);
            nadLongPressView.setTag(Integer.valueOf(i3));
            nadLongPressView.setHandler(new e(nadLongPressView, this, i3));
            q81 f5 = bb1.f();
            Intrinsics.checkNotNull(f5);
            f5.a(nadLongPressView, this);
            linearLayout2.addView(nadLongPressView);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void e0(Intent intent) {
        String str;
        pa1.a c2;
        pa1.d dVar = this.p;
        if (dVar != null && (c2 = dVar.c()) != null) {
            str = c2.a();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (Build.VERSION.SDK_INT == 26 && (getActivity() instanceof BaseActivity)) {
            Activity activity = getActivity();
            if (activity != null) {
                ((BaseActivity) activity).setCurrentActivityNoTransparent();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.nadcore.appframework.BaseActivity");
            }
        }
        if (str != null) {
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0") && getActivity().getRequestedOrientation() != -1) {
                        getActivity().setRequestedOrientation(-1);
                        return;
                    }
                    return;
                case 49:
                    if (str.equals("1") && getActivity().getRequestedOrientation() != 1) {
                        getActivity().setRequestedOrientation(1);
                        return;
                    }
                    return;
                case 50:
                    if (str.equals("2") && getActivity().getRequestedOrientation() != 0) {
                        getActivity().setRequestedOrientation(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void m0(Map<String, String> map) {
        AbsNadBrowserView absNadBrowserView;
        if (o0()) {
            return;
        }
        String str = this.c;
        jb1.a(str, "start to load url >>> " + this.o);
        if (k0() && (absNadBrowserView = this.h) != null) {
            AbsNadBrowserView.E(absNadBrowserView, this.o, map, false, 4, null);
        }
    }
}
