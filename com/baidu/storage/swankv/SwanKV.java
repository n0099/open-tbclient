package com.baidu.storage.swankv;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.nr1;
import com.baidu.tieba.or1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\bl\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 ·\u0001:\b·\u0001¸\u0001¹\u0001º\u0001B)\b\u0016\u0012\n\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u0001\u0012\b\u0010N\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010]\u001a\u00020\u0012¢\u0006\u0006\b¯\u0001\u0010°\u0001B!\b\u0016\u0012\n\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u0001\u0012\b\u0010N\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\b¯\u0001\u0010±\u0001B\u0015\b\u0016\u0012\b\u0010N\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\b¯\u0001\u0010¨\u0001B\u001d\b\u0016\u0012\b\u0010N\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010]\u001a\u00020\u0012¢\u0006\u0006\b¯\u0001\u0010²\u0001B\u0015\b\u0016\u0012\b\u0010´\u0001\u001a\u00030³\u0001¢\u0006\u0006\b¯\u0001\u0010µ\u0001B5\u0012\n\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u0001\u0012\b\u0010N\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010]\u001a\u00020\u0012\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\b¯\u0001\u0010¶\u0001J\u000f\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0017¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012`\u0013H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\bH\u0096 ¢\u0006\u0004\b\u001c\u0010\nJ\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0012H\u0016¢\u0006\u0004\b*\u0010+J1\u00100\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010-*\u00020,2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000.H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00103\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J#\u00105\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b5\u00106J\u001f\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b7\u00108J/\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001092\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000109H\u0016¢\u0006\u0004\b;\u0010<J/\u0010A\u001a\u00020@2\u0016\u0010>\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010=0\u000b2\u0006\u0010?\u001a\u00020\u0001H\u0016¢\u0006\u0004\bA\u0010BJ\u0018\u0010D\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\bH\u0082 ¢\u0006\u0004\bD\u0010EJ \u0010F\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\bF\u0010GJ\u0018\u0010H\u001a\u00020\b2\u0006\u0010C\u001a\u00020\bH\u0082 ¢\u0006\u0004\bH\u0010IJ \u0010J\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\u0006\u0010C\u001a\u00020\bH\u0082 ¢\u0006\u0004\bJ\u0010KJ8\u0010L\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00132\u0006\u0010C\u001a\u00020\bH\u0082 ¢\u0006\u0004\bL\u0010MJ(\u0010Q\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u0012H\u0082 ¢\u0006\u0004\bQ\u0010RJ(\u0010S\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0001H\u0082 ¢\u0006\u0004\bS\u0010TJ\"\u0010U\u001a\u0004\u0018\u00010\u00192\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\bU\u0010VJ(\u0010W\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u001dH\u0082 ¢\u0006\u0004\bW\u0010XJ\u0018\u0010Y\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\bH\u0082 ¢\u0006\u0004\bY\u0010ZJ(\u0010[\u001a\u00020#2\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020#H\u0082 ¢\u0006\u0004\b[\u0010\\J*\u0010_\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u00122\b\u0010^\u001a\u0004\u0018\u00010\u0004H\u0082 ¢\u0006\u0004\b_\u0010`J(\u0010a\u001a\u00020\u00122\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0012H\u0082 ¢\u0006\u0004\ba\u0010bJ(\u0010c\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bH\u0082 ¢\u0006\u0004\bc\u0010dJ(\u0010e\u001a\u0002022\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u000202H\u0082 ¢\u0006\u0004\be\u0010fJ,\u0010g\u001a\u0004\u0018\u00010\u00042\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0082 ¢\u0006\u0004\bg\u0010hJ(\u0010i\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e2\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\bi\u0010jJ\u0018\u0010l\u001a\u00020@2\u0006\u0010k\u001a\u00020\u0001H\u0084 ¢\u0006\u0004\bl\u0010mJ\u0018\u0010n\u001a\u00020@2\u0006\u0010C\u001a\u00020\bH\u0082 ¢\u0006\u0004\bn\u0010oJ \u0010p\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\bp\u0010GJ \u0010r\u001a\u00020@2\u0006\u0010C\u001a\u00020\b2\u0006\u0010q\u001a\u00020\u0001H\u0082 ¢\u0006\u0004\br\u0010sJ\u0018\u0010t\u001a\u00020@2\u0006\u0010C\u001a\u00020\bH\u0082 ¢\u0006\u0004\bt\u0010oJ(\u0010v\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0001H\u0082 ¢\u0006\u0004\bv\u0010TJ(\u0010w\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0019H\u0082 ¢\u0006\u0004\bw\u0010xJ(\u0010y\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u001dH\u0082 ¢\u0006\u0004\by\u0010zJ(\u0010{\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020#H\u0082 ¢\u0006\u0004\b{\u0010|J(\u0010}\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0012H\u0082 ¢\u0006\u0004\b}\u0010~J)\u0010\u007f\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\bH\u0082 ¢\u0006\u0005\b\u007f\u0010\u0080\u0001J+\u0010\u0081\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u000202H\u0082 ¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J+\u0010\u0083\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0004H\u0082 ¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J3\u0010\u0085\u0001\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000eH\u0082 ¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0012\u0010\u0087\u0001\u001a\u00020@H\u0016¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0019\u0010\u0089\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u0089\u0001\u0010\u0007J\u001d\u0010\u008b\u0001\u001a\u00020\u00012\t\b\u0001\u0010\u008a\u0001\u001a\u00020\bH\u0096 ¢\u0006\u0005\b\u008b\u0001\u0010EJ\u0017\u0010q\u001a\u00020@2\u0006\u0010q\u001a\u00020\u0001H\u0016¢\u0006\u0004\bq\u0010mJ\u0012\u0010\u008c\u0001\u001a\u00020@H\u0016¢\u0006\u0006\b\u008c\u0001\u0010\u0088\u0001J!\u0010\u008d\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0001H\u0016¢\u0006\u0005\b\u008d\u0001\u0010\u0018J$\u0010\u008e\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010u\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\"\u0010\u0090\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u001dH\u0016¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\"\u0010\u0092\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020#H\u0016¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\"\u0010\u0094\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0012H\u0016¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\"\u0010\u0096\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\bH\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J$\u0010\u0098\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010u\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\"\u0010\u009a\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010u\u001a\u000202H\u0016¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J$\u0010\u009c\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010u\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J,\u0010\u009e\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0010\u0010u\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J+\u0010¡\u0001\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u000f\u0010 \u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000109H\u0016¢\u0006\u0006\b¡\u0001\u0010¢\u0001R\u0017\u0010]\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b]\u0010£\u0001R)\u0010N\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bN\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R\u0019\u0010©\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R)\u0010^\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b^\u0010¤\u0001\u001a\u0006\b«\u0001\u0010¦\u0001\"\u0006\b¬\u0001\u0010¨\u0001¨\u0006»\u0001"}, d2 = {"Lcom/baidu/storage/swankv/SwanKV;", "", "clearAll", "()Z", "", "key", "containKey", "(Ljava/lang/String;)Z", "", "contentSize", "()J", "", "getAll", "()Ljava/util/Map;", "", "getAllKeys", "()[Ljava/lang/String;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getAllTypes", "()Ljava/util/HashMap;", "defaultValue", "getBool", "(Ljava/lang/String;Z)Z", "", "getBytes", "(Ljava/lang/String;)[B", "getCustomMeta", "", "getDouble", "(Ljava/lang/String;D)D", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "", "getFloat", "(Ljava/lang/String;F)F", "getInt", "(Ljava/lang/String;I)I", "getLong", "(Ljava/lang/String;J)J", "getMode", "()I", "Landroid/os/Parcelable;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable$Creator;", "creator", "getParcel", "(Ljava/lang/String;Landroid/os/Parcelable$Creator;)Landroid/os/Parcelable;", "", "getShort", "(Ljava/lang/String;S)S", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getStringArray", "(Ljava/lang/String;)[Ljava/lang/String;", "", "defValues", "getStringSet", "(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;", "", "map", "replaceIfExist", "", "importFromMap", "(Ljava/util/Map;Z)V", "handle", "nClean", "(J)Z", "nContainKey", "(JLjava/lang/String;)Z", "nContentSize", "(J)J", "nGetAllKeys", "(J)[Ljava/lang/String;", "nGetAllType", "(J)Ljava/util/HashMap;", "name", "ashmemFd", "size", "nGetAshmemHandle", "(Ljava/lang/String;II)J", "nGetBool", "(JLjava/lang/String;Z)Z", "nGetBytes", "(JLjava/lang/String;)[B", "nGetDouble", "(JLjava/lang/String;D)D", "nGetFilePath", "(J)Ljava/lang/String;", "nGetFloat", "(JLjava/lang/String;F)F", "mode", "rootPath", "nGetHandle", "(Ljava/lang/String;ILjava/lang/String;)J", "nGetInt", "(JLjava/lang/String;I)I", "nGetLong", "(JLjava/lang/String;J)J", "nGetShort", "(JLjava/lang/String;S)S", "nGetString", "(JLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "nGetStringArray", "(JLjava/lang/String;)[Ljava/lang/String;", "doOrUnLock", "nLockThread", "(Z)V", "nRelease", "(J)V", "nRemove", NativeConstants.COMPONENT_SYNC_TEXT_VIEW, "nSync", "(JZ)V", "nTrim", "value", "nWriteBool", "nWriteBytes", "(JLjava/lang/String;[B)Z", "nWriteDouble", "(JLjava/lang/String;D)Z", "nWriteFloat", "(JLjava/lang/String;F)Z", "nWriteInt", "(JLjava/lang/String;I)Z", "nWriteLong", "(JLjava/lang/String;J)Z", "nWriteShort", "(JLjava/lang/String;S)Z", "nWriteString", "(JLjava/lang/String;Ljava/lang/String;)Z", "nWriteStringArray", "(JLjava/lang/String;[Ljava/lang/String;)Z", "release", "()V", "removeKey", "data", "setCustomMeta", "trim", "writeBool", "writeBytes", "(Ljava/lang/String;[B)Z", "writeDouble", "(Ljava/lang/String;D)Z", "writeFloat", "(Ljava/lang/String;F)Z", "writeInt", "(Ljava/lang/String;I)Z", "writeLong", "(Ljava/lang/String;J)Z", "writeParcel", "(Ljava/lang/String;Landroid/os/Parcelable;)Z", "writeShort", "(Ljava/lang/String;S)Z", "writeString", "(Ljava/lang/String;Ljava/lang/String;)Z", "writeStringArray", "(Ljava/lang/String;[Ljava/lang/String;)Z", SavedStateHandle.VALUES, "writeStringSet", "(Ljava/lang/String;Ljava/util/Set;)Z", "I", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "nativeHandle", "J", "getRootPath", "setRootPath", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;I)V", "(Landroid/content/Context;Ljava/lang/String;)V", "(Ljava/lang/String;I)V", "Lcom/baidu/storage/swankv/AshmemFileDescriptor;", "fd", "(Lcom/baidu/storage/swankv/AshmemFileDescriptor;)V", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)V", "Companion", "DataType", "SoLoader", "SwanKVMode", "swankv_staticRelease"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public class SwanKV {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ASHMEM_MODE = 4;
    public static final a Companion;
    public static final String DEFAULT_NAME = "default";
    public static final String FLAVOR_SHARED = "shared";
    public static final Vector<or1> HANDLER_LISTENERS;
    public static final String LIB_CPP_SHARED = "c++_shared";
    public static final String LIB_SWANKV = "swanKV";
    public static final int MAX_FILE_NAME = 100;
    public static final int MULTI_PROCESS_MODE = 2;
    public static final String PREFS_SEGMENT = "swankv_default";
    public static final String PREFS_SUFFIX = ".kv";
    public static final int SINGLE_PROCESS_MODE = 1;
    public static final int TYPE_BOOL = 1;
    public static final int TYPE_BYTE_ARRAY = 9;
    public static final int TYPE_DOUBLE = 4;
    public static final int TYPE_FLOAT = 3;
    public static final int TYPE_INT = 2;
    public static final int TYPE_LONG = 6;
    public static final int TYPE_SHORT = 5;
    public static final int TYPE_STRING = 7;
    public static final int TYPE_STRING_ARRAY = 8;
    public static final int TYPE_UNKNOWN = 0;
    public static AtomicBoolean isInitFinish;
    public transient /* synthetic */ FieldHolder $fh;
    public int mode;
    public String name;
    public long nativeHandle;
    public String rootPath;

    /* loaded from: classes4.dex */
    public interface b {
        void loadLibrary(String str);
    }

    @JvmStatic
    public static final native int getAshmemFD(String str, int i);

    @JvmStatic
    public static final File getSwanKVFileByName(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, str)) == null) ? Companion.d(context, str) : (File) invokeLL.objValue;
    }

    @JvmStatic
    public static final File getSwanKVFileByName(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, context, str, str2)) == null) ? Companion.e(context, str, str2) : (File) invokeLLL.objValue;
    }

    @JvmStatic
    public static final boolean initialize(Context context, b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65552, null, context, bVar, z)) == null) ? Companion.f(context, bVar, z) : invokeLLZ.booleanValue;
    }

    @JvmStatic
    public static final boolean initialize(nr1 nr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, nr1Var)) == null) ? Companion.g(nr1Var) : invokeL.booleanValue;
    }

    private final native boolean nClean(long j);

    private final native boolean nContainKey(long j, String str);

    private final native long nContentSize(long j);

    private final native String[] nGetAllKeys(long j);

    private final native HashMap<String, Integer> nGetAllType(long j);

    private final native long nGetAshmemHandle(String str, int i, int i2);

    private final native boolean nGetBool(long j, String str, boolean z);

    private final native byte[] nGetBytes(long j, String str);

    private final native double nGetDouble(long j, String str, double d);

    private final native String nGetFilePath(long j);

    private final native float nGetFloat(long j, String str, float f);

    private final native long nGetHandle(String str, int i, String str2);

    private final native int nGetInt(long j, String str, int i);

    private final native long nGetLong(long j, String str, long j2);

    private final native short nGetShort(long j, String str, short s);

    private final native String nGetString(long j, String str, String str2);

    private final native String[] nGetStringArray(long j, String str);

    @JvmStatic
    public static final native void nInitialize(String str, boolean z, boolean z2);

    private final native void nRelease(long j);

    private final native boolean nRemove(long j, String str);

    private final native void nSync(long j, boolean z);

    private final native void nTrim(long j);

    private final native boolean nWriteBool(long j, String str, boolean z);

    private final native boolean nWriteBytes(long j, String str, byte[] bArr);

    private final native boolean nWriteDouble(long j, String str, double d);

    private final native boolean nWriteFloat(long j, String str, float f);

    private final native boolean nWriteInt(long j, String str, int i);

    private final native boolean nWriteLong(long j, String str, long j2);

    private final native boolean nWriteShort(long j, String str, short s);

    private final native boolean nWriteString(long j, String str, String str2);

    private final native boolean nWriteStringArray(long j, String str, String[] strArr);

    @JvmStatic
    public static final void onEventHandler(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65585, null, i, str, str2) == null) {
            Companion.i(i, str, str2);
        }
    }

    @JvmStatic
    public static final void registerEventHandler(or1 or1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65586, null, or1Var) == null) {
            Companion.j(or1Var);
        }
    }

    @JvmStatic
    public static final native void registerNAHandler(boolean z);

    @JvmStatic
    public static final void unregisterEventHandler(or1 or1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, null, or1Var) == null) {
            Companion.l(or1Var);
        }
    }

    public native long getCustomMeta();

    public final native void nLockThread(boolean z);

    public native boolean setCustomMeta(@IntRange(from = 0, to = 4294967295L) long j);

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void j(or1 or1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, or1Var) == null) {
                if (SwanKV.HANDLER_LISTENERS.isEmpty()) {
                    k(true);
                }
                SwanKV.HANDLER_LISTENERS.add(or1Var);
            }
        }

        @JvmStatic
        public final void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) != null) {
                return;
            }
            SwanKV.registerNAHandler(z);
        }

        @JvmStatic
        public final void l(or1 or1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, or1Var) == null) && or1Var != null) {
                SwanKV.HANDLER_LISTENERS.remove(or1Var);
                if (SwanKV.HANDLER_LISTENERS.isEmpty()) {
                    k(false);
                }
            }
        }

        @JvmStatic
        public final File d(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
                return e(context, str, null);
            }
            return (File) invokeLL.objValue;
        }

        public final String c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str == null) {
                    str = "default";
                }
                String encodeName = URLEncoder.encode(str, "UTF-8");
                if (encodeName.length() > 100) {
                    Intrinsics.checkExpressionValueIsNotNull(encodeName, "encodeName");
                    if (encodeName != null) {
                        encodeName = encodeName.substring(0, 100);
                        Intrinsics.checkExpressionValueIsNotNull(encodeName, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                Intrinsics.checkExpressionValueIsNotNull(encodeName, "encodeName");
                return encodeName;
            }
            return (String) invokeL.objValue;
        }

        @JvmStatic
        public final File e(Context context, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) {
                if (str2 == null) {
                    str2 = new File(context.getFilesDir(), SwanKV.PREFS_SEGMENT).getAbsolutePath();
                }
                return new File(str2, c(str) + SwanKV.PREFS_SUFFIX);
            }
            return (File) invokeLLL.objValue;
        }

        @JvmStatic
        public final boolean f(Context context, b bVar, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, context, bVar, z)) == null) {
                nr1 nr1Var = new nr1(context);
                nr1Var.f(bVar);
                nr1Var.d(z);
                return g(nr1Var);
            }
            return invokeLLZ.booleanValue;
        }

        @JvmStatic
        public final void h(String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) {
                return;
            }
            SwanKV.nInitialize(str, z, z2);
        }

        @JvmStatic
        public final void i(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048582, this, i, str, str2) == null) {
                for (or1 or1Var : SwanKV.HANDLER_LISTENERS) {
                    or1Var.onKVCatchError(i, str, str2);
                }
            }
        }

        @JvmStatic
        public final boolean g(nr1 nr1Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, nr1Var)) == null) {
                if (!SwanKV.isInitFinish.compareAndSet(false, true)) {
                    return true;
                }
                if (nr1Var.c() != null) {
                    b c = nr1Var.c();
                    if (c == null) {
                        Intrinsics.throwNpe();
                    }
                    c.loadLibrary(SwanKV.LIB_SWANKV);
                } else {
                    System.loadLibrary(SwanKV.LIB_SWANKV);
                }
                File file = new File(nr1Var.getContext().getFilesDir(), SwanKV.PREFS_SEGMENT);
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
                h(absolutePath, nr1Var.a(), nr1Var.b());
                return true;
            }
            return invokeL.booleanValue;
        }
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
        Companion = new a(null);
        isInitFinish = new AtomicBoolean(false);
        HANDLER_LISTENERS = new Vector<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanKV(Context context, String str) {
        this(context, str, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanKV(Context context, String str, int i) {
        this(context, str, i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i)};
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
    }

    public SwanKV(Context context, String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.name = str;
        this.mode = i;
        this.rootPath = str2;
        if (i != 4) {
            if (!TextUtils.isEmpty(str2)) {
                File file = new File(this.rootPath);
                if ((!file.exists() || !file.isDirectory()) && !file.mkdirs() && !file.exists()) {
                    Log.e(LIB_SWANKV, "mkdirs fail: " + this.rootPath);
                    this.rootPath = "";
                }
            }
            this.nativeHandle = nGetHandle(Companion.c(this.name), this.mode, this.rootPath);
        }
    }

    public /* synthetic */ SwanKV(Context context, String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i2 & 4) != 0 ? 2 : i, (i2 & 8) != 0 ? null : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanKV(AshmemFileDescriptor ashmemFileDescriptor) {
        this(null, ashmemFileDescriptor.getName(), 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ashmemFileDescriptor};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.nativeHandle = nGetAshmemHandle(Companion.c(this.name), ashmemFileDescriptor.getAshmemFD(), ashmemFileDescriptor.getSize());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanKV(String str) {
        this(null, str, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65542, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanKV(String str, int i) {
        this(null, str, i, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65543, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    public boolean clearAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return nClean(this.nativeHandle);
        }
        return invokeV.booleanValue;
    }

    public long contentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return nContentSize(this.nativeHandle);
        }
        return invokeV.longValue;
    }

    @NonNull
    public String[] getAllKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String[] nGetAllKeys = nGetAllKeys(this.nativeHandle);
            if (nGetAllKeys == null) {
                return new String[0];
            }
            return nGetAllKeys;
        }
        return (String[]) invokeV.objValue;
    }

    @NonNull
    public HashMap<String, Integer> getAllTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HashMap<String, Integer> nGetAllType = nGetAllType(this.nativeHandle);
            if (nGetAllType == null) {
                return new HashMap<>();
            }
            return nGetAllType;
        }
        return (HashMap) invokeV.objValue;
    }

    public File getFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return new File(nGetFilePath(this.nativeHandle));
        }
        return (File) invokeV.objValue;
    }

    public int getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mode;
        }
        return invokeV.intValue;
    }

    public final String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.name;
        }
        return (String) invokeV.objValue;
    }

    public final String getRootPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.rootPath;
        }
        return (String) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            nRelease(this.nativeHandle);
            this.nativeHandle = 0L;
        }
    }

    public void trim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            nTrim(this.nativeHandle);
        }
    }

    public boolean containKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null) {
                return false;
            }
            return nContainKey(this.nativeHandle, str);
        }
        return invokeL.booleanValue;
    }

    public byte[] getBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return nGetBytes(this.nativeHandle, str);
        }
        return (byte[]) invokeL.objValue;
    }

    public String[] getStringArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            return nGetStringArray(this.nativeHandle, str);
        }
        return (String[]) invokeL.objValue;
    }

    public boolean removeKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            return nRemove(this.nativeHandle, str);
        }
        return invokeL.booleanValue;
    }

    public final void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.name = str;
        }
    }

    public final void setRootPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.rootPath = str;
        }
    }

    public void sync(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            nSync(this.nativeHandle, z);
        }
    }

    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap<String, Integer> nGetAllType = nGetAllType(this.nativeHandle);
            if (nGetAllType != null && !nGetAllType.isEmpty()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, Integer> entry : nGetAllType.entrySet()) {
                    String key = entry.getKey();
                    Object obj = null;
                    switch (entry.getValue().intValue()) {
                        case 0:
                            obj = (Serializable) getBytes(key);
                            break;
                        case 1:
                            obj = Boolean.valueOf(getBool(key, false));
                            break;
                        case 2:
                            obj = Integer.valueOf(getInt(key, 0));
                            break;
                        case 3:
                            obj = Float.valueOf(getFloat(key, 0.0f));
                            break;
                        case 4:
                            obj = Double.valueOf(getDouble(key, 0.0d));
                            break;
                        case 5:
                            obj = Short.valueOf(getShort(key, (short) 0));
                            break;
                        case 6:
                            obj = Long.valueOf(getLong(key, 0L));
                            break;
                        case 7:
                            obj = getString(key, null);
                            break;
                        case 8:
                            obj = (Serializable) getStringArray(key);
                            break;
                        case 9:
                            obj = (Serializable) getBytes(key);
                            break;
                    }
                    linkedHashMap.put(key, obj);
                }
                return linkedHashMap;
            }
            return MapsKt__MapsKt.emptyMap();
        }
        return (Map) invokeV.objValue;
    }

    public boolean getBool(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            return nGetBool(this.nativeHandle, str, z);
        }
        return invokeLZ.booleanValue;
    }

    public double getDouble(String str, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, Double.valueOf(d)})) == null) {
            return nGetDouble(this.nativeHandle, str, d);
        }
        return invokeCommon.doubleValue;
    }

    public float getFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048587, this, str, f)) == null) {
            return nGetFloat(this.nativeHandle, str, f);
        }
        return invokeLF.floatValue;
    }

    public int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i)) == null) {
            return nGetInt(this.nativeHandle, str, i);
        }
        return invokeLI.intValue;
    }

    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048589, this, str, j)) == null) {
            return nGetLong(this.nativeHandle, str, j);
        }
        return invokeLJ.longValue;
    }

    public short getShort(String str, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{str, Short.valueOf(s)})) == null) {
            return nGetShort(this.nativeHandle, str, s);
        }
        return invokeCommon.shortValue;
    }

    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, str2)) == null) {
            byte[] nGetBytes = nGetBytes(this.nativeHandle, str);
            if (nGetBytes != null) {
                return new String(nGetBytes, Charsets.UTF_8);
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x001b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.Set<java.lang.String>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.Set<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.HashSet] */
    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, set)) == null) {
            String[] stringArray = getStringArray(str);
            if (stringArray != null) {
                set = new HashSet<>();
                for (String str2 : stringArray) {
                    set.add(str2);
                }
            }
            return set;
        }
        return (Set) invokeLL.objValue;
    }

    public boolean writeBool(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048607, this, str, z)) == null) {
            return nWriteBool(this.nativeHandle, str, z);
        }
        return invokeLZ.booleanValue;
    }

    public boolean writeBytes(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, str, bArr)) == null) {
            if (bArr == null) {
                return removeKey(str);
            }
            return nWriteBytes(this.nativeHandle, str, bArr);
        }
        return invokeLL.booleanValue;
    }

    public boolean writeDouble(String str, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{str, Double.valueOf(d)})) == null) {
            return nWriteDouble(this.nativeHandle, str, d);
        }
        return invokeCommon.booleanValue;
    }

    public boolean writeFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048610, this, str, f)) == null) {
            return nWriteFloat(this.nativeHandle, str, f);
        }
        return invokeLF.booleanValue;
    }

    public boolean writeInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048611, this, str, i)) == null) {
            return nWriteInt(this.nativeHandle, str, i);
        }
        return invokeLI.booleanValue;
    }

    public boolean writeLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048612, this, str, j)) == null) {
            return nWriteLong(this.nativeHandle, str, j);
        }
        return invokeLJ.booleanValue;
    }

    public boolean writeShort(String str, short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{str, Short.valueOf(s)})) == null) {
            return nWriteShort(this.nativeHandle, str, s);
        }
        return invokeCommon.booleanValue;
    }

    public boolean writeString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, str, str2)) == null) {
            if (str2 == null) {
                return removeKey(str);
            }
            return nWriteString(this.nativeHandle, str, str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean writeStringArray(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048616, this, str, strArr)) == null) {
            if (strArr == null) {
                return removeKey(str);
            }
            return nWriteStringArray(this.nativeHandle, str, strArr);
        }
        return invokeLL.booleanValue;
    }

    public boolean writeStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, str, set)) == null) {
            if (set == null) {
                return removeKey(str);
            }
            Object[] array = set.toArray(new String[0]);
            if (array != null) {
                return writeStringArray(str, (String[]) array);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return invokeLL.booleanValue;
    }

    public <T extends Parcelable> T getParcel(String str, Parcelable.Creator<T> creator) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, creator)) == null) {
            byte[] bytes = getBytes(str);
            if (bytes != null) {
                if (bytes.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    Parcel obtain = Parcel.obtain();
                    Intrinsics.checkExpressionValueIsNotNull(obtain, "Parcel.obtain()");
                    obtain.unmarshall(bytes, 0, bytes.length);
                    obtain.setDataPosition(0);
                    return creator.createFromParcel(obtain);
                }
                return null;
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public boolean writeParcel(String str, Parcelable parcelable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048613, this, str, parcelable)) == null) {
            if (parcelable == null) {
                return removeKey(str);
            }
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkExpressionValueIsNotNull(obtain, "Parcel.obtain()");
            parcelable.writeToParcel(obtain, parcelable.describeContents());
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return writeBytes(str, marshall);
        }
        return invokeLL.booleanValue;
    }

    public void importFromMap(Map<String, ? extends Object> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, map, z) == null) {
            nLockThread(true);
            try {
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (key != null && value != null && (z || !containKey(key))) {
                        if (value instanceof Boolean) {
                            writeBool(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof String) {
                            writeString(key, (String) value);
                        } else if (value instanceof Integer) {
                            writeInt(key, ((Number) value).intValue());
                        } else if (value instanceof Float) {
                            writeFloat(key, ((Number) value).floatValue());
                        } else if (value instanceof Double) {
                            writeDouble(key, ((Number) value).doubleValue());
                        } else if (value instanceof Long) {
                            writeLong(key, ((Number) value).longValue());
                        } else if (value instanceof Set) {
                            writeStringSet(key, TypeIntrinsics.asMutableSet(value));
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("SharedPreferenceImpl", "importFromSharedPreferences", e);
            }
            nLockThread(false);
        }
    }
}
