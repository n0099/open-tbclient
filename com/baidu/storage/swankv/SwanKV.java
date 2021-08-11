package com.baidu.storage.swankv;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\bj\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ¯\u0001:\u0006¯\u0001°\u0001±\u0001B)\b\u0016\u0012\n\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u0001\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010U\u001a\u00020\u001e¢\u0006\u0006\b§\u0001\u0010¨\u0001B!\b\u0016\u0012\n\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u0001\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\b§\u0001\u0010©\u0001B\u0015\b\u0016\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\b§\u0001\u0010 \u0001B\u001d\b\u0016\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010U\u001a\u00020\u001e¢\u0006\u0006\b§\u0001\u0010ª\u0001B\u0015\b\u0016\u0012\b\u0010¬\u0001\u001a\u00030«\u0001¢\u0006\u0006\b§\u0001\u0010\u00ad\u0001B5\u0012\n\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u0001\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010U\u001a\u00020\u001e\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\b§\u0001\u0010®\u0001J\u000f\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bH\u0096 ¢\u0006\u0004\b\u0014\u0010\nJ\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u001eH\u0016¢\u0006\u0004\b#\u0010$J1\u0010)\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010&*\u00020%2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J#\u0010.\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u00101J/\u00104\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105J/\u0010;\u001a\u00020:2\u0016\u00108\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u000107062\u0006\u00109\u001a\u00020\u0001H\u0016¢\u0006\u0004\b;\u0010<J\u0018\u0010>\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\bH\u0082 ¢\u0006\u0004\b>\u0010?J \u0010@\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\b@\u0010AJ\u0018\u0010B\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bH\u0082 ¢\u0006\u0004\bB\u0010CJ\u001e\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010=\u001a\u00020\bH\u0082 ¢\u0006\u0004\bD\u0010EJ(\u0010I\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020\u001eH\u0082 ¢\u0006\u0004\bI\u0010JJ(\u0010K\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0001H\u0082 ¢\u0006\u0004\bK\u0010LJ\"\u0010M\u001a\u0004\u0018\u00010\u00112\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\bM\u0010NJ(\u0010O\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0015H\u0082 ¢\u0006\u0004\bO\u0010PJ\u0018\u0010Q\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\bH\u0082 ¢\u0006\u0004\bQ\u0010RJ(\u0010S\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u001bH\u0082 ¢\u0006\u0004\bS\u0010TJ*\u0010W\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u001e2\b\u0010V\u001a\u0004\u0018\u00010\u0004H\u0082 ¢\u0006\u0004\bW\u0010XJ(\u0010Y\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u001eH\u0082 ¢\u0006\u0004\bY\u0010ZJ(\u0010[\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0082 ¢\u0006\u0004\b[\u0010\\J(\u0010]\u001a\u00020+2\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020+H\u0082 ¢\u0006\u0004\b]\u0010^J,\u0010_\u001a\u0004\u0018\u00010\u00042\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0082 ¢\u0006\u0004\b_\u0010`J(\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\ba\u0010bJ\u0018\u0010d\u001a\u00020:2\u0006\u0010c\u001a\u00020\u0001H\u0084 ¢\u0006\u0004\bd\u0010eJ\u0018\u0010f\u001a\u00020:2\u0006\u0010=\u001a\u00020\bH\u0082 ¢\u0006\u0004\bf\u0010gJ \u0010h\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\bh\u0010AJ \u0010j\u001a\u00020:2\u0006\u0010=\u001a\u00020\b2\u0006\u0010i\u001a\u00020\u0001H\u0082 ¢\u0006\u0004\bj\u0010kJ\u0018\u0010l\u001a\u00020:2\u0006\u0010=\u001a\u00020\bH\u0082 ¢\u0006\u0004\bl\u0010gJ(\u0010n\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0001H\u0082 ¢\u0006\u0004\bn\u0010LJ(\u0010o\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0011H\u0082 ¢\u0006\u0004\bo\u0010pJ(\u0010q\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0015H\u0082 ¢\u0006\u0004\bq\u0010rJ(\u0010s\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u001bH\u0082 ¢\u0006\u0004\bs\u0010tJ(\u0010u\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u001eH\u0082 ¢\u0006\u0004\bu\u0010vJ(\u0010w\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\bH\u0082 ¢\u0006\u0004\bw\u0010xJ(\u0010y\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020+H\u0082 ¢\u0006\u0004\by\u0010zJ(\u0010{\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\b{\u0010|J0\u0010}\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010m\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000bH\u0082 ¢\u0006\u0004\b}\u0010~J\u0010\u0010\u007f\u001a\u00020:H\u0016¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0019\u0010\u0081\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u0081\u0001\u0010\u0007J\u001d\u0010\u0083\u0001\u001a\u00020\u00012\t\b\u0001\u0010\u0082\u0001\u001a\u00020\bH\u0096 ¢\u0006\u0005\b\u0083\u0001\u0010?J\u0017\u0010i\u001a\u00020:2\u0006\u0010i\u001a\u00020\u0001H\u0016¢\u0006\u0004\bi\u0010eJ\u0012\u0010\u0084\u0001\u001a\u00020:H\u0016¢\u0006\u0006\b\u0084\u0001\u0010\u0080\u0001J!\u0010\u0085\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0001H\u0016¢\u0006\u0005\b\u0085\u0001\u0010\u0010J$\u0010\u0086\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010m\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\"\u0010\u0088\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0015H\u0016¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\"\u0010\u008a\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u001bH\u0016¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\"\u0010\u008c\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u001eH\u0016¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\"\u0010\u008e\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\bH\u0016¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J$\u0010\u0090\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010m\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\"\u0010\u0092\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010m\u001a\u00020+H\u0016¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J$\u0010\u0094\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010m\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J,\u0010\u0096\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0010\u0010m\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J+\u0010\u0099\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u000f\u0010\u0098\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000102H\u0016¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0017\u0010U\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bU\u0010\u009b\u0001R)\u0010F\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bF\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R\u0019\u0010¡\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R)\u0010V\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bV\u0010\u009c\u0001\u001a\u0006\b£\u0001\u0010\u009e\u0001\"\u0006\b¤\u0001\u0010 \u0001¨\u0006²\u0001"}, d2 = {"Lcom/baidu/storage/swankv/SwanKV;", "", "clearAll", "()Z", "", "key", "containKey", "(Ljava/lang/String;)Z", "", "contentSize", "()J", "", "getAllKeys", "()[Ljava/lang/String;", "defaultValue", "getBool", "(Ljava/lang/String;Z)Z", "", "getBytes", "(Ljava/lang/String;)[B", "getCustomMeta", "", "getDouble", "(Ljava/lang/String;D)D", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "", "getFloat", "(Ljava/lang/String;F)F", "", "getInt", "(Ljava/lang/String;I)I", "getLong", "(Ljava/lang/String;J)J", "getMode", "()I", "Landroid/os/Parcelable;", "T", "Landroid/os/Parcelable$Creator;", "creator", "getParcel", "(Ljava/lang/String;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;", "", "getShort", "(Ljava/lang/String;S)S", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getStringArray", "(Ljava/lang/String;)[Ljava/lang/String;", "", "defValues", "getStringSet", "(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;", "", "", "map", "replaceIfExist", "", "importFromMap", "(Ljava/util/Map;Z)V", "handle", "nClean", "(J)Z", "nContainKey", "(JLjava/lang/String;)Z", "nContentSize", "(J)J", "nGetAllKeys", "(J)[Ljava/lang/String;", "name", "ashmemFd", "size", "nGetAshmemHandle", "(Ljava/lang/String;II)J", "nGetBool", "(JLjava/lang/String;Z)Z", "nGetBytes", "(JLjava/lang/String;)[B", "nGetDouble", "(JLjava/lang/String;D)D", "nGetFilePath", "(J)Ljava/lang/String;", "nGetFloat", "(JLjava/lang/String;F)F", "mode", "rootPath", "nGetHandle", "(Ljava/lang/String;ILjava/lang/String;)J", "nGetInt", "(JLjava/lang/String;I)I", "nGetLong", "(JLjava/lang/String;J)J", "nGetShort", "(JLjava/lang/String;S)S", "nGetString", "(JLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "nGetStringArray", "(JLjava/lang/String;)[Ljava/lang/String;", "doOrUnLock", "nLockThread", "(Z)V", "nRelease", "(J)V", "nRemove", "sync", "nSync", "(JZ)V", "nTrim", "value", "nWriteBool", "nWriteBytes", "(JLjava/lang/String;[B)Z", "nWriteDouble", "(JLjava/lang/String;D)Z", "nWriteFloat", "(JLjava/lang/String;F)Z", "nWriteInt", "(JLjava/lang/String;I)Z", "nWriteLong", "(JLjava/lang/String;J)Z", "nWriteShort", "(JLjava/lang/String;S)Z", "nWriteString", "(JLjava/lang/String;Ljava/lang/String;)Z", "nWriteStringArray", "(JLjava/lang/String;[Ljava/lang/String;)Z", "release", "()V", "removeKey", "data", "setCustomMeta", "trim", "writeBool", "writeBytes", "(Ljava/lang/String;[B)Z", "writeDouble", "(Ljava/lang/String;D)Z", "writeFloat", "(Ljava/lang/String;F)Z", "writeInt", "(Ljava/lang/String;I)Z", "writeLong", "(Ljava/lang/String;J)Z", "writeParcel", "(Ljava/lang/String;Landroid/os/Parcelable;)Z", "writeShort", "(Ljava/lang/String;S)Z", "writeString", "(Ljava/lang/String;Ljava/lang/String;)Z", "writeStringArray", "(Ljava/lang/String;[Ljava/lang/String;)Z", SavedStateHandle.VALUES, "writeStringSet", "(Ljava/lang/String;Ljava/util/Set;)Z", "I", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "nativeHandle", "J", "getRootPath", "setRootPath", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;I)V", "(Landroid/content/Context;Ljava/lang/String;)V", "(Ljava/lang/String;I)V", "Lcom/baidu/storage/swankv/AshmemFileDescriptor;", "fd", "(Lcom/baidu/storage/swankv/AshmemFileDescriptor;)V", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)V", "Companion", "SoLoader", "SwanKVMode", "swankv_staticRelease"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes6.dex */
public class SwanKV {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final a f45283d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f45284a;

