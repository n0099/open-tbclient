package com.baidu.searchbox.common.security;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.security.IDeviceInfoAppHost;
import com.baidu.searchbox.common.security.IDeviceInfoService;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.ve1;
import com.baidu.tieba.vi8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001Q\bÇ\u0002\u0018\u0000:\u0002\u0092\u0001B\n\b\u0002¢\u0006\u0005\b\u0091\u0001\u0010NJ\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001eJ\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010!J%\u0010\"\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\"\u0010\u0011J%\u0010#\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b#\u0010\u0011J/\u0010#\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010'J%\u0010(\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b(\u0010\u0011J\u001d\u0010)\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b+\u0010*J\u001d\u0010,\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b,\u0010*J%\u0010-\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b-\u0010\u0011J/\u0010-\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b-\u0010$J\u001d\u0010.\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b.\u0010*J\u0015\u0010/\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u0002012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u0002012\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b4\u00103J\u001d\u00107\u001a\u0002012\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0003¢\u0006\u0004\b7\u00108J'\u00109\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b9\u0010\u0011J'\u0010:\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b:\u0010\u0011J'\u0010;\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b;\u0010\u0011J'\u0010<\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b<\u0010\u0011J\u001f\u0010=\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b=\u0010*J\u0015\u0010>\u001a\u0002012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b>\u0010?J\u001f\u0010@\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b@\u0010*J\u001f\u0010A\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\bA\u0010*J'\u0010B\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\bB\u0010\u0011J\u001f\u0010C\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\bC\u0010*J\u0017\u0010D\u001a\u0002012\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\bD\u0010?J\u0017\u0010E\u001a\u0002012\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\bE\u0010?J\u001d\u0010F\u001a\u0002012\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0003¢\u0006\u0004\bF\u00108J\u0017\u0010I\u001a\u00020\u00032\u0006\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u000201H\u0002¢\u0006\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00038\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010R\u001a\u00020Q8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\bR\u0010S\u0012\u0004\bT\u0010NR\u0016\u0010U\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bW\u0010VR\u0016\u0010X\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bX\u0010VR\u0016\u0010Y\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u0010VR\u0016\u0010Z\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bZ\u0010VR\u0016\u0010[\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b[\u0010VR\u0016\u0010\\\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\\\u0010VR\u0016\u0010]\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b]\u0010VR\u0016\u0010^\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b^\u0010VR\u0016\u0010_\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b_\u0010VR\u0016\u0010`\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b`\u0010VR\u0016\u0010a\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\ba\u0010VR\u0016\u0010b\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bb\u0010VR\u0016\u0010c\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bc\u0010VR:\u0010f\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0e0d8\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\bf\u0010g\u0012\u0004\bh\u0010NR\u0016\u0010i\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\bi\u0010VR\u0016\u0010j\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010l\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bl\u0010kR\u0016\u0010n\u001a\u00020m8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bp\u0010oR\u0016\u0010q\u001a\u00020\u00188\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bq\u0010VR\u0016\u0010r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\br\u0010kR\u0016\u0010s\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bs\u0010kR\u0016\u0010t\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bt\u0010kR\u0016\u0010u\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bu\u0010kR\u0016\u0010v\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bv\u0010kR\u0016\u0010w\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bw\u0010kR\u0016\u0010x\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bx\u0010kR\u0016\u0010y\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\by\u0010kR\u0016\u0010z\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bz\u0010kR\u0016\u0010{\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b{\u0010kR\u0016\u0010|\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b|\u0010}R\u0016\u0010~\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010PR\u0018\u0010\u0087\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010PR\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u008e\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010VR\u0018\u0010\u008f\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010VR\u0018\u0010\u0090\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010V¨\u0006\u0093\u0001"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceInfoManager;", "Lcom/baidu/searchbox/common/security/IDeviceInfoService;", "ipcService", "", "checkIPCService", "(Lcom/baidu/searchbox/common/security/IDeviceInfoService;)Z", "", "data", "gZip", "([B)[B", "Landroid/content/Context;", "context", "", "scene", "purpose", "Lcom/baidu/searchbox/common/security/DeviceIdBag;", "getAndroidId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/common/security/DeviceIdBag;", "Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost;", "getAppHost", "()Lcom/baidu/searchbox/common/security/IDeviceInfoAppHost;", "getContext$lib_security_framework_release", "()Landroid/content/Context;", "getContext", "", "deviceFlag", "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", CommonTbJsBridge.GET_DEVICE_INFO, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "forceApi", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IZ)Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "value", "getEncodeValue", "(Ljava/lang/String;)Ljava/lang/String;", "getHarmonyVersion", "getIMEI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Lcom/baidu/searchbox/common/security/DeviceIdBag;", "", "getLastForceSyncCacheTime", "(Landroid/content/Context;)J", "getMacAddress", "getManufacturer", "(Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/searchbox/common/security/DeviceIdBag;", "getModel", "getOAID", "getOperator", "getOsVersion", "hasLaunchMappingDone", "(Landroid/content/Context;)Z", "", "init", "(I)V", "postSyncTask", "appContext", "needSupportMultiProcess", "preInit", "(Landroid/content/Context;Z)V", "readAndroidId", "readHarmonyVersion", "readIMEI", "readMac", "readManufacturer", "readMappingCache", "(Landroid/content/Context;)V", "readModel", "readOAID", "readOperator", "readOsVersion", "saveForceSyncCacheTime", "saveLaunchMappingDone", "setContextAndIPC", "Lorg/json/JSONObject;", "infoJson", "syncMapping", "(Lorg/json/JSONObject;)Z", "syncMappingOfFixedDeviceFlag", "(I)Z", "writeMappingCache", "()V", "DEBUG", "Z", "com/baidu/searchbox/common/security/DeviceInfoManager$DEFAULT_APP_HOST$1", "DEFAULT_APP_HOST", "Lcom/baidu/searchbox/common/security/DeviceInfoManager$DEFAULT_APP_HOST$1;", "getDEFAULT_APP_HOST$annotations", "DEFAULT_PHONE_TYPE", "I", "DEVICE_ALL", "DEVICE_ANDROID_ID", "DEVICE_FLAG_BIT_NUM", "DEVICE_HARMONY_VERSION", "DEVICE_IMEI", "DEVICE_MAC", "DEVICE_MANUFACTURER", "DEVICE_MODEL", "DEVICE_NONE", "DEVICE_NON_SENSITIVE", "DEVICE_OAID", "DEVICE_OPERATOR", "DEVICE_OS_VERSION", "Landroid/util/SparseArray;", "Lkotlin/Function3;", "DEVICE_READ_FUNC_MAP", "Landroid/util/SparseArray;", "getDEVICE_READ_FUNC_MAP$annotations", "DEVICE_VALUABLE", "ERRNO", "Ljava/lang/String;", "ERRNO_SUCCESS", "", "GZIP_HEAD_1", "B", "GZIP_HEAD_2", "HTTP_STATUS_OK", "MAPPING_CACHE_FILE", "MAPPING_URL", "PURPOSE_LAUNCH_SYNC", "SCENE_LAUNCH", "SDK_DIR", "SP_FILE", "SP_KEY_FORCE_SYNC_CACHE_TIME", "SP_KEY_LAUNCH_SYNC_DONE", "SYNC_JSON_KEY_TIME", "TAG", "mContext", "Landroid/content/Context;", "mDeviceInfoMap", "Lcom/baidu/searchbox/common/security/DeviceIdBagMap;", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "Landroid/os/HandlerThread;", "mHandlerThread", "Landroid/os/HandlerThread;", "mInit", "mLaunchSyncStarted", "Lcom/baidu/searchbox/common/security/CacheDeviceInfo;", "mMappingCache", "Lcom/baidu/searchbox/common/security/CacheDeviceInfo;", "Ljava/io/File;", "mMappingCacheFile", "Ljava/io/File;", "mPhoneTypeWhenReadIMEI", "mPhoneTypeWhenReadOperator", "mSyncingDeviceFlag", "<init>", "SyncTask", "lib-security-framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DeviceInfoManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final DeviceInfoManager$DEFAULT_APP_HOST$1 DEFAULT_APP_HOST;
    public static final int DEFAULT_PHONE_TYPE = 0;
    public static final int DEVICE_ALL = 511;
    public static final int DEVICE_ANDROID_ID = 4;
    public static final int DEVICE_FLAG_BIT_NUM = 9;
    public static final int DEVICE_HARMONY_VERSION = 128;
    public static final int DEVICE_IMEI = 2;
    public static final int DEVICE_MAC = 1;
    public static final int DEVICE_MANUFACTURER = 256;
    public static final int DEVICE_MODEL = 16;
    public static final int DEVICE_NONE = 0;
    public static final int DEVICE_NON_SENSITIVE = 496;
    public static final int DEVICE_OAID = 8;
    public static final int DEVICE_OPERATOR = 64;
    public static final int DEVICE_OS_VERSION = 32;
    public static final SparseArray DEVICE_READ_FUNC_MAP;
    public static final int DEVICE_VALUABLE = 66;
    public static final String ERRNO = "errno";
    public static final String ERRNO_SUCCESS = "0";
    public static final byte GZIP_HEAD_1 = 117;
    public static final byte GZIP_HEAD_2 = 123;
    public static final int HTTP_STATUS_OK = 200;
    public static final DeviceInfoManager INSTANCE;
    public static final String MAPPING_CACHE_FILE = "device_info_sdk/sync_mapping";
    public static final String MAPPING_URL = "https://mbd.baidu.com/mapping/update";
    public static final String PURPOSE_LAUNCH_SYNC = "launch_sync";
    public static final String SCENE_LAUNCH = "launch";
    public static final String SDK_DIR = "device_info_sdk";
    public static final String SP_FILE = "device_info_sdk";
    public static final String SP_KEY_FORCE_SYNC_CACHE_TIME = "force_sync_cache_time";
    public static final String SP_KEY_LAUNCH_SYNC_DONE = "launch_sync_done";
    public static final String SYNC_JSON_KEY_TIME = "j";
    public static final String TAG = "DeviceInfoManager";
    public static Context mContext;
    public static DeviceIdBagMap mDeviceInfoMap;
    public static Handler mHandler;
    public static final HandlerThread mHandlerThread;
    public static boolean mInit;
    public static boolean mLaunchSyncStarted;
    public static CacheDeviceInfo mMappingCache;
    public static File mMappingCacheFile;
    public static int mPhoneTypeWhenReadIMEI;
    public static int mPhoneTypeWhenReadOperator;
    public static int mSyncingDeviceFlag;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    public static /* synthetic */ void getDEFAULT_APP_HOST$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDEVICE_READ_FUNC_MAP$annotations() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/common/security/DeviceInfoManager$SyncTask;", "Ljava/lang/Runnable;", "", "run", "()V", "", "deviceFlag", "I", "getDeviceFlag", "()I", "<init>", "(I)V", "lib-security-framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public final class SyncTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int deviceFlag;

        public SyncTask(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.deviceFlag = i;
        }

        public final int getDeviceFlag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.deviceFlag;
            }
            return invokeV.intValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                if (!DeviceInfoManager.mLaunchSyncStarted) {
                    return;
                }
                DeviceInfoManager deviceInfoManager2 = DeviceInfoManager.INSTANCE;
                DeviceInfoManager.mSyncingDeviceFlag = this.deviceFlag;
                try {
                    DeviceInfoManager.INSTANCE.syncMappingOfFixedDeviceFlag(this.deviceFlag);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    DeviceInfoManager deviceInfoManager3 = DeviceInfoManager.INSTANCE;
                    DeviceInfoManager.mSyncingDeviceFlag = 0;
                    throw th;
                }
                DeviceInfoManager deviceInfoManager4 = DeviceInfoManager.INSTANCE;
                DeviceInfoManager.mSyncingDeviceFlag = 0;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.searchbox.common.security.DeviceInfoManager$DEFAULT_APP_HOST$1] */
    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-107786217, "Lcom/baidu/searchbox/common/security/DeviceInfoManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-107786217, "Lcom/baidu/searchbox/common/security/DeviceInfoManager;");
                return;
            }
        }
        INSTANCE = new DeviceInfoManager();
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$1.INSTANCE);
        sparseArray.put(2, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$2.INSTANCE);
        sparseArray.put(4, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$3.INSTANCE);
        sparseArray.put(8, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$4.INSTANCE);
        sparseArray.put(16, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$5.INSTANCE);
        sparseArray.put(32, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$6.INSTANCE);
        sparseArray.put(64, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$7.INSTANCE);
        sparseArray.put(128, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$8.INSTANCE);
        sparseArray.put(256, DeviceInfoManager$DEVICE_READ_FUNC_MAP$1$9.INSTANCE);
        DEVICE_READ_FUNC_MAP = sparseArray;
        mDeviceInfoMap = new DeviceIdBagMap();
        mHandlerThread = new HandlerThread(TAG);
        DEFAULT_APP_HOST = new IDeviceInfoAppHost() { // from class: com.baidu.searchbox.common.security.DeviceInfoManager$DEFAULT_APP_HOST$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public String getAppName() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.getAppName(this);
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public String getEnUid() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.getEnUid(this);
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public long getForceMappingCacheInterval() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.getForceMappingCacheInterval(this);
                }
                return invokeV.longValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public IDeviceInfoAppHost.OAIDResult getOAID() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.getOAID(this);
                }
                return (IDeviceInfoAppHost.OAIDResult) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public String getUA() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.getUA(this);
                }
                return (String) invokeV.objValue;
            }

            @Override // com.baidu.searchbox.common.security.IDeviceInfoAppHost
            public boolean useMapping() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return IDeviceInfoAppHost.DefaultImpls.useMapping(this);
                }
                return invokeV.booleanValue;
            }
        };
    }

    public DeviceInfoManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IDeviceInfoAppHost getAppHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            return vi8.a();
        }
        return (IDeviceInfoAppHost) invokeV.objValue;
    }

    public final Context getContext$lib_security_framework_release() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context context = mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            }
            return context;
        }
        return (Context) invokeV.objValue;
    }

    public static final /* synthetic */ Context access$getMContext$p(DeviceInfoManager deviceInfoManager) {
        Context context = mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        return context;
    }

    private final boolean checkIPCService(IDeviceInfoService iDeviceInfoService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, iDeviceInfoService)) == null) {
            if (iDeviceInfoService != null && !(iDeviceInfoService instanceof IDeviceInfoService.Stub)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private final String getEncodeValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, this, str)) == null) {
            try {
                String encode = URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
                Intrinsics.checkNotNullExpressionValue(encode, "URLEncoder.encode(value, \"utf-8\")");
                return encode;
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getLastForceSyncCacheTime(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, this, context)) == null) {
            return context.getSharedPreferences("device_info_sdk", 0).getLong(SP_KEY_FORCE_SYNC_CACHE_TIME, Long.MIN_VALUE);
        }
        return invokeL.longValue;
    }

    private final void postSyncTask(int i) {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65574, this, i) == null) && ((~mSyncingDeviceFlag) & i) != 0 && (handler = mHandler) != null) {
            handler.post(new SyncTask(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveForceSyncCacheTime(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65584, this, context) == null) {
            context.getSharedPreferences("device_info_sdk", 0).edit().putLong(SP_KEY_FORCE_SYNC_CACHE_TIME, System.currentTimeMillis()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveLaunchMappingDone(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65585, this, context) == null) {
            context.getSharedPreferences("device_info_sdk", 0).edit().putBoolean(SP_KEY_LAUNCH_SYNC_DONE, true).apply();
        }
    }

    public final boolean hasLaunchMappingDone(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getSharedPreferences("device_info_sdk", 0).getBoolean(SP_KEY_LAUNCH_SYNC_DONE, false);
        }
        return invokeL.booleanValue;
    }

    public final void setContextAndIPC(Context appContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, appContext, z) == null) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            mContext = appContext;
            if (ve1.g() && z) {
                DeviceInfoIPCServiceManager.Companion.addIPCService();
            }
        }
    }

    public static /* synthetic */ void init$default(DeviceInfoManager deviceInfoManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 511;
        }
        deviceInfoManager.init(i);
    }

    public final DeviceIdBagMap getDeviceInfo(Context context, String scene, String purpose, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, context, scene, purpose, i)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            return getDeviceInfo(context, scene, purpose, i, false);
        }
        return (DeviceIdBagMap) invokeLLLI.objValue;
    }

    public final DeviceIdBag getIMEI(Context context, String scene, String purpose) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            return getIMEI(context, scene, purpose, false);
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    public final DeviceIdBag getOperator(Context context, String scene, String purpose) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, context, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            return getOperator(context, scene, purpose, false);
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    private final byte[] gZip(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, this, bArr)) == null) {
            byte[] bArr2 = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return bArr2;
            } catch (Exception e) {
                e.printStackTrace();
                return bArr2;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public final void init(final int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i) == null) && !mInit && getAppHost().useMapping()) {
            mInit = true;
            mHandlerThread.start();
            Handler handler = new Handler(mHandlerThread.getLooper());
            mHandler = handler;
            Intrinsics.checkNotNull(handler);
            handler.post(new Runnable(i) { // from class: com.baidu.searchbox.common.security.DeviceInfoManager$init$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ int $deviceFlag;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$deviceFlag = i;
                }

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iterateDeviceFlag", "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
                /* renamed from: com.baidu.searchbox.common.security.DeviceInfoManager$init$1$1  reason: invalid class name */
                /* loaded from: classes2.dex */
                public final class AnonymousClass1 extends Lambda implements Function1 {
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Ref.IntRef $diffFlag;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Ref.IntRef $finalDeviceFlag;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(Ref.IntRef intRef, Ref.IntRef intRef2) {
                        super(1);
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {intRef, intRef2};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$finalDeviceFlag = intRef;
                        this.$diffFlag = intRef2;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i) {
                        DeviceIdBagMap deviceIdBagMap;
                        CacheDeviceInfo cacheDeviceInfo;
                        SparseArray sparseArray;
                        DeviceIdBagMap deviceIdBagMap2;
                        Interceptable interceptable = $ic;
                        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (this.$finalDeviceFlag.element & i) != 0) {
                            DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                            deviceIdBagMap = DeviceInfoManager.mDeviceInfoMap;
                            DeviceIdBag deviceIdBag = (DeviceIdBag) deviceIdBagMap.get((Object) Integer.valueOf(i));
                            if (deviceIdBag == null) {
                                sparseArray = DeviceInfoManager.DEVICE_READ_FUNC_MAP;
                                ((Function3) sparseArray.get(i)).invoke(DeviceInfoManager.access$getMContext$p(DeviceInfoManager.INSTANCE), "launch", DeviceInfoManager.PURPOSE_LAUNCH_SYNC);
                                DeviceInfoManager deviceInfoManager2 = DeviceInfoManager.INSTANCE;
                                deviceIdBagMap2 = DeviceInfoManager.mDeviceInfoMap;
                                deviceIdBag = (DeviceIdBag) deviceIdBagMap2.get((Object) Integer.valueOf(i));
                            } else {
                                DeviceInfoManager deviceInfoManager3 = DeviceInfoManager.INSTANCE;
                                cacheDeviceInfo = DeviceInfoManager.mMappingCache;
                                if (DeviceInfoUtilKt.isDeviceInfoSyncMapping(cacheDeviceInfo, i, deviceIdBag.deviceId)) {
                                    deviceIdBag.errorCode = 3;
                                }
                            }
                            if (deviceIdBag != null && deviceIdBag.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag.deviceId)) {
                                Ref.IntRef intRef = this.$diffFlag;
                                intRef.element = i | intRef.element;
                            }
                        }
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() {
                    CacheDeviceInfo cacheDeviceInfo;
                    boolean z;
                    CacheDeviceInfo cacheDeviceInfo2;
                    long lastForceSyncCacheTime;
                    IDeviceInfoAppHost appHost;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Ref.IntRef intRef = new Ref.IntRef();
                        intRef.element = this.$deviceFlag;
                        DeviceInfoManager deviceInfoManager = DeviceInfoManager.INSTANCE;
                        cacheDeviceInfo = DeviceInfoManager.mMappingCache;
                        if (cacheDeviceInfo != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            DeviceInfoManager deviceInfoManager2 = DeviceInfoManager.INSTANCE;
                            lastForceSyncCacheTime = deviceInfoManager2.getLastForceSyncCacheTime(DeviceInfoManager.access$getMContext$p(deviceInfoManager2));
                            long abs = Math.abs(currentTimeMillis - lastForceSyncCacheTime);
                            appHost = DeviceInfoManager.INSTANCE.getAppHost();
                            if (abs > appHost.getForceMappingCacheInterval()) {
                                intRef.element = 511;
                                z = true;
                                Ref.IntRef intRef2 = new Ref.IntRef();
                                intRef2.element = 0;
                                DeviceInfoUtilKt.forEachDevice(new AnonymousClass1(intRef, intRef2));
                                DeviceInfoManager deviceInfoManager3 = DeviceInfoManager.INSTANCE;
                                DeviceInfoManager.mLaunchSyncStarted = true;
                                DeviceInfoManager deviceInfoManager4 = DeviceInfoManager.INSTANCE;
                                cacheDeviceInfo2 = DeviceInfoManager.mMappingCache;
                                if (cacheDeviceInfo2 != null) {
                                    if (DeviceInfoManager.INSTANCE.syncMappingOfFixedDeviceFlag(intRef2.element)) {
                                        DeviceInfoManager deviceInfoManager5 = DeviceInfoManager.INSTANCE;
                                        deviceInfoManager5.saveForceSyncCacheTime(DeviceInfoManager.access$getMContext$p(deviceInfoManager5));
                                        DeviceInfoManager deviceInfoManager6 = DeviceInfoManager.INSTANCE;
                                        if (!deviceInfoManager6.hasLaunchMappingDone(DeviceInfoManager.access$getMContext$p(deviceInfoManager6))) {
                                            DeviceInfoManager deviceInfoManager7 = DeviceInfoManager.INSTANCE;
                                            deviceInfoManager7.saveLaunchMappingDone(DeviceInfoManager.access$getMContext$p(deviceInfoManager7));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else if (z) {
                                    if (DeviceInfoManager.INSTANCE.syncMappingOfFixedDeviceFlag(511)) {
                                        DeviceInfoManager deviceInfoManager8 = DeviceInfoManager.INSTANCE;
                                        deviceInfoManager8.saveForceSyncCacheTime(DeviceInfoManager.access$getMContext$p(deviceInfoManager8));
                                        DeviceInfoManager deviceInfoManager9 = DeviceInfoManager.INSTANCE;
                                        if (!deviceInfoManager9.hasLaunchMappingDone(DeviceInfoManager.access$getMContext$p(deviceInfoManager9))) {
                                            DeviceInfoManager deviceInfoManager10 = DeviceInfoManager.INSTANCE;
                                            deviceInfoManager10.saveLaunchMappingDone(DeviceInfoManager.access$getMContext$p(deviceInfoManager10));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else {
                                    int i2 = intRef2.element;
                                    if (i2 != 0 && DeviceInfoManager.INSTANCE.syncMappingOfFixedDeviceFlag(i2)) {
                                        DeviceInfoManager deviceInfoManager11 = DeviceInfoManager.INSTANCE;
                                        if (!deviceInfoManager11.hasLaunchMappingDone(DeviceInfoManager.access$getMContext$p(deviceInfoManager11))) {
                                            DeviceInfoManager deviceInfoManager12 = DeviceInfoManager.INSTANCE;
                                            deviceInfoManager12.saveLaunchMappingDone(DeviceInfoManager.access$getMContext$p(deviceInfoManager12));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        z = false;
                        Ref.IntRef intRef22 = new Ref.IntRef();
                        intRef22.element = 0;
                        DeviceInfoUtilKt.forEachDevice(new AnonymousClass1(intRef, intRef22));
                        DeviceInfoManager deviceInfoManager32 = DeviceInfoManager.INSTANCE;
                        DeviceInfoManager.mLaunchSyncStarted = true;
                        DeviceInfoManager deviceInfoManager42 = DeviceInfoManager.INSTANCE;
                        cacheDeviceInfo2 = DeviceInfoManager.mMappingCache;
                        if (cacheDeviceInfo2 != null) {
                        }
                    }
                }
            });
        }
    }

    public static /* synthetic */ DeviceIdBagMap getDeviceInfo$default(DeviceInfoManager deviceInfoManager, Context context, String str, String str2, int i, boolean z, int i2, Object obj) {
        boolean z2;
        if ((i2 & 16) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        return deviceInfoManager.getDeviceInfo(context, str, str2, i, z2);
    }

    public static /* synthetic */ DeviceIdBag getIMEI$default(DeviceInfoManager deviceInfoManager, Context context, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return deviceInfoManager.getIMEI(context, str, str2, z);
    }

    public static /* synthetic */ DeviceIdBag getOperator$default(DeviceInfoManager deviceInfoManager, Context context, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return deviceInfoManager.getOperator(context, str, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readAndroidId(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65575, this, context, str, str2)) == null) {
            DeviceIdBag androidId = AndroidIDProxy.getAndroidId(context);
            int i = androidId.errorCode;
            if (i != -3 && i != -1) {
                DeviceIdBagMap deviceIdBagMap = mDeviceInfoMap;
                Intrinsics.checkNotNullExpressionValue(androidId, "this");
                deviceIdBagMap.put((DeviceIdBagMap) 4, (int) androidId);
                if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 4, androidId.deviceId)) {
                    androidId.errorCode = 3;
                }
            }
            Intrinsics.checkNotNullExpressionValue(androidId, "AndroidIDProxy.getAndroi…}\n            }\n        }");
            return androidId;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readHarmonyVersion(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65576, this, context, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            mDeviceInfoMap.put((DeviceIdBagMap) 128, (int) deviceIdBag);
            int i = 2;
            if (DeviceUtils.isHarmonyOS(context)) {
                String harmonyVersion = DeviceUtils.getHarmonyVersion();
                deviceIdBag.deviceId = harmonyVersion;
                if (!TextUtils.isEmpty(harmonyVersion)) {
                    if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 128, deviceIdBag.deviceId)) {
                        i = 3;
                    } else {
                        i = 0;
                    }
                }
                deviceIdBag.errorCode = i;
            } else {
                deviceIdBag.errorCode = 2;
            }
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readMac(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65578, this, context, str, str2)) == null) {
            DeviceIdBag hardwareAddress = HardwareProxy.getHardwareAddress(context);
            int i = hardwareAddress.errorCode;
            if (i != -3 && i != -1) {
                DeviceIdBagMap deviceIdBagMap = mDeviceInfoMap;
                Intrinsics.checkNotNullExpressionValue(hardwareAddress, "this");
                deviceIdBagMap.put((DeviceIdBagMap) 1, (int) hardwareAddress);
                if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 1, hardwareAddress.deviceId)) {
                    hardwareAddress.errorCode = 3;
                }
            }
            Intrinsics.checkNotNullExpressionValue(hardwareAddress, "HardwareProxy.getHardwar…}\n            }\n        }");
            return hardwareAddress;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readIMEI(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65577, this, context, str, str2)) == null) {
            DeviceIdBag imei = DeviceInfoProxy.getImei(context, false, true);
            int i = imei.errorCode;
            if (i != -3 && i != -2 && i != -1) {
                DeviceIdBagMap deviceIdBagMap = mDeviceInfoMap;
                Intrinsics.checkNotNullExpressionValue(imei, "this");
                deviceIdBagMap.put((DeviceIdBagMap) 2, (int) imei);
                if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 2, imei.deviceId)) {
                    imei.errorCode = 3;
                }
                try {
                    Object systemService = context.getSystemService("phone");
                    if (systemService != null) {
                        mPhoneTypeWhenReadIMEI = ((TelephonyManager) systemService).getPhoneType();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
                    }
                } catch (Exception unused) {
                }
            }
            Intrinsics.checkNotNullExpressionValue(imei, "DeviceInfoProxy.getImei(…}\n            }\n        }");
            return imei;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readOperator(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        int i;
        Object systemService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65582, this, context, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            try {
                systemService = context.getSystemService("phone");
            } catch (Exception unused) {
            }
            if (systemService != null) {
                TelephonyManager telephonyManager = (TelephonyManager) systemService;
                deviceIdBag.deviceId = telephonyManager.getSimOperator();
                mDeviceInfoMap.put((DeviceIdBagMap) 64, (int) deviceIdBag);
                mPhoneTypeWhenReadOperator = telephonyManager.getPhoneType();
                if (TextUtils.isEmpty(deviceIdBag.deviceId)) {
                    i = 2;
                } else if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 64, deviceIdBag.deviceId)) {
                    i = 3;
                } else {
                    i = 0;
                }
                deviceIdBag.errorCode = i;
                return deviceIdBag;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    public final DeviceIdBag getAndroidId(Context context, String scene, String purpose) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!ve1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag androidId = iPCService.getAndroidId(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(androidId, "ipcService!!.getAndroidId(scene, purpose)");
                        return androidId;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 4);
                if (deviceIdBag == null) {
                    return readAndroidId(context, scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 4);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readAndroidId(context, scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_AN…(context, scene, purpose)");
            if (getAppHost().useMapping() && deviceIdBag2.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag2.deviceId)) {
                postSyncTask(4);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    public final DeviceIdBag getHarmonyVersion(Context context, String scene, String purpose) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!ve1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag harmonyVersion = iPCService.getHarmonyVersion(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(harmonyVersion, "ipcService!!.getHarmonyVersion(scene, purpose)");
                        return harmonyVersion;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 128);
                if (deviceIdBag == null) {
                    return readHarmonyVersion(context, scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 128);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readHarmonyVersion(context, scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_HA…(context, scene, purpose)");
            if (deviceIdBag2.errorCode == 0) {
                postSyncTask(128);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    public final DeviceIdBag getMacAddress(Context context, String scene, String purpose) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!ve1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag macAddress = iPCService.getMacAddress(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(macAddress, "ipcService!!.getMacAddress(scene, purpose)");
                        return macAddress;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 1);
                if (deviceIdBag == null) {
                    return readMac(context, scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 1);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readMac(context, scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_MA…(context, scene, purpose)");
            if (getAppHost().useMapping() && deviceIdBag2.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag2.deviceId)) {
                postSyncTask(1);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readManufacturer(String str, String str2) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65579, this, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            mDeviceInfoMap.put((DeviceIdBagMap) 256, (int) deviceIdBag);
            String str3 = Build.MANUFACTURER;
            deviceIdBag.deviceId = str3;
            if (TextUtils.isEmpty(str3)) {
                i = 2;
            } else if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 256, deviceIdBag.deviceId)) {
                i = 3;
            } else {
                i = 0;
            }
            deviceIdBag.errorCode = i;
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readModel(String str, String str2) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65580, this, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            mDeviceInfoMap.put((DeviceIdBagMap) 16, (int) deviceIdBag);
            String str3 = Build.MODEL;
            deviceIdBag.deviceId = str3;
            if (TextUtils.isEmpty(str3)) {
                i = 2;
            } else if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 16, deviceIdBag.deviceId)) {
                i = 3;
            } else {
                i = 0;
            }
            deviceIdBag.errorCode = i;
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readOsVersion(String str, String str2) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65583, this, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            mDeviceInfoMap.put((DeviceIdBagMap) 32, (int) deviceIdBag);
            String str3 = Build.VERSION.RELEASE;
            deviceIdBag.deviceId = str3;
            if (TextUtils.isEmpty(str3)) {
                i = 2;
            } else if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 32, deviceIdBag.deviceId)) {
                i = 3;
            } else {
                i = 0;
            }
            deviceIdBag.errorCode = i;
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeviceIdBag readOAID(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65581, this, str, str2)) == null) {
            DeviceIdBag deviceIdBag = new DeviceIdBag();
            IDeviceInfoAppHost.OAIDResult oaid = INSTANCE.getAppHost().getOAID();
            int i = 2;
            if (oaid.getHasInit()) {
                mDeviceInfoMap.put((DeviceIdBagMap) 8, (int) deviceIdBag);
                deviceIdBag.deviceId = oaid.getOaid();
                deviceIdBag.encodedDeviceId = oaid.getEncodedOAID();
                if (!TextUtils.isEmpty(deviceIdBag.deviceId)) {
                    if (INSTANCE.getAppHost().useMapping() && DeviceInfoUtilKt.isDeviceInfoSyncMapping(mMappingCache, 8, deviceIdBag.deviceId)) {
                        i = 3;
                    } else {
                        i = 0;
                    }
                }
                deviceIdBag.errorCode = i;
            } else {
                deviceIdBag.errorCode = 2;
            }
            return deviceIdBag;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    public final DeviceIdBag getManufacturer(String scene, String purpose) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!ve1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag manufacturer = iPCService.getManufacturer(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(manufacturer, "ipcService!!.getManufacturer(scene, purpose)");
                        return manufacturer;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 256);
                if (deviceIdBag == null) {
                    return readManufacturer(scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 256);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readManufacturer(scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_MA…ufacturer(scene, purpose)");
            if (deviceIdBag2.errorCode == 0) {
                postSyncTask(256);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    public final DeviceIdBag getModel(String scene, String purpose) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!ve1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag model = iPCService.getModel(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(model, "ipcService!!.getModel(scene, purpose)");
                        return model;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 16);
                if (deviceIdBag == null) {
                    return readModel(scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 16);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readModel(scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_MO…readModel(scene, purpose)");
            if (deviceIdBag2.errorCode == 0) {
                postSyncTask(16);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    public final DeviceIdBag getOAID(String scene, String purpose) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!ve1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag oaid = iPCService.getOAID(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(oaid, "ipcService!!.getOAID(scene, purpose)");
                        return oaid;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 8);
                if (deviceIdBag == null) {
                    return readOAID(scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 8);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readOAID(scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_OA… readOAID(scene, purpose)");
            if (deviceIdBag2.errorCode == 0) {
                postSyncTask(8);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    public final DeviceIdBag getOsVersion(String scene, String purpose) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, scene, purpose)) == null) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!ve1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag osVersion = iPCService.getOsVersion(scene, purpose);
                        Intrinsics.checkNotNullExpressionValue(osVersion, "ipcService!!.getOsVersion(scene, purpose)");
                        return osVersion;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 32);
                if (deviceIdBag == null) {
                    return readOsVersion(scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 32);
            if (deviceIdBag2 == null) {
                deviceIdBag2 = readOsVersion(scene, purpose);
            }
            Intrinsics.checkNotNullExpressionValue(deviceIdBag2, "mDeviceInfoMap[DEVICE_OS…OsVersion(scene, purpose)");
            if (deviceIdBag2.errorCode == 0) {
                postSyncTask(32);
            }
            return deviceIdBag2;
        }
        return (DeviceIdBag) invokeLL.objValue;
    }

    public final void preInit(Context appContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, appContext, z) == null) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            mContext = appContext;
            if (!ve1.g()) {
                return;
            }
            if (z) {
                DeviceInfoIPCServiceManager.Companion.addIPCService();
            }
            if (getAppHost().useMapping()) {
                Context context = mContext;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                }
                File file = new File(context.getFilesDir(), MAPPING_CACHE_FILE);
                mMappingCacheFile = file;
                if (file == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                }
                if (!file.getParentFile().exists()) {
                    File file2 = mMappingCacheFile;
                    if (file2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                    }
                    file2.getParentFile().mkdirs();
                }
                File file3 = mMappingCacheFile;
                if (file3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                }
                if (file3.exists()) {
                    try {
                        File file4 = mMappingCacheFile;
                        if (file4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                        }
                        mMappingCache = new CacheDeviceInfo(FilesKt__FileReadWriteKt.readText$default(file4, null, 1, null));
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f8, code lost:
        if (r2 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fa, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x010d, code lost:
        if (0 != 0) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean syncMapping(JSONObject jSONObject) {
        InterceptResult invokeL;
        IDeviceInfoAppHost appHost;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, this, jSONObject)) == null) {
            if (jSONObject.length() == 0 || (appHost = getAppHost()) == DEFAULT_APP_HOST) {
                return false;
            }
            String str = "https://mbd.baidu.com/mapping/update?appname=" + getEncodeValue(appHost.getAppName()) + "&ua=" + getEncodeValue(appHost.getUA()) + "&uid=" + getEncodeValue(appHost.getEnUid());
            jSONObject.put("j", String.valueOf(System.currentTimeMillis()));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "infoJson.toString()");
            Charset charset = Charsets.UTF_8;
            if (jSONObject2 != null) {
                byte[] bytes = jSONObject2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                byte[] gZip = gZip(bytes);
                if (gZip != null && gZip.length >= 2) {
                    gZip[0] = 117;
                    gZip[1] = 123;
                    OutputStream outputStream = null;
                    try {
                        URLConnection openConnection = new URL(str).openConnection();
                        if (openConnection != null) {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setUseCaches(false);
                            outputStream = httpURLConnection.getOutputStream();
                            outputStream.write(gZip);
                            outputStream.flush();
                            if (httpURLConnection.getResponseCode() == 200) {
                                InputStream inputStream = httpURLConnection.getInputStream();
                                Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                                if (inputStream instanceof BufferedInputStream) {
                                    bufferedInputStream = (BufferedInputStream) inputStream;
                                } else {
                                    bufferedInputStream = new BufferedInputStream(inputStream, 8192);
                                }
                                String readText = TextStreamsKt.readText(new InputStreamReader(bufferedInputStream, Charsets.UTF_8));
                                if (!TextUtils.isEmpty(readText) && Intrinsics.areEqual(new JSONObject(readText).optString("errno", ""), "0")) {
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    return true;
                                }
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                        }
                    } catch (Exception unused2) {
                    } catch (Throwable th) {
                        if (0 != 0) {
                            try {
                                outputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                }
                return false;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean syncMappingOfFixedDeviceFlag(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65587, this, i)) == null) {
            if (mSyncingDeviceFlag == 0 && mLaunchSyncStarted && i != 0) {
                try {
                    ArrayList<Number> arrayList = new ArrayList();
                    if (syncMapping(DeviceInfoUtilKt.toJson(mDeviceInfoMap, i, arrayList))) {
                        if (mMappingCache == null) {
                            mMappingCache = new CacheDeviceInfo();
                        }
                        int i2 = 0;
                        for (Number number : arrayList) {
                            int intValue = number.intValue();
                            i2 |= intValue;
                            DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) Integer.valueOf(intValue));
                            if (deviceIdBag != null) {
                                deviceIdBag.errorCode = 3;
                            }
                        }
                        DeviceIdBagMap deviceIdBagMap = mDeviceInfoMap;
                        CacheDeviceInfo cacheDeviceInfo = mMappingCache;
                        Intrinsics.checkNotNull(cacheDeviceInfo);
                        DeviceInfoUtilKt.copyFixedInfo(deviceIdBagMap, cacheDeviceInfo, i2);
                        writeMappingCache();
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void readMappingCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            mContext = context;
            if (ve1.g() && getAppHost().useMapping()) {
                Context context2 = mContext;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                }
                File file = new File(context2.getFilesDir(), MAPPING_CACHE_FILE);
                mMappingCacheFile = file;
                if (file == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                }
                if (!file.getParentFile().exists()) {
                    File file2 = mMappingCacheFile;
                    if (file2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                    }
                    file2.getParentFile().mkdirs();
                }
                File file3 = mMappingCacheFile;
                if (file3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                }
                if (file3.exists()) {
                    try {
                        File file4 = mMappingCacheFile;
                        if (file4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                        }
                        mMappingCache = new CacheDeviceInfo(FilesKt__FileReadWriteKt.readText$default(file4, null, 1, null));
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private final void writeMappingCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65588, this) == null) {
            File file = mMappingCacheFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
            }
            if (file.exists()) {
                File file2 = mMappingCacheFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
                }
                file2.delete();
            }
            File file3 = mMappingCacheFile;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
            }
            file3.createNewFile();
            File file4 = mMappingCacheFile;
            if (file4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMappingCacheFile");
            }
            FilesKt__FileReadWriteKt.writeText$default(file4, String.valueOf(mMappingCache), null, 2, null);
        }
    }

    public final DeviceIdBagMap getDeviceInfo(Context context, String scene, String purpose, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{context, scene, purpose, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!ve1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        try {
                            DeviceIdBagMap deviceInfos = iPCService.getDeviceInfos(scene, purpose, i, z);
                            Intrinsics.checkNotNullExpressionValue(deviceInfos, "ipcService!!.getDeviceIn…se, deviceFlag, forceApi)");
                            return deviceInfos;
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                    }
                }
                DeviceIdBagMap deviceIdBagMap = new DeviceIdBagMap();
                DeviceInfoUtilKt.forEachDevice(new DeviceInfoManager$getDeviceInfo$$inlined$apply$lambda$1(deviceIdBagMap, i, z, context, scene, purpose));
                return deviceIdBagMap;
            }
            boolean useMapping = getAppHost().useMapping();
            DeviceIdBagMap deviceIdBagMap2 = new DeviceIdBagMap();
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            DeviceInfoUtilKt.forEachDevice(new DeviceInfoManager$getDeviceInfo$$inlined$apply$lambda$2(deviceIdBagMap2, new Ref.ObjectRef(), intRef, i, z, context, scene, purpose, useMapping));
            int i2 = intRef.element;
            if (i2 != 0) {
                INSTANCE.postSyncTask(i2);
            }
            return deviceIdBagMap2;
        }
        return (DeviceIdBagMap) invokeCommon.objValue;
    }

    public final DeviceIdBag getIMEI(Context context, String scene, String purpose, boolean z) {
        InterceptResult invokeCommon;
        Object systemService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{context, scene, purpose, Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!ve1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag imei = iPCService.getIMEI(scene, purpose, z);
                        Intrinsics.checkNotNullExpressionValue(imei, "ipcService!!.getIMEI(scene, purpose, forceApi)");
                        return imei;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 2);
                if (z || deviceIdBag == null) {
                    return readIMEI(context, scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 2);
            int i = 0;
            try {
                systemService = context.getSystemService("phone");
            } catch (Exception unused2) {
            }
            if (systemService != null) {
                i = ((TelephonyManager) systemService).getPhoneType();
                if (z || deviceIdBag2 == null || mPhoneTypeWhenReadIMEI != i) {
                    deviceIdBag2 = readIMEI(context, scene, purpose);
                }
                if (getAppHost().useMapping() && deviceIdBag2.errorCode != 3 && !TextUtils.isEmpty(deviceIdBag2.deviceId)) {
                    postSyncTask(2);
                }
                return deviceIdBag2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        return (DeviceIdBag) invokeCommon.objValue;
    }

    public final DeviceIdBag getOperator(Context context, String scene, String purpose, boolean z) {
        InterceptResult invokeCommon;
        Object systemService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{context, scene, purpose, Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (!ve1.g()) {
                IDeviceInfoService iPCService = DeviceInfoIPCServiceManager.Companion.getIPCService();
                if (checkIPCService(iPCService)) {
                    try {
                        Intrinsics.checkNotNull(iPCService);
                        DeviceIdBag operator = iPCService.getOperator(scene, purpose, z);
                        Intrinsics.checkNotNullExpressionValue(operator, "ipcService!!.getOperator(scene, purpose, forceApi)");
                        return operator;
                    } catch (Exception unused) {
                    }
                }
                DeviceIdBag deviceIdBag = (DeviceIdBag) mDeviceInfoMap.get((Object) 64);
                if (z || deviceIdBag == null) {
                    return readOperator(context, scene, purpose);
                }
                return deviceIdBag;
            }
            DeviceIdBag deviceIdBag2 = (DeviceIdBag) mDeviceInfoMap.get((Object) 64);
            int i = 0;
            try {
                systemService = context.getSystemService("phone");
            } catch (Exception unused2) {
            }
            if (systemService != null) {
                i = ((TelephonyManager) systemService).getPhoneType();
                if (z || deviceIdBag2 == null || mPhoneTypeWhenReadOperator != i) {
                    deviceIdBag2 = readOperator(context, scene, purpose);
                }
                if (deviceIdBag2.errorCode == 0) {
                    postSyncTask(64);
                }
                return deviceIdBag2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
        }
        return (DeviceIdBag) invokeCommon.objValue;
    }
}
