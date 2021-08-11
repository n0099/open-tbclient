package com.baidu.mobads.container.util.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import dalvik.system.InMemoryDexClassLoader;
import io.flutter.plugin.common.StandardMessageCodec;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes5.dex */
public class HuaWeiOAID {
    public static /* synthetic */ Interceptable $ic;
    public static boolean hwTrackLimited;
    public static byte[] hwoaid;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1377530669, "Lcom/baidu/mobads/container/util/oaid/HuaWeiOAID;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1377530669, "Lcom/baidu/mobads/container/util/oaid/HuaWeiOAID;");
                return;
            }
        }
        hwoaid = new byte[]{100, Constants.SHORT_PING_CMD_TYPE, 120, 10, 48, 51, 53, 0, -86, 63, -11, 20, 70, -5, -109, -97, 89, -91, -40, -13, 18, 90, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 21, -57, 20, 31, 110, 4, 77, 83, 43, -4, 13, 0, 0, 112, 0, 0, 0, 120, 86, 52, 18, 0, 0, 0, 0, 0, 0, 0, 0, 44, 13, 0, 0, 68, 0, 0, 0, 112, 0, 0, 0, 17, 0, 0, 0, ByteCompanionObject.MIN_VALUE, 1, 0, 0, 13, 0, 0, 0, -60, 1, 0, 0, 5, 0, 0, 0, 96, 2, 0, 0, 32, 0, 0, 0, -120, 2, 0, 0, 3, 0, 0, 0, -120, 3, 0, 0, 20, 10, 0, 0, -24, 3, 0, 0, -120, 7, 0, 0, -112, 7, 0, 0, -100, 7, 0, 0, -97, 7, 0, 0, -94, 7, 0, 0, -90, 7, 0, 0, -69, 7, 0, 0, -47, 7, 0, 0, -22, 7, 0, 0, -1, 7, 0, 0, 29, 8, 0, 0, 97, 8, 0, 0, -97, 8, 0, 0, -40, 8, 0, 0, -4, 8, 0, 0, 28, 9, 0, 0, 63, 9, 0, 0, 91, 9, 0, 0, 111, 9, 0, 0, -125, 9, 0, 0, -91, 9, 0, 0, -84, 9, 0, 0, -78, 9, 0, 0, -57, 9, 0, 0, -35, 9, 0, 0, -3, 9, 0, 0, 0, 10, 0, 0, 4, 10, 0, 0, 8, 10, 0, 0, 13, 10, 0, 0, 16, 10, 0, 0, 23, 10, 0, 0, 30, 10, 0, 0, 38, 10, 0, 0, 47, 10, 0, 0, 60, 10, 0, 0, 70, 10, 0, 0, 83, 10, 0, 0, 100, 10, 0, 0, 106, 10, 0, 0, -95, 10, 0, 0, -89, 10, 0, 0, -77, 10, 0, 0, -59, 10, 0, 0, -52, 10, 0, 0, -28, 10, 0, 0, -19, 10, 0, 0, -9, 10, 0, 0, -4, 10, 0, 0, 16, 11, 0, 0, 25, 11, 0, 0, 31, 11, 0, 0, 36, 11, 0, 0, 44, 11, 0, 0, 56, 11, 0, 0, 77, 11, 0, 0, 92, 11, 0, 0, Constants.SHORT_PING_CMD_TYPE, 11, 0, 0, 113, 11, 0, 0, 122, 11, 0, 0, -126, 11, 0, 0, -119, 11, 0, 0, -113, 11, 0, 0, -103, 11, 0, 0, -96, 11, 0, 0, -86, 11, 0, 0, -65, 11, 0, 0, -47, 11, 0, 0, 2, 0, 0, 0, 5, 0, 0, 0, 6, 0, 0, 0, 7, 0, 0, 0, 8, 0, 0, 0, 9, 0, 0, 0, 10, 0, 0, 0, 11, 0, 0, 0, StandardMessageCodec.LIST, 0, 0, 0, 13, 0, 0, 0, 14, 0, 0, 0, 15, 0, 0, 0, 16, 0, 0, 0, 17, 0, 0, 0, 18, 0, 0, 0, 25, 0, 0, 0, 29, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 3, 0, 0, 0, 92, 7, 0, 0, 3, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 8, 0, 0, 0, 100, 7, 0, 0, 3, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 15, 0, 0, 0, 108, 7, 0, 0, 27, 0, 0, 0, 15, 0, 0, 0, 100, 7, 0, 0, 28, 0, 0, 0, 15, 0, 0, 0, 116, 7, 0, 0, 27, 0, 0, 0, 15, 0, 0, 0, 92, 7, 0, 0, 29, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 16, 0, 0, 0, 124, 7, 0, 0, 6, 0, 2, 0, 49, 0, 0, 0, 7, 0, 14, 0, 1, 0, 0, 0, 7, 0, 0, 0, 22, 0, 0, 0, 7, 0, 0, 0, 23, 0, 0, 0, 7, 0, 0, 0, 24, 0, 0, 0, 1, 0, 6, 0, 0, 0, 0, 0, 1, 0, StandardMessageCodec.LIST, 0, 53, 0, 0, 0, 2, 0, 2, 0, 54, 0, 0, 0, 2, 0, StandardMessageCodec.LIST, 0, 62, 0, 0, 0, 4, 0, 10, 0, 42, 0, 0, 0, 4, 0, 3, 0, 52, 0, 0, 0, 4, 0, 6, 0, 55, 0, 0, 0, 4, 0, 0, 0, 56, 0, 0, 0, 4, 0, 5, 0, 57, 0, 0, 0, 4, 0, 6, 0, 58, 0, 0, 0, 4, 0, 7, 0, 64, 0, 0, 0, 4, 0, 10, 0, 65, 0, 0, 0, 4, 0, 6, 0, 66, 0, 0, 0, 4, 0, 10, 0, 67, 0, 0, 0, 6, 0, 8, 0, 0, 0, 0, 0, 6, 0, 1, 0, Base64.INTERNAL_PADDING, 0, 0, 0, 6, 0, 5, 0, 44, 0, 0, 0, 6, 0, 5, 0, UtilsBlink.VER_TYPE_SEPARATOR, 0, 0, 0, 6, 0, 5, 0, 46, 0, 0, 0, 6, 0, 11, 0, 48, 0, 0, 0, 7, 0, 6, 0, 0, 0, 0, 0, 7, 0, 1, 0, Base64.INTERNAL_PADDING, 0, 0, 0, 7, 0, 4, 0, 36, 0, 0, 0, 7, 0, 9, 0, 37, 0, 0, 0, 7, 0, 5, 0, UtilsBlink.VER_TYPE_SEPARATOR, 0, 0, 0, 7, 0, 5, 0, 46, 0, 0, 0, 7, 0, 11, 0, 48, 0, 0, 0, 7, 0, StandardMessageCodec.LIST, 0, 53, 0, 0, 0, 8, 0, 5, 0, UtilsBlink.VER_TYPE_SEPARATOR, 0, 0, 0, 8, 0, 5, 0, 46, 0, 0, 0, 8, 0, 11, 0, 48, 0, 0, 0, 13, 0, 6, 0, 0, 0, 0, 0, 8, 0, 0, 0, 1, 6, 0, 0, 13, 0, 0, 0, 76, 7, 0, 0, 19, 0, 0, 0, -28, 6, 0, 0, -37, StandardMessageCodec.LIST, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0, 84, 7, 0, 0, 19, 0, 0, 0, StandardMessageCodec.LIST, 7, 0, 0, -21, StandardMessageCodec.LIST, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 1, 4, 0, 0, 1, 0, 0, 0, 84, 7, 0, 0, 19, 0, 0, 0, 52, 7, 0, 0, 11, 13, 0, 0, -46, StandardMessageCodec.LIST, 0, 0, 
        1, 0, 0, 0, -101, StandardMessageCodec.LIST, 0, 0, 1, 0, 0, 0, -93, StandardMessageCodec.LIST, 0, 0, 2, 0, 0, 0, -85, StandardMessageCodec.LIST, 0, 0, -79, StandardMessageCodec.LIST, 0, 0, 3, 0, 0, 0, -70, StandardMessageCodec.LIST, 0, 0, -64, StandardMessageCodec.LIST, 0, 0, -54, StandardMessageCodec.LIST, 0, 0, 2, 0, 2, 0, 1, 0, 0, 0, -34, 11, 0, 0, 6, 0, 0, 0, 112, 16, 31, 0, 0, 0, 91, 1, 0, 0, 14, 0, 2, 0, 1, 0, 0, 0, 0, 0, -26, 11, 0, 0, 3, 0, 0, 0, 84, 16, 0, 0, 17, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 0, -21, 11, 0, 0, 3, 0, 0, 0, 26, 0, 39, 0, 17, 0, 0, 0, 7, 0, 1, 0, 5, 0, 1, 0, -16, 11, 0, 0, 42, 0, 0, 0, 113, 0, 5, 0, 0, 0, StandardMessageCodec.LIST, 0, 113, 0, 5, 0, 0, 0, StandardMessageCodec.LIST, 1, 26, 3, 39, 0, 110, 32, 11, 0, 48, 0, 84, 99, 0, 0, 18, 20, 18, 5, 114, 85, 3, 0, 67, 16, 110, 16, 6, 0, 1, 0, 110, 16, 8, 0, 1, 0, StandardMessageCodec.LIST, 2, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, 17, 2, 13, 3, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, 39, 3, 8, 0, 0, 0, 18, 0, 1, 0, 1, 0, 34, 0, 7, 0, 1, 0, 5, 0, 1, 0, 13, StandardMessageCodec.LIST, 0, 0, 42, 0, 0, 0, 113, 0, 5, 0, 0, 0, StandardMessageCodec.LIST, 0, 113, 0, 5, 0, 0, 0, StandardMessageCodec.LIST, 1, 26, 3, 39, 0, 110, 32, 11, 0, 48, 0, 84, 99, 0, 0, 18, 52, 18, 5, 114, 85, 3, 0, 67, 16, 110, 16, 6, 0, 1, 0, 110, 16, 8, 0, 1, 0, StandardMessageCodec.LIST, 2, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, 17, 2, 13, 3, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, 39, 3, 8, 0, 0, 0, 18, 0, 1, 0, 1, 0, 34, 0, 7, 0, 1, 0, 5, 0, 1, 0, 43, StandardMessageCodec.LIST, 0, 0, 46, 0, 0, 0, 18, 2, 113, 0, 5, 0, 0, 0, StandardMessageCodec.LIST, 0, 113, 0, 5, 0, 0, 0, StandardMessageCodec.LIST, 1, 26, 3, 39, 0, 110, 32, 11, 0, 48, 0, 84, 99, 0, 0, 18, 36, 18, 5, 114, 85, 3, 0, 67, 16, 110, 16, 6, 0, 1, 0, 110, 16, 7, 0, 1, 0, 10, 3, 56, 3, 3, 0, 18, 18, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, 15, 2, 13, 3, 110, 16, 9, 0, 1, 0, 110, 16, 9, 0, 0, 0, 39, 3, 9, 0, 0, 0, 18, 0, 1, 0, 1, 0, 38, 0, 2, 0, 1, 0, 3, 0, 0, 0, 72, StandardMessageCodec.LIST, 0, 0, 9, 0, 0, 0, 112, 16, 0, 0, 1, 0, 26, 0, 39, 0, 110, 48, 23, 0, 17, 0, 14, 0, 0, 0, 3, 0, 1, 0, 2, 0, 0, 0, 79, StandardMessageCodec.LIST, 0, 0, 25, 0, 0, 0, 57, 2, 4, 0, 18, 0, 17, 0, 26, 1, 39, 0, 114, 32, 2, 0, 18, 0, StandardMessageCodec.LIST, 0, 56, 0, 9, 0, 32, 1, 8, 0, 56, 1, 5, 0, 31, 0, 8, 0, 40, -15, 34, 0, 6, 0, 112, 32, 14, 0, 32, 0, 40, -21, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 99, StandardMessageCodec.LIST, 0, 0, 1, 0, 0, 0, 17, 0, 0, 0, 9, 0, 5, 0, 5, 0, 0, 0, 104, StandardMessageCodec.LIST, 0, 0, 80, 0, 0, 0, 18, 19, 26, 1, 39, 0, 44, 5, 59, 0, 0, 0, 111, 88, 1, 0, 84, 118, 10, 3, 15, 3, 110, 32, 13, 0, 23, 0, 40, -4, 110, 32, 4, 0, 22, 0, 110, 16, 24, 0, 4, 0, StandardMessageCodec.LIST, 0, 110, 16, StandardMessageCodec.LIST, 0, 7, 0, 110, 32, 13, 0, 7, 0, 40, -18, 110, 32, 4, 0, 22, 0, 110, 16, 26, 0, 4, 0, 10, 0, 110, 16, StandardMessageCodec.LIST, 0, 7, 0, 56, 0, 7, 0, 1, 50, 110, 32, 10, 0, 39, 0, 40, -35, 18, 2, 40, -5, 110, 32, 4, 0, 22, 0, 110, 16, 25, 0, 4, 0, StandardMessageCodec.LIST, 0, 110, 16, StandardMessageCodec.LIST, 0, 7, 0, 110, 32, 13, 0, 7, 0, 40, -51, 0, 2, 4, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 70, 84, 78, 95, StandardMessageCodec.LIST, 0, 0, 0, 26, 0, 0, 0, UtilsBlink.VER_TYPE_SEPARATOR, 0, 0, 0, 8, 0, 0, 0, -24, 3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 28, 0, 0, 0, -16, 3, 0, 0, 29, 0, 0, 0, -16, 3, 0, 0, 30, 0, 0, 0, -16, 3, 0, 0, -8, 3, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 17, 0, 0, 0, -16, 3, 0, 0, 18, 0, 0, 0, -16, 3, 0, 0, 19, 0, 0, 0, -16, 3, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 27, 0, 0, 0, -16, 3, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0, 0, 8, 0, 0, 0, 1, 0, 0, 0, 14, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 3, 0, 14, 0, 4, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 6, 60, 105, 110, 105, 116, 62, 0, 10, 68, 69, 83, 67, 82, 73, 80, 84, 79, 82, 0, 1, 73, 0, 1, 76, 0, 2, 76, 76, 0, 19, 76, 97, 110, 100, 114, 111, 105, 100, 47, 111, 115, 47, 66, 105, 110, 100, Constants.SHORT_PING_CMD_TYPE, 114, 59, 0, 20, 76, 97, 110, 100, 114, 111, 105, 100, 47, 111, 115, 47, 73, 66, 105, 110, 100, Constants.SHORT_PING_CMD_TYPE, 114, 59, 
        0, 23, 76, 97, 110, 100, 114, 111, 105, 100, 47, 111, 115, 47, 73, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 59, 0, 19, 76, 97, 110, 100, 114, 111, 105, 100, 47, 111, 115, 47, 80, 97, 114, 99, Constants.SHORT_PING_CMD_TYPE, 108, 59, 0, 28, 76, 97, 110, 100, 114, 111, 105, 100, 47, 111, 115, 47, 82, Constants.SHORT_PING_CMD_TYPE, 109, 111, 116, Constants.SHORT_PING_CMD_TYPE, 69, 120, 99, Constants.SHORT_PING_CMD_TYPE, 112, 116, 105, 111, 110, 59, 0, 66, 76, 99, 111, 109, 47, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 111, 100, 105, 115, 47, 111, 112, Constants.SHORT_PING_CMD_TYPE, 110, 100, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 47, 97, 105, 100, 108, 47, 79, 112, Constants.SHORT_PING_CMD_TYPE, 110, 68, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 73, 100, Constants.SHORT_PING_CMD_TYPE, 110, 116, 105, 102, 105, Constants.SHORT_PING_CMD_TYPE, 114, 83, Constants.SHORT_PING_CMD_TYPE, 114, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 36, 83, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 98, 36, 80, 114, 111, 120, 121, 59, 0, 60, 76, 99, 111, 109, 47, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 111, 100, 105, 115, 47, 111, 112, Constants.SHORT_PING_CMD_TYPE, 110, 100, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 47, 97, 105, 100, 108, 47, 79, 112, Constants.SHORT_PING_CMD_TYPE, 110, 68, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 73, 100, Constants.SHORT_PING_CMD_TYPE, 110, 116, 105, 102, 105, Constants.SHORT_PING_CMD_TYPE, 114, 83, Constants.SHORT_PING_CMD_TYPE, 114, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 36, 83, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 98, 59, 0, 55, 76, 99, 111, 109, 47, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 111, 100, 105, 115, 47, 111, 112, Constants.SHORT_PING_CMD_TYPE, 110, 100, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 47, 97, 105, 100, 108, 47, 79, 112, Constants.SHORT_PING_CMD_TYPE, 110, 68, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 73, 100, Constants.SHORT_PING_CMD_TYPE, 110, 116, 105, 102, 105, Constants.SHORT_PING_CMD_TYPE, 114, 83, Constants.SHORT_PING_CMD_TYPE, 114, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 59, 0, 34, 76, 100, 97, 108, 118, 105, 107, 47, 97, 110, 110, 111, 116, 97, 116, 105, 111, 110, 47, 69, 110, 99, 108, 111, 115, 105, 110, 103, 67, 108, 97, 115, 115, 59, 0, 30, 76, 100, 97, 108, 118, 105, 107, 47, 97, 110, 110, 111, 116, 97, 116, 105, 111, 110, 47, 73, 110, 110, Constants.SHORT_PING_CMD_TYPE, 114, 67, 108, 97, 115, 115, 59, 0, PublicSuffixDatabase.EXCEPTION_MARKER, 76, 100, 97, 108, 118, 105, 107, 47, 97, 110, 110, 111, 116, 97, 116, 105, 111, 110, 47, 77, Constants.SHORT_PING_CMD_TYPE, 109, 98, Constants.SHORT_PING_CMD_TYPE, 114, 67, 108, 97, 115, 115, Constants.SHORT_PING_CMD_TYPE, 115, 59, 0, 26, 76, 100, 97, 108, 118, 105, 107, 47, 97, 110, 110, 111, 116, 97, 116, 105, 111, 110, 47, 84, 104, 114, 111, 119, 115, 59, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, Constants.SHORT_PING_CMD_TYPE, 99, 116, 59, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 0, 32, 79, 112, Constants.SHORT_PING_CMD_TYPE, 110, 68, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 73, 100, Constants.SHORT_PING_CMD_TYPE, 110, 116, 105, 102, 105, Constants.SHORT_PING_CMD_TYPE, 114, 83, Constants.SHORT_PING_CMD_TYPE, 114, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 46, 106, 97, 118, 97, 0, 5, 80, 114, 111, 120, 121, 0, 4, 83, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 98, 0, 19, 84, 82, 65, 78, 83, 65, 67, 84, 73, 79, 78, 95, 103, Constants.SHORT_PING_CMD_TYPE, 116, 79, 97, 105, 100, 0, 20, 84, 82, 65, 78, 83, 65, 67, 84, 73, 79, 78, 95, 103, Constants.SHORT_PING_CMD_TYPE, 116, 79, 97, 105, 100, 50, 0, 30, 84, 82, 65, 78, 83, 65, 67, 84, 73, 79, 78, 95, 105, 115, 79, 97, 105, 100, 84, 114, 97, 99, 107, 76, 105, 109, 105, 116, Constants.SHORT_PING_CMD_TYPE, 100, 0, 1, 86, 0, 2, 86, 73, 0, 2, 86, 76, 0, 3, 86, 76, 76, 0, 1, 90, 0, 5, 90, 73, 76, 76, 73, 0, 5, 95, 100, 97, 116, 97, 0, 6, 95, 114, Constants.SHORT_PING_CMD_TYPE, 112, 108, 121, 0, 7, 95, 114, Constants.SHORT_PING_CMD_TYPE, 115, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 108, 116, 0, 11, 97, 99, 99, Constants.SHORT_PING_CMD_TYPE, 115, 115, 70, 108, 97, 103, 115, 0, 8, 97, 115, 66, 105, 110, 100, Constants.SHORT_PING_CMD_TYPE, 114, 0, 11, 97, 115, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 0, 15, 97, 116, 116, 97, 99, 104, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 0, 4, 99, 111, 100, Constants.SHORT_PING_CMD_TYPE, 0, 53, 99, 111, 109, 46, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 111, 100, 105, 115, 46, 111, 112, Constants.SHORT_PING_CMD_TYPE, 110, 100, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 46, 97, 105, 100, 108, 46, 79, 112, Constants.SHORT_PING_CMD_TYPE, 110, 68, Constants.SHORT_PING_CMD_TYPE, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 73, 100, Constants.SHORT_PING_CMD_TYPE, 110, 116, 105, 102, 105, Constants.SHORT_PING_CMD_TYPE, 114, 83, Constants.SHORT_PING_CMD_TYPE, 114, 118, 105, 99, Constants.SHORT_PING_CMD_TYPE, 0, 4, 100, 97, 116, 97, 0, 10, 100, Constants.SHORT_PING_CMD_TYPE, 115, 99, 114, 105, 112, 116, 111, 114, 0, 16, Constants.SHORT_PING_CMD_TYPE, 110, 102, 111, 114, 99, Constants.SHORT_PING_CMD_TYPE, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 0, 5, 102, 108, 97, 103, 115, 0, 22, 103, Constants.SHORT_PING_CMD_TYPE, 116, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 68, Constants.SHORT_PING_CMD_TYPE, 115, 99, 114, 105, 112, 116, 111, 114, 0, 7, 103, Constants.SHORT_PING_CMD_TYPE, 116, 79, 97, 105, 100, 0, 8, 103, Constants.SHORT_PING_CMD_TYPE, 116, 79, 97, 105, 100, 50, 0, 3, 105, 105, 110, 0, 18, 105, 115, 79, 97, 105, 100, 84, 114, 97, 99, 107, 76, 105, 109, 105, 116, Constants.SHORT_PING_CMD_TYPE, 100, 0, 7, 109, 82, Constants.SHORT_PING_CMD_TYPE, 109, 111, 116, Constants.SHORT_PING_CMD_TYPE, 0, 4, 110, 97, 109, Constants.SHORT_PING_CMD_TYPE, 0, 3, 111, 98, 106, 0, 6, 111, 98, 116, 97, 105, 110, 0, 10, 111, 110, 84, 114, 97, 110, 115, 97, 99, 116, 0, 19, 113, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, Constants.SHORT_PING_CMD_TYPE, 114, 121, 76, 111, 99, 97, 108, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, Constants.SHORT_PING_CMD_TYPE, 0, 13, 114, Constants.SHORT_PING_CMD_TYPE, 97, 100, 69, 120, 99, Constants.SHORT_PING_CMD_TYPE, 112, 116, 105, 111, 110, 0, 7, 114, Constants.SHORT_PING_CMD_TYPE, 97, 100, 73, 110, 116, 0, 10, 114, Constants.SHORT_PING_CMD_TYPE, 97, 100, 83, 116, 114, 105, 110, 103, 0, 7, 114, Constants.SHORT_PING_CMD_TYPE, 99, 121, 99, 108, Constants.SHORT_PING_CMD_TYPE, 0, 6, 114, Constants.SHORT_PING_CMD_TYPE, 109, 111, 116, Constants.SHORT_PING_CMD_TYPE, 0, 5, 114, Constants.SHORT_PING_CMD_TYPE, 112, 108, 121, 0, 4, 116, 104, 105, 115, 0, 8, 116, 114, 97, 110, 115, 97, 99, 116, 0, 5, 118, 97, 108, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, Constants.SHORT_PING_CMD_TYPE, 0, 8, 119, 114, 105, 116, Constants.SHORT_PING_CMD_TYPE, 73, 110, 116, 0, 19, 119, 114, 105, 116, Constants.SHORT_PING_CMD_TYPE, 73, 110, 116, Constants.SHORT_PING_CMD_TYPE, 114, 102, 97, 99, 
        Constants.SHORT_PING_CMD_TYPE, 84, 111, 107, Constants.SHORT_PING_CMD_TYPE, 110, 0, 16, 119, 114, 105, 116, Constants.SHORT_PING_CMD_TYPE, 78, 111, 69, 120, 99, Constants.SHORT_PING_CMD_TYPE, 112, 116, 105, 111, 110, 0, 11, 119, 114, 105, 116, Constants.SHORT_PING_CMD_TYPE, 83, 116, 114, 105, 110, 103, 0, 82, 1, 60, 7, 14, 60, UtilsBlink.VER_TYPE_SEPARATOR, 0, 87, 0, 7, 14, 0, 91, 0, 7, 14, 0, 95, 0, 7, 14, 75, 3, 0, 32, 5, 77, 3, 1, PublicSuffixDatabase.EXCEPTION_MARKER, 5, 90, 120, 60, 77, 3, 2, 34, 15, 60, 61, 26, 5, 2, 75, 0, -126, 1, 0, 7, 14, 75, 3, 0, 32, 5, 77, 3, 1, PublicSuffixDatabase.EXCEPTION_MARKER, 5, 90, 120, 60, 77, 3, 2, 34, 15, 60, 61, 26, 5, 2, 75, 0, 113, 0, 7, 29, 75, 3, 0, 32, 5, 77, 3, 1, PublicSuffixDatabase.EXCEPTION_MARKER, 5, 90, 120, 60, 122, 3, 2, 34, 17, 60, 61, 26, 5, 2, 75, 0, 16, 0, 7, 14, 60, 90, 0, 25, 1, 52, 7, 14, UtilsBlink.VER_TYPE_SEPARATOR, Base64.INTERNAL_PADDING, 25, 105, 3, 0, 48, 4, 105, 61, 1, 2, 5, 0, 0, 36, 0, 7, 14, 0, 40, 4, 39, 41, 61, 44, 7, 29, UtilsBlink.VER_TYPE_SEPARATOR, 3, 1, 42, 15, 2, PublicSuffixDatabase.EXCEPTION_MARKER, 59, 2, 99, 89, 79, 60, 75, 3, 0, 34, 15, 60, 79, 5, 0, 60, 75, 3, 0, 34, 17, 60, -102, 5, 0, 60, 75, 3, 0, 34, 15, 60, 2, 100, 74, 0, 2, 11, 1, 63, 28, 1, 24, 7, 2, StandardMessageCodec.LIST, 1, 63, 28, 1, 24, 5, 2, 9, 1, 63, 24, 7, 2, 10, 2, 34, 4, 10, 50, 23, 20, 2, 9, 1, 63, 24, 8, 2, 10, 2, 34, 36, 9, 4, 50, 23, 21, 2, 11, 1, 63, 28, 1, 24, 6, 4, 23, 39, 4, 1, 4, 3, 4, 2, 0, 0, 0, 3, 28, -127, 8, 0, 1, -127, 8, 0, 1, -127, 8, 0, 0, 1, 1, 5, 0, 2, 14, ByteCompanionObject.MIN_VALUE, ByteCompanionObject.MIN_VALUE, 4, -108, 8, 15, 1, -80, 8, 1, 1, -56, 8, 1, 1, -32, 8, 1, 1, -48, 9, 1, 1, -64, 10, 4, 0, 2, 2, 1, 26, 1, 24, 1, 24, 1, 24, 20, -127, ByteCompanionObject.MIN_VALUE, 4, -72, 11, 2, 9, -36, 11, 21, 1, -96, StandardMessageCodec.LIST, 6, 1, -76, StandardMessageCodec.LIST, 0, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 68, 0, 0, 0, 112, 0, 0, 0, 2, 0, 0, 0, 17, 0, 0, 0, ByteCompanionObject.MIN_VALUE, 1, 0, 0, 3, 0, 0, 0, 13, 0, 0, 0, -60, 1, 0, 0, 4, 0, 0, 0, 5, 0, 0, 0, 96, 2, 0, 0, 5, 0, 0, 0, 32, 0, 0, 0, -120, 2, 0, 0, 6, 0, 0, 0, 3, 0, 0, 0, -120, 3, 0, 0, 3, 16, 0, 0, 4, 0, 0, 0, -24, 3, 0, 0, 1, 32, 0, 0, 10, 0, 0, 0, 20, 4, 0, 0, 6, 32, 0, 0, 3, 0, 0, 0, -28, 6, 0, 0, 1, 16, 0, 0, 7, 0, 0, 0, 76, 7, 0, 0, 2, 32, 0, 0, 68, 0, 0, 0, -120, 7, 0, 0, 3, 32, 0, 0, 10, 0, 0, 0, -34, 11, 0, 0, 4, 32, 0, 0, 7, 0, 0, 0, -101, StandardMessageCodec.LIST, 0, 0, 5, 32, 0, 0, 1, 0, 0, 0, -46, StandardMessageCodec.LIST, 0, 0, 0, 32, 0, 0, 3, 0, 0, 0, -37, StandardMessageCodec.LIST, 0, 0, 0, 16, 0, 0, 1, 0, 0, 0, 44, 13, 0, 0};
    }

    public HuaWeiOAID() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void hwBindService(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            try {
                UniqueIdUtils.sendSDKTypeLog(context, "hw-start", "");
                TaskScheduler.getInstance().submit(new BaseTask(context, new ServiceConnection(context) { // from class: com.baidu.mobads.container.util.oaid.HuaWeiOAID.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$context;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        Class cls;
                        Class<?>[] declaredClasses;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                            UniqueIdUtils.sendSDKTypeLog(this.val$context, "hw-connect", "");
                            try {
                                cls = Class.forName(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                            } catch (Throwable th) {
                                UniqueIdUtils.sendSDKTypeLog(this.val$context, "hw-serror" + th.getMessage(), "");
                                cls = null;
                            }
                            if (cls == null) {
                                try {
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        cls = new InMemoryDexClassLoader(ByteBuffer.wrap(HuaWeiOAID.hwoaid), getClass().getClassLoader()).loadClass(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                                    }
                                } catch (Throwable th2) {
                                    UniqueIdUtils.sendSDKTypeLog(this.val$context, "hw-serror1" + th2.getMessage(), "");
                                }
                            }
                            if (cls != null) {
                                try {
                                    Class<?> cls2 = null;
                                    for (Class<?> cls3 : cls.getDeclaredClasses()) {
                                        if (cls3.getSimpleName().equals("Stub")) {
                                            cls2 = cls3;
                                        }
                                    }
                                    if (cls2 != null) {
                                        Object invoke = cls2.getMethod("asInterface", IBinder.class).invoke(null, iBinder);
                                        Method method = invoke.getClass().getMethod("getOaid", new Class[0]);
                                        Method method2 = invoke.getClass().getMethod("isOaidTrackLimited", new Class[0]);
                                        String str = (String) method.invoke(invoke, new Object[0]);
                                        if (!TextUtils.isEmpty(str)) {
                                            UniqueIdUtils.miitOAID = str;
                                            UniqueIdUtils.sendSDKTypeLog(this.val$context, "hw-valid", str);
                                            UniqueIdUtils.update(604800000L, str);
                                        } else {
                                            UniqueIdUtils.sendSDKTypeLog(this.val$context, "hw-empty", "");
                                        }
                                        boolean unused = HuaWeiOAID.hwTrackLimited = ((Boolean) method2.invoke(invoke, new Object[0])).booleanValue();
                                        RemoteXAdLogger.getInstance().d("UniqueIdUtils", String.format("thread %s oaid:%s limited:%s", Long.valueOf(Thread.currentThread().getId()), UniqueIdUtils.miitOAID, Boolean.valueOf(HuaWeiOAID.hwTrackLimited)));
                                    }
                                } catch (Throwable th3) {
                                    UniqueIdUtils.sendSDKTypeLog(this.val$context, "hw-error" + th3.getMessage(), "");
                                }
                            }
                            try {
                                this.val$context.unbindService(this);
                            } catch (Throwable unused2) {
                            }
                        }
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                        }
                    }
                }) { // from class: com.baidu.mobads.container.util.oaid.HuaWeiOAID.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ ServiceConnection val$hwService;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                        this.val$hwService = r7;
                    }

                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            try {
                                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                                intent.setPackage("com.huawei.hwid");
                                this.val$context.bindService(intent, this.val$hwService, 1);
                                return null;
                            } catch (Throwable unused) {
                                return null;
                            }
                        }
                        return invokeV.objValue;
                    }
                });
            } catch (Throwable th) {
                UniqueIdUtils.sendSDKTypeLog(context, "hw-serror1" + th.getMessage(), "");
            }
        }
    }

    public static boolean isHuaweiBrand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            try {
                String phoneOSBrand = DeviceUtils.getInstance().getPhoneOSBrand();
                if (TextUtils.isEmpty(phoneOSBrand)) {
                    return false;
                }
                if (!phoneOSBrand.equalsIgnoreCase(RomUtils.MANUFACTURER_HUAWEI)) {
                    if (!phoneOSBrand.equalsIgnoreCase("honor")) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