    /* renamed from: b  reason: collision with root package name */
    public int f45285b;

    /* renamed from: c  reason: collision with root package name */
    public String f45286c;
    public long nativeHandle;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final String b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str == null) {
                    str = "default";
                }
                String encodeName = URLEncoder.encode(str, "UTF-8");
                if (encodeName.length() > 100) {
                    Intrinsics.checkExpressionValueIsNotNull(encodeName, "encodeName");
                    if (encodeName == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    encodeName = encodeName.substring(0, 100);
                    Intrinsics.checkExpressionValueIsNotNull(encodeName, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                Intrinsics.checkExpressionValueIsNotNull(encodeName, "encodeName");
                return encodeName;
            }
            return (String) invokeL.objValue;
        }

        @JvmStatic
        public final boolean c(Context context, b bVar, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar, z)) == null) {
                if (bVar != null) {
                    bVar.loadLibrary("swanKV");
                } else {
                    System.loadLibrary("swanKV");
                }
                File file = new File(context.getFilesDir(), "swan_prefs");
                if (!file.exists() || !file.isDirectory()) {
                    if (!file.isDirectory()) {
                        file.delete();
                    }
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                }
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath, "baseDir.absolutePath");
                d(absolutePath, z);
                return true;
            }
            return invokeLLZ.booleanValue;
        }

        @JvmStatic
        public final void d(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
                SwanKV.nInitialize(str, z);
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void loadLibrary(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1530295086, "Lcom/baidu/storage/swankv/SwanKV;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1530295086, "Lcom/baidu/storage/swankv/SwanKV;");
                return;
            }
        }
        f45283d = new a(null);
    }

    public SwanKV(Context context, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45284a = str;
        this.f45285b = i2;
        this.f45286c = str2;
        if (i2 != 4) {
            if (!TextUtils.isEmpty(str2)) {
                File file = new File(this.f45286c);
                if ((!file.exists() || !file.isDirectory()) && !file.mkdirs() && !file.exists()) {
                    String str3 = "mkdirs fail: " + this.f45286c;
                    this.f45286c = "";
                }
            }
            this.nativeHandle = nGetHandle(f45283d.b(this.f45284a), this.f45285b, this.f45286c);
        }
    }

    @JvmStatic
    public static final native int getAshmemFD(String str, int i2);

    @JvmStatic
    public static final boolean n(Context context, b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.AD_TEXT_ID, null, context, bVar, z)) == null) ? f45283d.c(context, bVar, z) : invokeLLZ.booleanValue;
    }

    private final native boolean nClean(long j2);

    private final native boolean nContainKey(long j2, String str);

    private final native long nContentSize(long j2);

    private final native String[] nGetAllKeys(long j2);

    private final native long nGetAshmemHandle(String str, int i2, int i3);

    private final native boolean nGetBool(long j2, String str, boolean z);

    private final native byte[] nGetBytes(long j2, String str);

    private final native double nGetDouble(long j2, String str, double d2);

    private final native String nGetFilePath(long j2);

    private final native float nGetFloat(long j2, String str, float f2);

    private final native long nGetHandle(String str, int i2, String str2);

    private final native int nGetInt(long j2, String str, int i2);

    private final native long nGetLong(long j2, String str, long j3);

    private final native short nGetShort(long j2, String str, short s);

    private final native String nGetString(long j2, String str, String str2);

    private final native String[] nGetStringArray(long j2, String str);

    @JvmStatic
    public static final native void nInitialize(String str, boolean z);

    private final native void nRelease(long j2);

    private final native boolean nRemove(long j2, String str);

    private final native void nSync(long j2, boolean z);

    private final native void nTrim(long j2);

    private final native boolean nWriteBool(long j2, String str, boolean z);

    private final native boolean nWriteBytes(long j2, String str, byte[] bArr);

    private final native boolean nWriteDouble(long j2, String str, double d2);

    private final native boolean nWriteFloat(long j2, String str, float f2);

    private final native boolean nWriteInt(long j2, String str, int i2);

    private final native boolean nWriteLong(long j2, String str, long j3);

    private final native boolean nWriteShort(long j2, String str, short s);

    private final native boolean nWriteString(long j2, String str, String str2);

    private final native boolean nWriteStringArray(long j2, String str, String[] strArr);

    public File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new File(nGetFilePath(this.nativeHandle)) : (File) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? nClean(this.nativeHandle) : invokeV.booleanValue;
    }

    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? nContainKey(this.nativeHandle, str) : invokeL.booleanValue;
    }

    public native long getCustomMeta();

    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048580, this, str, f2)) == null) ? nGetFloat(this.nativeHandle, str, f2) : invokeLF.floatValue;
    }

    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i2)) == null) ? nGetInt(this.nativeHandle, str, i2) : invokeLI.intValue;
    }

    public long getLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j2)) == null) ? nGetLong(this.nativeHandle, str, j2) : invokeLJ.longValue;
    }

    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            byte[] nGetBytes = nGetBytes(this.nativeHandle, str);
            return nGetBytes != null ? new String(nGetBytes, Charsets.UTF_8) : str2;
        }
        return (String) invokeLL.objValue;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, set)) == null) {
            String[] l = l(str);
            return l != null ? ArraysKt___ArraysKt.toMutableSet(l) : set;
        }
        return (Set) invokeLL.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? nContentSize(this.nativeHandle) : invokeV.longValue;
    }

    public String[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? nGetAllKeys(this.nativeHandle) : (String[]) invokeV.objValue;
    }

    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, str, z)) == null) ? nGetBool(this.nativeHandle, str, z) : invokeLZ.booleanValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f45285b : invokeV.intValue;
    }

    public String[] l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? nGetStringArray(this.nativeHandle, str) : (String[]) invokeL.objValue;
    }

    public void m(Map<String, ? extends Object> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, map, z) == null) {
            nLockThread(true);
            try {
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (key != null && value != null && (z || !g(key))) {
                        if (value instanceof Boolean) {
                            r(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof String) {
                            w(key, (String) value);
                        } else if (value instanceof Integer) {
                            u(key, ((Number) value).intValue());
                        } else if (value instanceof Float) {
                            t(key, ((Number) value).floatValue());
                        } else if (value instanceof Double) {
                            s(key, ((Number) value).doubleValue());
                        } else if (value instanceof Long) {
                            v(key, ((Number) value).longValue());
                        } else if (value instanceof Set) {
                            y(key, TypeIntrinsics.asMutableSet(value));
                        }
                    }
                }
            } catch (Exception unused) {
            }
            nLockThread(false);
        }
    }

    public final native void nLockThread(boolean z);

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            nRelease(this.nativeHandle);
            this.nativeHandle = 0L;
        }
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? nRemove(this.nativeHandle, str) : invokeL.booleanValue;
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            nSync(this.nativeHandle, z);
        }
    }

    public boolean r(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048595, this, str, z)) == null) ? nWriteBool(this.nativeHandle, str, z) : invokeLZ.booleanValue;
    }

    public boolean s(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{str, Double.valueOf(d2)})) == null) ? nWriteDouble(this.nativeHandle, str, d2) : invokeCommon.booleanValue;
    }

    public native boolean setCustomMeta(@IntRange(from = 0, to = 4294967295L) long j2);

    public boolean t(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048598, this, str, f2)) == null) ? nWriteFloat(this.nativeHandle, str, f2) : invokeLF.booleanValue;
    }

    public boolean u(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, str, i2)) == null) ? nWriteInt(this.nativeHandle, str, i2) : invokeLI.booleanValue;
    }

    public boolean v(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j2)) == null) ? nWriteLong(this.nativeHandle, str, j2) : invokeLJ.booleanValue;
    }

    public boolean w(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, str, str2)) == null) {
            if (str2 == null) {
                return p(str);
            }
            return nWriteString(this.nativeHandle, str, str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean x(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, str, strArr)) == null) {
            if (strArr == null) {
                return p(str);
            }
            return nWriteStringArray(this.nativeHandle, str, strArr);
        }
        return invokeLL.booleanValue;
    }

    public boolean y(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, set)) == null) {
            if (set == null) {
                return p(str);
            }
            Object[] array = set.toArray(new String[0]);
            if (array != null) {
                return x(str, (String[]) array);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanKV(AshmemFileDescriptor ashmemFileDescriptor) {
        this(null, ashmemFileDescriptor.getName(), 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ashmemFileDescriptor};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.nativeHandle = nGetAshmemHandle(f45283d.b(this.f45284a), ashmemFileDescriptor.getAshmemFD(), ashmemFileDescriptor.getSize());
    }
}
