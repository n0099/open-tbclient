package com.angcyo.tablayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.de7;
import com.baidu.tieba.m0;
import com.baidu.tieba.n0;
import com.baidu.tieba.o0;
import com.baidu.tieba.p0;
import com.baidu.tieba.r0;
import com.baidu.tieba.s0;
import com.baidu.tieba.u0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0002°\u0002B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010Ì\u0001\u001a\u00030Í\u00012\u0007\u0010Î\u0001\u001a\u00020\b2\u0007\u0010Ï\u0001\u001a\u00020\bJ\u0007\u0010Ð\u0001\u001a\u00020\bJ\u0007\u0010Ñ\u0001\u001a\u00020\bJ\b\u0010Ò\u0001\u001a\u00030Í\u0001J\u0012\u0010Ó\u0001\u001a\u00030Í\u00012\b\u0010\u0093\u0001\u001a\u00030Ô\u0001J\u001a\u0010Õ\u0001\u001a\u00030Í\u00012\u0007\u0010\u0087\u0001\u001a\u00020\b2\u0007\u0010Ö\u0001\u001a\u00020BJ\n\u0010×\u0001\u001a\u00030Í\u0001H\u0016J(\u0010Ø\u0001\u001a\u00030Í\u00012\u001e\b\u0002\u0010Ù\u0001\u001a\u0017\u0012\u0005\u0012\u00030Æ\u0001\u0012\u0005\u0012\u00030Í\u00010Ú\u0001¢\u0006\u0003\bÛ\u0001J\u0014\u0010Ü\u0001\u001a\u00030Í\u00012\b\u0010Ý\u0001\u001a\u00030Þ\u0001H\u0016J&\u0010ß\u0001\u001a\u00020B2\b\u0010Ý\u0001\u001a\u00030Þ\u00012\u0007\u0010\u0084\u0001\u001a\u00020>2\b\u0010à\u0001\u001a\u00030Á\u0001H\u0014J\n\u0010á\u0001\u001a\u00030â\u0001H\u0014J\u0015\u0010ã\u0001\u001a\u00030â\u00012\t\u0010ä\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010ã\u0001\u001a\u00030â\u00012\n\u0010å\u0001\u001a\u0005\u0018\u00010â\u0001H\u0014J\u0011\u0010æ\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u0087\u0001\u001a\u00020\bJ\u0007\u0010ç\u0001\u001a\u00020BJ5\u0010è\u0001\u001a\u00030Í\u00012\u0007\u0010é\u0001\u001a\u00020B2\u0007\u0010ê\u0001\u001a\u00020\b2\u0007\u0010ë\u0001\u001a\u00020\b2\u0007\u0010ì\u0001\u001a\u00020\b2\u0007\u0010í\u0001\u001a\u00020\bJ5\u0010î\u0001\u001a\u00030Í\u00012\u0007\u0010é\u0001\u001a\u00020B2\u0007\u0010ê\u0001\u001a\u00020\b2\u0007\u0010ë\u0001\u001a\u00020\b2\u0007\u0010ì\u0001\u001a\u00020\b2\u0007\u0010í\u0001\u001a\u00020\bJ\u001a\u0010ï\u0001\u001a\u00030Í\u00012\u0007\u0010ð\u0001\u001a\u00020\b2\u0007\u0010ñ\u0001\u001a\u00020\bJ\u001a\u0010ò\u0001\u001a\u00030Í\u00012\u0007\u0010ð\u0001\u001a\u00020\b2\u0007\u0010ñ\u0001\u001a\u00020\bJ\u0099\u0001\u0010ó\u0001\u001a\u00030Í\u00012\u001e\b\u0002\u0010Ù\u0001\u001a\u0017\u0012\u0005\u0012\u00030Æ\u0001\u0012\u0005\u0012\u00030Í\u00010Ú\u0001¢\u0006\u0003\bÛ\u00012o\u0010ô\u0001\u001aj\u0012\u0016\u0012\u00140\b¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(Î\u0001\u0012\u0016\u0012\u00140\b¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(Ï\u0001\u0012\u0016\u0012\u00140B¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(ö\u0001\u0012\u0016\u0012\u00140B¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(÷\u0001\u0012\u0005\u0012\u00030Í\u00010õ\u0001J\n\u0010ø\u0001\u001a\u00030Í\u0001H\u0014J\n\u0010ù\u0001\u001a\u00030Í\u0001H\u0014J\u0014\u0010ú\u0001\u001a\u00030Í\u00012\b\u0010Ý\u0001\u001a\u00030Þ\u0001H\u0014J\n\u0010û\u0001\u001a\u00030Í\u0001H\u0014J\u0014\u0010ü\u0001\u001a\u00030Í\u00012\b\u0010ý\u0001\u001a\u00030Ô\u0001H\u0016J\u0013\u0010þ\u0001\u001a\u00020B2\b\u0010ÿ\u0001\u001a\u00030\u0080\u0002H\u0016J7\u0010\u0081\u0002\u001a\u00030Í\u00012\u0007\u0010é\u0001\u001a\u00020B2\u0007\u0010ê\u0001\u001a\u00020\b2\u0007\u0010ë\u0001\u001a\u00020\b2\u0007\u0010ì\u0001\u001a\u00020\b2\u0007\u0010í\u0001\u001a\u00020\bH\u0014J\u001c\u0010\u0082\u0002\u001a\u00030Í\u00012\u0007\u0010ð\u0001\u001a\u00020\b2\u0007\u0010ñ\u0001\u001a\u00020\bH\u0014J\u0011\u0010\u0083\u0002\u001a\u00030Í\u00012\u0007\u0010\u0084\u0002\u001a\u00020\bJ$\u0010\u0085\u0002\u001a\u00030Í\u00012\u0007\u0010\u0086\u0002\u001a\u00020\b2\b\u0010\u0087\u0002\u001a\u00030Ô\u00012\u0007\u0010\u0088\u0002\u001a\u00020\bJ\u0011\u0010\u0089\u0002\u001a\u00030Í\u00012\u0007\u0010\u0086\u0002\u001a\u00020\bJ\u0016\u0010\u008a\u0002\u001a\u00030Í\u00012\n\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u008b\u0002H\u0014J\u0013\u0010\u008c\u0002\u001a\u00030Í\u00012\u0007\u0010\u008d\u0002\u001a\u00020\bH\u0016J\f\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008b\u0002H\u0014J\u0013\u0010\u008f\u0002\u001a\u00020B2\b\u0010\u0090\u0002\u001a\u00030Ô\u0001H\u0016J.\u0010\u0091\u0002\u001a\u00030Í\u00012\u0007\u0010\u0092\u0002\u001a\u00020\b2\u0007\u0010\u0093\u0002\u001a\u00020\b2\u0007\u0010\u0094\u0002\u001a\u00020\b2\u0007\u0010\u0095\u0002\u001a\u00020\bH\u0014J\u0013\u0010\u0096\u0002\u001a\u00020B2\b\u0010\u0097\u0002\u001a\u00030\u0080\u0002H\u0016J\u0015\u0010\u0098\u0002\u001a\u00030Í\u00012\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010>H\u0016J\u0015\u0010\u0099\u0002\u001a\u00030Í\u00012\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010>H\u0016J\b\u0010\u009a\u0002\u001a\u00030Í\u0001J\u001c\u0010\u009b\u0002\u001a\u00030Í\u00012\u0007\u0010\u009c\u0002\u001a\u00020\b2\u0007\u0010\u009d\u0002\u001a\u00020\bH\u0016J'\u0010\u009e\u0002\u001a\u00030Í\u00012\u0007\u0010\u0087\u0001\u001a\u00020\b2\t\b\u0002\u0010\u009f\u0002\u001a\u00020B2\t\b\u0002\u0010÷\u0001\u001a\u00020BJ4\u0010Ê\u0001\u001a\u00030Í\u00012\n\b\u0002\u0010Ù\u0001\u001a\u00030Æ\u00012\u001e\b\u0002\u0010 \u0002\u001a\u0017\u0012\u0005\u0012\u00030Æ\u0001\u0012\u0005\u0012\u00030Í\u00010Ú\u0001¢\u0006\u0003\bÛ\u0001J\u0011\u0010¡\u0002\u001a\u00030Í\u00012\u0007\u0010¢\u0002\u001a\u000201J#\u0010£\u0002\u001a\u00030Í\u00012\u0007\u0010ý\u0001\u001a\u00020\b2\u0007\u0010¤\u0002\u001a\u00020\b2\u0007\u0010¥\u0002\u001a\u00020\bJ\u0011\u0010¦\u0002\u001a\u00030Í\u00012\u0007\u0010§\u0002\u001a\u00020\bJ/\u0010¨\u0002\u001a\u00030Í\u00012\u0007\u0010\u0087\u0001\u001a\u00020\b2\u001c\u0010Ù\u0001\u001a\u0017\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0005\u0012\u00030Í\u00010Ú\u0001¢\u0006\u0003\bÛ\u0001J\u001d\u0010¨\u0002\u001a\u00030Í\u00012\u0007\u0010\u0087\u0001\u001a\u00020\b2\n\u0010©\u0002\u001a\u0005\u0018\u00010ª\u0002J\n\u0010«\u0002\u001a\u00030Í\u0001H\u0016J\u0013\u0010¬\u0002\u001a\u00020B2\b\u0010\u00ad\u0002\u001a\u00030£\u0001H\u0014J\u001e\u0010®\u0002\u001a\u00030Í\u0001*\u00030Þ\u00012\u000f\u0010ô\u0001\u001a\n\u0012\u0005\u0012\u00030Í\u00010¯\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b&\u0010'R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\n\"\u0004\b/\u0010\fR\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\n\"\u0004\b8\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010;\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b<\u0010\nR\u0013\u0010=\u001a\u0004\u0018\u00010>8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR\u001a\u0010J\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010D\"\u0004\bL\u0010FR\u001a\u0010M\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010D\"\u0004\bO\u0010FR\u001a\u0010P\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010D\"\u0004\bR\u0010FR\u001b\u0010S\u001a\u00020T8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u0012\u001a\u0004\bU\u0010VR\u0011\u0010X\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\bX\u0010DR\u0011\u0010Y\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\bY\u0010DR\u001a\u0010Z\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010D\"\u0004\b\\\u0010FR\u001a\u0010]\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\n\"\u0004\b_\u0010\fR\u001a\u0010`\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010D\"\u0004\bb\u0010FR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010D\"\u0004\bk\u0010FR\u001a\u0010l\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\n\"\u0004\bn\u0010\fR\u001a\u0010o\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010D\"\u0004\bq\u0010FR\u0011\u0010r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bs\u0010\nR\u0011\u0010t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bu\u0010\nR\u0011\u0010v\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bw\u0010\nR\u0011\u0010x\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\by\u0010\nR\u0011\u0010z\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b{\u0010\nR\u0011\u0010|\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b}\u0010\nR\u0011\u0010~\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\b\u007f\u0010DRr\u0010\u0080\u0001\u001aU\u0012\u0016\u0012\u00140>¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u0017\u0012\u00150\u0085\u0001¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0086\u0001\u0012\u0016\u0012\u00140\b¢\u0006\u000f\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0087\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0088\u00010\u0081\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001d\u0010\u008d\u0001\u001a\u00020\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\n\"\u0005\b\u008f\u0001\u0010\fR\u001d\u0010\u0090\u0001\u001a\u00020\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\n\"\u0005\b\u0092\u0001\u0010\fR0\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0085\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\"\u0010\u0098\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0005\u0012\u00030\u0088\u00010\u0099\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R0\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u009c\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R\"\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R\u001d\u0010¨\u0001\u001a\u00020\bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010\n\"\u0005\bª\u0001\u0010\fR0\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010«\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R\u001d\u0010±\u0001\u001a\u00020BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010D\"\u0005\b³\u0001\u0010FR0\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010´\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R,\u0010»\u0001\u001a\u00030º\u00012\b\u0010\u0093\u0001\u001a\u00030º\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R \u0010À\u0001\u001a\u00030Á\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R0\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010Æ\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001¨\u0006±\u0002"}, d2 = {"Lcom/angcyo/tablayout/DslTabLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_childAllWidthSum", "", "get_childAllWidthSum", "()I", "set_childAllWidthSum", "(I)V", "_gestureDetector", "Landroidx/core/view/GestureDetectorCompat;", "get_gestureDetector", "()Landroidx/core/view/GestureDetectorCompat;", "_gestureDetector$delegate", "Lkotlin/Lazy;", "_layoutDirection", "get_layoutDirection", "set_layoutDirection", "_maxConvexHeight", "get_maxConvexHeight", "set_maxConvexHeight", "_maxFlingVelocity", "get_maxFlingVelocity", "set_maxFlingVelocity", "_minFlingVelocity", "get_minFlingVelocity", "set_minFlingVelocity", "_overScroller", "Landroid/widget/OverScroller;", "get_overScroller", "()Landroid/widget/OverScroller;", "_overScroller$delegate", "_scrollAnimator", "Landroid/animation/ValueAnimator;", "get_scrollAnimator", "()Landroid/animation/ValueAnimator;", "_scrollAnimator$delegate", "_tempRect", "Landroid/graphics/Rect;", "get_tempRect", "()Landroid/graphics/Rect;", "_touchSlop", "get_touchSlop", "set_touchSlop", "_viewPagerDelegate", "Lcom/angcyo/tablayout/ViewPagerDelegate;", "get_viewPagerDelegate", "()Lcom/angcyo/tablayout/ViewPagerDelegate;", "set_viewPagerDelegate", "(Lcom/angcyo/tablayout/ViewPagerDelegate;)V", "_viewPagerScrollState", "get_viewPagerScrollState", "set_viewPagerScrollState", "getAttributeSet", "()Landroid/util/AttributeSet;", "currentItemIndex", "getCurrentItemIndex", "currentItemView", "Landroid/view/View;", "getCurrentItemView", "()Landroid/view/View;", "drawBadge", "", "getDrawBadge", "()Z", "setDrawBadge", "(Z)V", "drawBorder", "getDrawBorder", "setDrawBorder", "drawDivider", "getDrawDivider", "setDrawDivider", "drawHighlight", "getDrawHighlight", "setDrawHighlight", "drawIndicator", "getDrawIndicator", "setDrawIndicator", "dslSelector", "Lcom/angcyo/tablayout/DslSelector;", "getDslSelector", "()Lcom/angcyo/tablayout/DslSelector;", "dslSelector$delegate", "isAnimatorStart", "isLayoutRtl", "itemAutoEquWidth", "getItemAutoEquWidth", "setItemAutoEquWidth", "itemDefaultHeight", "getItemDefaultHeight", "setItemDefaultHeight", "itemEnableSelector", "getItemEnableSelector", "setItemEnableSelector", "itemEquWidthCountRange", "Lkotlin/ranges/IntRange;", "getItemEquWidthCountRange", "()Lkotlin/ranges/IntRange;", "setItemEquWidthCountRange", "(Lkotlin/ranges/IntRange;)V", "itemIsEquWidth", "getItemIsEquWidth", "setItemIsEquWidth", "itemWidth", "getItemWidth", "setItemWidth", "layoutScrollAnim", "getLayoutScrollAnim", "setLayoutScrollAnim", "maxHeight", "getMaxHeight", "maxScrollX", "getMaxScrollX", "maxScrollY", "getMaxScrollY", "maxWidth", "getMaxWidth", "minScrollX", "getMinScrollX", "minScrollY", "getMinScrollY", "needScroll", "getNeedScroll", "onTabBadgeConfig", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Lcom/angcyo/tablayout/DslTabBadge;", "tabBadge", "index", "Lcom/angcyo/tablayout/TabBadgeConfig;", "getOnTabBadgeConfig", "()Lkotlin/jvm/functions/Function3;", "setOnTabBadgeConfig", "(Lkotlin/jvm/functions/Function3;)V", "orientation", "getOrientation", com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.p, "scrollAnimDuration", "getScrollAnimDuration", "setScrollAnimDuration", "value", "getTabBadge", "()Lcom/angcyo/tablayout/DslTabBadge;", "setTabBadge", "(Lcom/angcyo/tablayout/DslTabBadge;)V", "tabBadgeConfigMap", "", "getTabBadgeConfigMap", "()Ljava/util/Map;", "Lcom/angcyo/tablayout/DslTabBorder;", "tabBorder", "getTabBorder", "()Lcom/angcyo/tablayout/DslTabBorder;", "setTabBorder", "(Lcom/angcyo/tablayout/DslTabBorder;)V", "tabConvexBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getTabConvexBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setTabConvexBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "tabDefaultIndex", "getTabDefaultIndex", "setTabDefaultIndex", "Lcom/angcyo/tablayout/DslTabDivider;", "tabDivider", "getTabDivider", "()Lcom/angcyo/tablayout/DslTabDivider;", "setTabDivider", "(Lcom/angcyo/tablayout/DslTabDivider;)V", "tabEnableSelectorMode", "getTabEnableSelectorMode", "setTabEnableSelectorMode", "Lcom/angcyo/tablayout/DslTabHighlight;", "tabHighlight", "getTabHighlight", "()Lcom/angcyo/tablayout/DslTabHighlight;", "setTabHighlight", "(Lcom/angcyo/tablayout/DslTabHighlight;)V", "Lcom/angcyo/tablayout/DslTabIndicator;", "tabIndicator", "getTabIndicator", "()Lcom/angcyo/tablayout/DslTabIndicator;", "setTabIndicator", "(Lcom/angcyo/tablayout/DslTabIndicator;)V", "tabIndicatorAnimationDuration", "", "getTabIndicatorAnimationDuration", "()J", "setTabIndicatorAnimationDuration", "(J)V", "Lcom/angcyo/tablayout/DslTabLayoutConfig;", "tabLayoutConfig", "getTabLayoutConfig", "()Lcom/angcyo/tablayout/DslTabLayoutConfig;", "setTabLayoutConfig", "(Lcom/angcyo/tablayout/DslTabLayoutConfig;)V", "_animateToItem", "", "fromIndex", "toIndex", "_getViewTargetX", "_getViewTargetY", "_onAnimateEnd", "_onAnimateValue", "", "_scrollToTarget", "scrollAnim", "computeScroll", "configTabLayoutConfig", "config", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw", "canvas", "Landroid/graphics/Canvas;", "drawChild", "drawingTime", "generateDefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "attrs", "p", "getBadgeConfig", "isHorizontal", "layoutHorizontal", "changed", "l", "t", "r", "b", "layoutVertical", "measureHorizontal", "widthMeasureSpec", "heightMeasureSpec", "measureVertical", "observeIndexChange", "action", "Lkotlin/Function4;", "reselect", "fromUser", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "onFinishInflate", "onFlingChange", "velocity", "onInterceptTouchEvent", Config.EVENT_PART, "Landroid/view/MotionEvent;", "onLayout", "onMeasure", "onPageScrollStateChanged", "state", "onPageScrolled", CriusAttrConstants.POSITION, "positionOffset", "positionOffsetPixels", "onPageSelected", "onRestoreInstanceState", "Landroid/os/Parcelable;", "onRtlPropertiesChanged", "layoutDirection", "onSaveInstanceState", "onScrollChange", "distance", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "onViewAdded", "onViewRemoved", "restoreScroll", "scrollTo", "x", "y", com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.o, "notify", "doIt", "setupViewPager", "viewPagerDelegate", "startFling", "min", FunAdSdk.PLATFORM_MAX, "startScroll", "dv", "updateTabBadge", "badgeText", "", "updateTabLayout", "verifyDrawable", "who", "holdLocation", "Lkotlin/Function0;", "LayoutParams", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class DslTabLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public final Rect E;
    public final Lazy F;
    public int G;
    public int H;
    public int I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public u0 M;
    public int N;
    public final AttributeSet a;
    public int b;
    public boolean c;
    public boolean d;
    public IntRange e;
    public boolean f;
    public int g;
    public boolean h;
    public DslTabIndicator i;
    public long j;
    public int k;
    public DslTabLayoutConfig l;
    public DslTabBorder m;
    public boolean n;
    public o0 o;
    public boolean p;
    public n0 q;
    public boolean r;
    public final Map<Integer, s0> s;
    public Function3<? super View, ? super n0, ? super Integer, s0> t;
    public boolean u;
    public p0 v;
    public Drawable w;
    public boolean x;
    public int y;
    public boolean z;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rB\u001f\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010'\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R\u001a\u0010*\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001a\u00106\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/angcyo/tablayout/DslTabLayout$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "source", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "width", "", "height", "(II)V", NotificationCompat.WearableExtender.KEY_GRAVITY, "(III)V", "contentIconViewId", "getContentIconViewId", "()I", "setContentIconViewId", "(I)V", "contentIconViewIndex", "getContentIconViewIndex", "setContentIconViewIndex", "contentTextViewId", "getContentTextViewId", "setContentTextViewId", "contentTextViewIndex", "getContentTextViewIndex", "setContentTextViewIndex", "highlightDrawable", "Landroid/graphics/drawable/Drawable;", "getHighlightDrawable", "()Landroid/graphics/drawable/Drawable;", "setHighlightDrawable", "(Landroid/graphics/drawable/Drawable;)V", "indicatorContentId", "getIndicatorContentId", "setIndicatorContentId", "indicatorContentIndex", "getIndicatorContentIndex", "setIndicatorContentIndex", "layoutConvexHeight", "getLayoutConvexHeight", "setLayoutConvexHeight", "layoutHeight", "", "getLayoutHeight", "()Ljava/lang/String;", "setLayoutHeight", "(Ljava/lang/String;)V", "layoutWidth", "getLayoutWidth", "setLayoutWidth", "weight", "", "getWeight", "()F", "setWeight", "(F)V", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class LayoutParams extends FrameLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public float j;
        public Drawable k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2, int i3) {
            super(i, i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context c, AttributeSet attributeSet) {
            super(c, attributeSet);
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c, attributeSet};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(c, "c");
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1.0f;
            TypedArray obtainStyledAttributes = c.obtainStyledAttributes(attributeSet, de7.DslTabLayout_Layout);
            this.a = obtainStyledAttributes.getString(10);
            this.b = obtainStyledAttributes.getString(2);
            this.c = obtainStyledAttributes.getDimensionPixelOffset(1, this.c);
            this.d = obtainStyledAttributes.getInt(6, this.d);
            this.e = obtainStyledAttributes.getResourceId(5, this.e);
            this.j = obtainStyledAttributes.getFloat(9, this.j);
            this.k = obtainStyledAttributes.getDrawable(0);
            this.f = obtainStyledAttributes.getInt(8, this.f);
            this.h = obtainStyledAttributes.getInt(8, this.h);
            this.g = obtainStyledAttributes.getResourceId(7, this.g);
            this.i = obtainStyledAttributes.getResourceId(3, this.h);
            obtainStyledAttributes.recycle();
            if (((FrameLayout.LayoutParams) this).gravity == -1) {
                if (this.c > 0) {
                    i = 80;
                } else {
                    i = 17;
                }
                ((FrameLayout.LayoutParams) this).gravity = i;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {source};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(source, "source");
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1.0f;
            if (source instanceof LayoutParams) {
                LayoutParams layoutParams = (LayoutParams) source;
                this.a = layoutParams.a;
                this.b = layoutParams.b;
                this.c = layoutParams.c;
                this.j = layoutParams.j;
                this.k = layoutParams.k;
            }
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.i;
            }
            return invokeV.intValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.h;
            }
            return invokeV.intValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.g;
            }
            return invokeV.intValue;
        }

        public final int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.f;
            }
            return invokeV.intValue;
        }

        public final Drawable e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.k;
            }
            return (Drawable) invokeV.objValue;
        }

        public final int f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.e;
            }
            return invokeV.intValue;
        }

        public final int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }

        public final int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        public final String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public final String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public final float k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.j;
            }
            return invokeV.floatValue;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.CharSequence : 0x01cf: INVOKE  (r8v0 java.lang.CharSequence A[REMOVE]) = (r6v3 android.widget.TextView) type: VIRTUAL call: android.widget.TextView.getText():java.lang.CharSequence)), (wrap: char : ?: SGET   com.google.android.exoplayer2.text.webvtt.WebvttCueParser.CHAR_SLASH char), (r4v7 int)] */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DslTabLayout(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        boolean z2;
        int i;
        Integer intOrNull;
        int i2;
        Integer intOrNull2;
        Integer intOrNull3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.a = attributeSet;
        this.b = r0.j(this) * 40;
        this.d = true;
        this.g = -3;
        this.h = true;
        this.i = new DslTabIndicator(this);
        this.j = 240L;
        this.s = new LinkedHashMap();
        this.t = new Function3<View, n0, Integer, s0>(this) { // from class: com.angcyo.tablayout.DslTabLayout$onTabBadgeConfig$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DslTabLayout this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            public final s0 invoke(View view2, n0 tabBadge, int i5) {
                InterceptResult invokeLLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLLI = interceptable2.invokeLLI(1048576, this, view2, tabBadge, i5)) == null) {
                    Intrinsics.checkNotNullParameter(view2, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(tabBadge, "tabBadge");
                    s0 h = this.this$0.h(i5);
                    if (!this.this$0.isInEditMode()) {
                        tabBadge.z0(h);
                    }
                    return h;
                }
                return (s0) invokeLLI.objValue;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ s0 invoke(View view2, n0 n0Var, Integer num) {
                return invoke(view2, n0Var, num.intValue());
            }
        };
        this.A = 250;
        this.E = new Rect();
        this.F = LazyKt__LazyJVMKt.lazy(new Function0<m0>(this) { // from class: com.angcyo.tablayout.DslTabLayout$dslSelector$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DslTabLayout this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final m0 invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    m0 m0Var = new m0();
                    DslTabLayout dslTabLayout = this.this$0;
                    m0Var.h(dslTabLayout, new Function1<DslSelectorConfig, Unit>(dslTabLayout) { // from class: com.angcyo.tablayout.DslTabLayout$dslSelector$2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ DslTabLayout this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr3 = {dslTabLayout};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i5 = newInitContext2.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    super(((Integer) newInitContext2.callArgs[0]).intValue());
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$0 = dslTabLayout;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DslSelectorConfig dslSelectorConfig) {
                            invoke2(dslSelectorConfig);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(DslSelectorConfig install) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, install) == null) {
                                Intrinsics.checkNotNullParameter(install, "$this$install");
                                install.k(new Function3<View, Integer, Boolean, Unit>(this.this$0) { // from class: com.angcyo.tablayout.DslTabLayout.dslSelector.2.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ DslTabLayout this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                        Interceptable interceptable4 = $ic;
                                        if (interceptable4 != null) {
                                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                                            newInitContext2.initArgs = r2;
                                            Object[] objArr3 = {r7};
                                            interceptable4.invokeUnInit(65536, newInitContext2);
                                            int i5 = newInitContext2.flag;
                                            if ((i5 & 1) != 0) {
                                                int i6 = i5 & 2;
                                                super(((Integer) newInitContext2.callArgs[0]).intValue());
                                                newInitContext2.thisArg = this;
                                                interceptable4.invokeInitBody(65536, newInitContext2);
                                                return;
                                            }
                                        }
                                        this.this$0 = r7;
                                    }

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
                                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(View view2, Integer num, Boolean bool) {
                                        invoke(view2, num.intValue(), bool.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(View itemView, int i5, boolean z3) {
                                        Function3<View, Integer, Boolean, Unit> g;
                                        Interceptable interceptable4 = $ic;
                                        if (interceptable4 == null || interceptable4.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{itemView, Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) {
                                            Intrinsics.checkNotNullParameter(itemView, "itemView");
                                            DslTabLayoutConfig tabLayoutConfig = this.this$0.getTabLayoutConfig();
                                            if (tabLayoutConfig != null && (g = tabLayoutConfig.g()) != null) {
                                                g.invoke(itemView, Integer.valueOf(i5), Boolean.valueOf(z3));
                                            }
                                        }
                                    }
                                });
                                install.i(new Function4<View, Integer, Boolean, Boolean, Boolean>(this.this$0) { // from class: com.angcyo.tablayout.DslTabLayout.dslSelector.2.1.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ DslTabLayout this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                        Interceptable interceptable4 = $ic;
                                        if (interceptable4 != null) {
                                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                                            newInitContext2.initArgs = r2;
                                            Object[] objArr3 = {r7};
                                            interceptable4.invokeUnInit(65536, newInitContext2);
                                            int i5 = newInitContext2.flag;
                                            if ((i5 & 1) != 0) {
                                                int i6 = i5 & 2;
                                                super(((Integer) newInitContext2.callArgs[0]).intValue());
                                                newInitContext2.thisArg = this;
                                                interceptable4.invokeInitBody(65536, newInitContext2);
                                                return;
                                            }
                                        }
                                        this.this$0 = r7;
                                    }

                                    public final Boolean invoke(View itemView, int i5, boolean z3, boolean z4) {
                                        InterceptResult invokeCommon;
                                        boolean z5;
                                        Function4<View, Integer, Boolean, Boolean, Boolean> e;
                                        Interceptable interceptable4 = $ic;
                                        if (interceptable4 == null || (invokeCommon = interceptable4.invokeCommon(1048576, this, new Object[]{itemView, Integer.valueOf(i5), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
                                            Intrinsics.checkNotNullParameter(itemView, "itemView");
                                            DslTabLayoutConfig tabLayoutConfig = this.this$0.getTabLayoutConfig();
                                            if (tabLayoutConfig != null && (e = tabLayoutConfig.e()) != null) {
                                                z5 = e.invoke(itemView, Integer.valueOf(i5), Boolean.valueOf(z3), Boolean.valueOf(z4)).booleanValue();
                                            } else {
                                                z5 = false;
                                            }
                                            return Boolean.valueOf(z5);
                                        }
                                        return (Boolean) invokeCommon.objValue;
                                    }

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Boolean invoke(View view2, Integer num, Boolean bool, Boolean bool2) {
                                        return invoke(view2, num.intValue(), bool.booleanValue(), bool2.booleanValue());
                                    }
                                });
                                install.j(new Function4<View, List<? extends View>, Boolean, Boolean, Unit>(this.this$0) { // from class: com.angcyo.tablayout.DslTabLayout.dslSelector.2.1.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ DslTabLayout this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                        Interceptable interceptable4 = $ic;
                                        if (interceptable4 != null) {
                                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                                            newInitContext2.initArgs = r2;
                                            Object[] objArr3 = {r7};
                                            interceptable4.invokeUnInit(65536, newInitContext2);
                                            int i5 = newInitContext2.flag;
                                            if ((i5 & 1) != 0) {
                                                int i6 = i5 & 2;
                                                super(((Integer) newInitContext2.callArgs[0]).intValue());
                                                newInitContext2.thisArg = this;
                                                interceptable4.invokeInitBody(65536, newInitContext2);
                                                return;
                                            }
                                        }
                                        this.this$0 = r7;
                                    }

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(View view2, List<? extends View> list, Boolean bool, Boolean bool2) {
                                        invoke(view2, list, bool.booleanValue(), bool2.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(View view2, List<? extends View> selectViewList, boolean z3, boolean z4) {
                                        Function4<View, List<? extends View>, Boolean, Boolean, Unit> f;
                                        Interceptable interceptable4 = $ic;
                                        if (interceptable4 == null || interceptable4.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, selectViewList, Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
                                            Intrinsics.checkNotNullParameter(selectViewList, "selectViewList");
                                            DslTabLayoutConfig tabLayoutConfig = this.this$0.getTabLayoutConfig();
                                            if (tabLayoutConfig != null && (f = tabLayoutConfig.f()) != null) {
                                                f.invoke(view2, selectViewList, Boolean.valueOf(z3), Boolean.valueOf(z4));
                                            }
                                        }
                                    }
                                });
                                install.h(new Function4<Integer, List<? extends Integer>, Boolean, Boolean, Unit>(this.this$0) { // from class: com.angcyo.tablayout.DslTabLayout.dslSelector.2.1.4
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ DslTabLayout this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(4);
                                        Interceptable interceptable4 = $ic;
                                        if (interceptable4 != null) {
                                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                                            newInitContext2.initArgs = r2;
                                            Object[] objArr3 = {r7};
                                            interceptable4.invokeUnInit(65536, newInitContext2);
                                            int i5 = newInitContext2.flag;
                                            if ((i5 & 1) != 0) {
                                                int i6 = i5 & 2;
                                                super(((Integer) newInitContext2.callArgs[0]).intValue());
                                                newInitContext2.thisArg = this;
                                                interceptable4.invokeInitBody(65536, newInitContext2);
                                                return;
                                            }
                                        }
                                        this.this$0 = r7;
                                    }

                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
                                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, List<? extends Integer> list, Boolean bool, Boolean bool2) {
                                        invoke(num.intValue(), (List<Integer>) list, bool.booleanValue(), bool2.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int i5, List<Integer> selectList, boolean z3, boolean z4) {
                                        int i6;
                                        Function4<Integer, List<Integer>, Boolean, Boolean, Unit> d;
                                        Interceptable interceptable4 = $ic;
                                        if (interceptable4 == null || interceptable4.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i5), selectList, Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
                                            Intrinsics.checkNotNullParameter(selectList, "selectList");
                                            if (this.this$0.getTabLayoutConfig() == null) {
                                                r0.w("选择:[" + i5 + "]->" + selectList + " reselect:" + z3 + " fromUser:" + z4);
                                            }
                                            Integer num = (Integer) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) selectList);
                                            if (num != null) {
                                                i6 = num.intValue();
                                            } else {
                                                i6 = -1;
                                            }
                                            this.this$0.a(i5, i6);
                                            DslTabLayout dslTabLayout2 = this.this$0;
                                            dslTabLayout2.f(i6, dslTabLayout2.getTabIndicator().c0());
                                            this.this$0.postInvalidate();
                                            DslTabLayoutConfig tabLayoutConfig = this.this$0.getTabLayoutConfig();
                                            if (tabLayoutConfig != null && (d = tabLayoutConfig.d()) != null) {
                                                d.invoke(Integer.valueOf(i5), selectList, Boolean.valueOf(z3), Boolean.valueOf(z4));
                                                return;
                                            }
                                            u0 u0Var = this.this$0.get_viewPagerDelegate();
                                            if (u0Var != null) {
                                                u0Var.a(i5, i6, z3, z4);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    });
                    return m0Var;
                }
                return (m0) invokeV.objValue;
            }
        });
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.a, de7.DslTabLayout);
        this.c = obtainStyledAttributes.getBoolean(104, this.c);
        int i5 = obtainStyledAttributes.getInt(102, -1);
        int i6 = Integer.MAX_VALUE;
        if (i5 >= 0) {
            this.e = new IntRange(i5, Integer.MAX_VALUE);
        }
        if (obtainStyledAttributes.hasValue(103)) {
            String string = obtainStyledAttributes.getString(103);
            if (string != null && !StringsKt__StringsJVMKt.isBlank(string)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                this.e = null;
            } else {
                List split$default = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR}, false, 0, 6, (Object) null);
                if (r0.z(split$default) >= 2) {
                    String str = (String) CollectionsKt___CollectionsKt.getOrNull(split$default, 0);
                    if (str != null && (intOrNull3 = StringsKt__StringNumberConversionsKt.toIntOrNull(str)) != null) {
                        i2 = intOrNull3.intValue();
                    } else {
                        i2 = 0;
                    }
                    String str2 = (String) CollectionsKt___CollectionsKt.getOrNull(split$default, 1);
                    if (str2 != null && (intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str2)) != null) {
                        i6 = intOrNull2.intValue();
                    }
                    this.e = new IntRange(i2, i6);
                } else {
                    String str3 = (String) CollectionsKt___CollectionsKt.getOrNull(split$default, 0);
                    if (str3 != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str3)) != null) {
                        i = intOrNull.intValue();
                    } else {
                        i = Integer.MAX_VALUE;
                    }
                    this.e = new IntRange(i, Integer.MAX_VALUE);
                }
            }
        }
        this.f = obtainStyledAttributes.getBoolean(100, this.f);
        this.g = obtainStyledAttributes.getDimensionPixelOffset(105, this.g);
        this.b = obtainStyledAttributes.getDimensionPixelOffset(101, this.b);
        this.k = obtainStyledAttributes.getInt(35, this.k);
        this.h = obtainStyledAttributes.getBoolean(53, this.h);
        this.p = obtainStyledAttributes.getBoolean(51, this.p);
        this.n = obtainStyledAttributes.getBoolean(50, this.n);
        this.r = obtainStyledAttributes.getBoolean(49, this.r);
        this.u = obtainStyledAttributes.getBoolean(52, this.u);
        this.x = obtainStyledAttributes.getBoolean(60, this.x);
        this.w = obtainStyledAttributes.getDrawable(34);
        this.y = obtainStyledAttributes.getInt(109, this.y);
        this.z = obtainStyledAttributes.getBoolean(106, this.z);
        this.A = obtainStyledAttributes.getInt(112, this.A);
        if (isInEditMode()) {
            int resourceId = obtainStyledAttributes.getResourceId(111, -1);
            int i7 = obtainStyledAttributes.getInt(110, 3);
            if (resourceId != -1) {
                for (int i8 = 0; i8 < i7; i8++) {
                    View t = r0.t(this, resourceId, true);
                    if (t instanceof TextView) {
                        TextView textView = (TextView) t;
                        CharSequence text = textView.getText();
                        if (text != null && text.length() != 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            textView.setText("Item " + i8);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append((Object) textView.getText());
                            sb.append(WebvttCueParser.CHAR_SLASH);
                            sb.append(i8);
                            textView.setText(sb.toString());
                        }
                    }
                }
            }
        }
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.B = viewConfiguration.getScaledMinimumFlingVelocity();
        this.C = viewConfiguration.getScaledMaximumFlingVelocity();
        if (this.h) {
            this.i.k(context, this.a);
        }
        if (this.n) {
            setTabBorder(new DslTabBorder());
        }
        if (this.p) {
            setTabDivider(new o0());
        }
        if (this.r) {
            setTabBadge(new n0());
        }
        if (this.u) {
            setTabHighlight(new p0(this));
        }
        setTabLayoutConfig(new DslTabLayoutConfig(this));
        setWillNotDraw(false);
        this.I = -1;
        this.J = LazyKt__LazyJVMKt.lazy(new Function0<OverScroller>(context) { // from class: com.angcyo.tablayout.DslTabLayout$_overScroller$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i9 = newInitContext2.flag;
                    if ((i9 & 1) != 0) {
                        int i10 = i9 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OverScroller invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new OverScroller(this.$context);
                }
                return (OverScroller) invokeV.objValue;
            }
        });
        this.K = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetectorCompat>(context, this) { // from class: com.angcyo.tablayout.DslTabLayout$_gestureDetector$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ Context $context;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DslTabLayout this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context, this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i9 = newInitContext2.flag;
                    if ((i9 & 1) != 0) {
                        int i10 = i9 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
                this.this$0 = this;
            }

            /* loaded from: classes.dex */
            public static final class a extends GestureDetector.SimpleOnGestureListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DslTabLayout a;

                public a(DslTabLayout dslTabLayout) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {dslTabLayout};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = dslTabLayout;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent e1, MotionEvent e2, float f, float f2) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{e1, e2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                        Intrinsics.checkNotNullParameter(e1, "e1");
                        Intrinsics.checkNotNullParameter(e2, "e2");
                        if (this.a.k()) {
                            if (Math.abs(f) > this.a.get_minFlingVelocity()) {
                                this.a.t(f);
                                return true;
                            }
                            return true;
                        } else if (Math.abs(f2) > this.a.get_minFlingVelocity()) {
                            this.a.t(f2);
                            return true;
                        } else {
                            return true;
                        }
                    }
                    return invokeCommon.booleanValue;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float f, float f2) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{e1, e2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                        Intrinsics.checkNotNullParameter(e1, "e1");
                        Intrinsics.checkNotNullParameter(e2, "e2");
                        if (this.a.k()) {
                            if (Math.abs(f) > this.a.get_touchSlop()) {
                                return this.a.x(f);
                            }
                        } else if (Math.abs(f2) > this.a.get_touchSlop()) {
                            return this.a.x(f2);
                        }
                        return false;
                    }
                    return invokeCommon.booleanValue;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GestureDetectorCompat invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new GestureDetectorCompat(this.$context, new a(this.this$0));
                }
                return (GestureDetectorCompat) invokeV.objValue;
            }
        });
        this.L = LazyKt__LazyJVMKt.lazy(new DslTabLayout$_scrollAnimator$2(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0195  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int a;
        int i8;
        String str;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        boolean z2;
        o0 o0Var;
        boolean z3;
        int a2;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        o0 o0Var2;
        int i13;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048662, this, i, i2) == null) {
            int i14 = i;
            getDslSelector().r();
            List<View> g = getDslSelector().g();
            int size = g.size();
            if (size == 0) {
                if (getSuggestedMinimumHeight() > 0) {
                    i13 = getSuggestedMinimumHeight();
                } else {
                    i13 = this.b;
                }
                setMeasuredDimension(ViewGroup.getDefaultSize(i13, i14), ViewGroup.getDefaultSize(getSuggestedMinimumHeight(), i2));
                return;
            }
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.H = 0;
            Ref.IntRef intRef3 = new Ref.IntRef();
            intRef3.element = -1;
            Ref.IntRef intRef4 = new Ref.IntRef();
            intRef4.element = -1;
            if (mode2 == 0 && intRef2.element == 0) {
                intRef2.element = Integer.MAX_VALUE;
            }
            if (mode != 0) {
                if (mode == 1073741824) {
                    intRef4.element = r0.f((intRef.element - getPaddingStart()) - getPaddingEnd());
                }
            } else if (intRef.element == 0) {
                intRef.element = Integer.MAX_VALUE;
            }
            if (this.p && (o0Var2 = this.o) != null) {
                i3 = o0Var2.N() + o0Var2.R() + o0Var2.O();
            } else {
                i3 = 0;
            }
            String str2 = "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams";
            if (this.f) {
                int i15 = 0;
                int i16 = 0;
                for (Object obj : g) {
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    View view2 = (View) obj;
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams != null) {
                        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                        measureChild(view2, i14, i2);
                        i15 += ((FrameLayout.LayoutParams) layoutParams2).topMargin + ((FrameLayout.LayoutParams) layoutParams2).bottomMargin + view2.getMeasuredHeight();
                        if (this.p) {
                            o0 o0Var3 = this.o;
                            if (o0Var3 != null && o0Var3.V(i16, g.size())) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7) {
                                i15 += i3;
                            }
                            o0 o0Var4 = this.o;
                            if (o0Var4 != null && o0Var4.U(i16, g.size())) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (z8) {
                                i15 += i3;
                            }
                        }
                        i14 = i;
                        i16 = i17;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                    }
                }
                if (i15 <= intRef2.element) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.c = z6;
            }
            IntRange intRange = this.e;
            if (intRange != null) {
                this.c = intRange.contains(size);
            }
            if (this.c) {
                int i18 = this.g;
                if (i18 <= 0) {
                    int paddingTop = getPaddingTop() + getPaddingBottom();
                    int i19 = 0;
                    for (Object obj2 : g) {
                        int i20 = i19 + 1;
                        if (i19 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        View view3 = (View) obj2;
                        if (this.p) {
                            o0 o0Var5 = this.o;
                            if (o0Var5 != null && o0Var5.V(i19, g.size())) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                paddingTop += i3;
                            }
                            o0 o0Var6 = this.o;
                            if (o0Var6 != null && o0Var6.U(i19, g.size())) {
                                z5 = true;
                                if (z5) {
                                    paddingTop += i3;
                                }
                            }
                            z5 = false;
                            if (z5) {
                            }
                        }
                        ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                        if (layoutParams3 != null) {
                            LayoutParams layoutParams4 = (LayoutParams) layoutParams3;
                            paddingTop += ((FrameLayout.LayoutParams) layoutParams4).topMargin + ((FrameLayout.LayoutParams) layoutParams4).bottomMargin;
                            i19 = i20;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                        }
                    }
                    i18 = (intRef2.element - paddingTop) / size;
                }
                i5 = r0.f(i18);
                i4 = 0;
            } else {
                i4 = 0;
                i5 = -1;
            }
            this.G = i4;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            int i21 = 0;
            int i22 = 0;
            for (Object obj3 : g) {
                int i23 = i21 + 1;
                if (i21 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view4 = (View) obj3;
                ViewGroup.LayoutParams layoutParams5 = view4.getLayoutParams();
                if (layoutParams5 != null) {
                    LayoutParams layoutParams6 = (LayoutParams) layoutParams5;
                    if (layoutParams6.k() < 0.0f) {
                        i8 = i21;
                        i9 = i5;
                        z = true;
                        str = str2;
                        int[] b = r0.b(this, layoutParams6.j(), layoutParams6.i(), intRef.element, intRef2.element, 0, 0);
                        if (this.c) {
                            a2 = i9;
                        } else if (b[1] > 0) {
                            a2 = r0.f(b[1]);
                        } else {
                            int i24 = ((FrameLayout.LayoutParams) layoutParams6).height;
                            if (i24 == -1) {
                                a2 = r0.f((intRef2.element - getPaddingTop()) - getPaddingBottom());
                            } else if (i24 > 0) {
                                a2 = r0.f(i24);
                            } else {
                                a2 = r0.a((intRef2.element - getPaddingTop()) - getPaddingBottom());
                            }
                        }
                        intRef3.element = a2;
                        s(this, intRef, intRef2, booleanRef, intRef4, intRef3, view4);
                        i10 = view4.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams6).topMargin;
                        i11 = ((FrameLayout.LayoutParams) layoutParams6).bottomMargin;
                    } else {
                        i8 = i21;
                        str = str2;
                        i9 = i5;
                        z = true;
                        i10 = ((FrameLayout.LayoutParams) layoutParams6).topMargin;
                        i11 = ((FrameLayout.LayoutParams) layoutParams6).bottomMargin;
                    }
                    int i25 = i10 + i11;
                    if (this.p) {
                        o0 o0Var7 = this.o;
                        if (o0Var7 != null) {
                            i12 = i8;
                            if (o0Var7.V(i12, g.size()) == z) {
                                z2 = true;
                                if (z2) {
                                    i25 += i3;
                                }
                                o0Var = this.o;
                                if (o0Var == null && o0Var.U(i12, g.size()) == z) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (!z3) {
                                    i25 += i3;
                                }
                            }
                        } else {
                            i12 = i8;
                        }
                        z2 = false;
                        if (z2) {
                        }
                        o0Var = this.o;
                        if (o0Var == null) {
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    i22 += i25;
                    this.G += i25;
                    i21 = i23;
                    i5 = i9;
                    str2 = str;
                } else {
                    throw new NullPointerException(str2);
                }
            }
            String str3 = str2;
            int i26 = i5;
            int i27 = intRef2.element - i22;
            for (View view5 : g) {
                ViewGroup.LayoutParams layoutParams7 = view5.getLayoutParams();
                if (layoutParams7 != null) {
                    LayoutParams layoutParams8 = (LayoutParams) layoutParams7;
                    if (layoutParams8.k() > 0.0f) {
                        i7 = i27;
                        int[] b2 = r0.b(this, layoutParams8.j(), layoutParams8.i(), intRef.element, intRef2.element, 0, 0);
                        if (this.c) {
                            a = i26;
                        } else if (i7 > 0) {
                            a = r0.e(i7 * layoutParams8.k());
                        } else {
                            if (b2[1] > 0) {
                                a = r0.f(i22);
                            } else {
                                int i28 = ((FrameLayout.LayoutParams) layoutParams8).height;
                                if (i28 == -1) {
                                    a = r0.f((intRef2.element - getPaddingTop()) - getPaddingBottom());
                                } else if (i28 > 0) {
                                    a = r0.f(i28);
                                } else {
                                    a = r0.a((intRef2.element - getPaddingTop()) - getPaddingBottom());
                                }
                            }
                            intRef3.element = a;
                            s(this, intRef, intRef2, booleanRef, intRef4, intRef3, view5);
                            this.G += view5.getMeasuredHeight();
                        }
                        intRef3.element = a;
                        s(this, intRef, intRef2, booleanRef, intRef4, intRef3, view5);
                        this.G += view5.getMeasuredHeight();
                    } else {
                        i7 = i27;
                    }
                    i27 = i7;
                } else {
                    throw new NullPointerException(str3);
                }
            }
            if (mode2 != 1073741824) {
                intRef2.element = Math.min(this.G + getPaddingTop() + getPaddingBottom(), intRef2.element);
            }
            if (g.isEmpty()) {
                if (getSuggestedMinimumWidth() > 0) {
                    i6 = getSuggestedMinimumWidth();
                } else {
                    i6 = this.b;
                }
                intRef.element = i6;
            }
            setMeasuredDimension(intRef.element + this.H, intRef2.element);
        }
    }

    public static final int A(DslTabLayout dslTabLayout, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, dslTabLayout, i)) == null) {
            if (i > 0) {
                return r0.c(i, dslTabLayout.B, dslTabLayout.C);
            }
            return r0.c(i, -dslTabLayout.C, -dslTabLayout.B);
        }
        return invokeLI.intValue;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048654, this, i, i2) == null) {
            if (getDslSelector().d() < 0) {
                setCurrentItem$default(this, this.k, false, false, 6, null);
            }
            if (k()) {
                o(i, i2);
            } else {
                r(i, i2);
            }
        }
    }

    public final void setTabLayoutConfig(DslTabLayoutConfig config, Function1<? super DslTabLayoutConfig, Unit> doIt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048690, this, config, doIt) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(doIt, "doIt");
            setTabLayoutConfig(config);
            g(doIt);
        }
    }

    public static final void p(DslTabLayout dslTabLayout, Ref.IntRef intRef, Ref.IntRef intRef2, int i, int i2, Ref.IntRef intRef3, Ref.IntRef intRef4, View view2, Integer num) {
        int a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{dslTabLayout, intRef, intRef2, Integer.valueOf(i), Integer.valueOf(i2), intRef3, intRef4, view2, num}) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams != null) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                int[] b = r0.b(dslTabLayout, layoutParams2.j(), layoutParams2.i(), intRef.element, intRef2.element, 0, 0);
                if (i == 1073741824) {
                    a = r0.f((((intRef2.element - dslTabLayout.getPaddingTop()) - dslTabLayout.getPaddingBottom()) - ((FrameLayout.LayoutParams) layoutParams2).topMargin) - ((FrameLayout.LayoutParams) layoutParams2).bottomMargin);
                } else if (b[1] > 0) {
                    int i3 = b[1];
                    intRef2.element = i3;
                    a = r0.f(i3);
                    intRef2.element += dslTabLayout.getPaddingTop() + dslTabLayout.getPaddingBottom();
                } else if (((FrameLayout.LayoutParams) layoutParams2).height == -1) {
                    a = r0.f(i2);
                } else {
                    a = r0.a(Integer.MAX_VALUE);
                }
                int h = layoutParams2.h();
                int i4 = intRef3.element;
                if (num != null) {
                    view2.measure(i4, num.intValue());
                } else {
                    view2.measure(i4, a);
                }
                if (h > 0) {
                    dslTabLayout.H = Math.max(dslTabLayout.H, h);
                    view2.measure(intRef3.element, r0.f(view2.getMeasuredHeight() + h));
                }
                intRef4.element = Math.max(intRef4.element, view2.getMeasuredHeight());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
        }
    }

    public static /* synthetic */ void q(DslTabLayout dslTabLayout, Ref.IntRef intRef, Ref.IntRef intRef2, int i, int i2, Ref.IntRef intRef3, Ref.IntRef intRef4, View view2, Integer num, int i3, Object obj) {
        Integer num2;
        if (obj == null) {
            if ((i3 & 256) != 0) {
                num2 = null;
            } else {
                num2 = num;
            }
            p(dslTabLayout, intRef, intRef2, i, i2, intRef3, intRef4, view2, num2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: measureHorizontal$measureChild");
    }

    public static final void s(DslTabLayout dslTabLayout, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.BooleanRef booleanRef, Ref.IntRef intRef3, Ref.IntRef intRef4, View view2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{dslTabLayout, intRef, intRef2, booleanRef, intRef3, intRef4, view2}) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams != null) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                layoutParams2.setMarginStart(0);
                layoutParams2.setMarginEnd(0);
                int h = layoutParams2.h();
                dslTabLayout.H = Math.max(dslTabLayout.H, h);
                int[] b = r0.b(dslTabLayout, layoutParams2.j(), layoutParams2.i(), intRef.element, intRef2.element, 0, 0);
                booleanRef.element = false;
                if (intRef3.element == -1 && b[0] > 0) {
                    int i2 = b[0];
                    intRef.element = i2;
                    intRef3.element = r0.f(i2);
                    intRef.element += dslTabLayout.getPaddingStart() + dslTabLayout.getPaddingEnd();
                }
                if (intRef3.element == -1) {
                    if (((FrameLayout.LayoutParams) layoutParams2).width == -1) {
                        if (dslTabLayout.getSuggestedMinimumWidth() > 0) {
                            i = dslTabLayout.getSuggestedMinimumWidth();
                        } else {
                            i = dslTabLayout.b;
                        }
                        intRef.element = i;
                        intRef3.element = r0.f(i);
                        intRef.element += dslTabLayout.getPaddingStart() + dslTabLayout.getPaddingEnd();
                    } else {
                        intRef3.element = r0.a(intRef.element);
                        booleanRef.element = true;
                    }
                }
                int i3 = intRef4.element;
                if (h > 0) {
                    view2.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(intRef3.element) + h, View.MeasureSpec.getMode(intRef3.element)), intRef4.element);
                } else {
                    view2.measure(intRef3.element, i3);
                }
                if (booleanRef.element) {
                    int measuredWidth = view2.getMeasuredWidth();
                    intRef.element = measuredWidth;
                    intRef3.element = r0.f(measuredWidth);
                    intRef.element += dslTabLayout.getPaddingStart() + dslTabLayout.getPaddingEnd();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
        }
    }

    public static /* synthetic */ void setCurrentItem$default(DslTabLayout dslTabLayout, int i, boolean z, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            if ((i2 & 4) != 0) {
                z2 = false;
            }
            dslTabLayout.setCurrentItem(i, z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCurrentItem");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.angcyo.tablayout.DslTabLayout */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setTabLayoutConfig$default(DslTabLayout dslTabLayout, DslTabLayoutConfig dslTabLayoutConfig, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                dslTabLayoutConfig = new DslTabLayoutConfig(dslTabLayout);
            }
            if ((i & 2) != 0) {
                function1 = DslTabLayout$setTabLayoutConfig$1.INSTANCE;
            }
            dslTabLayout.setTabLayoutConfig(dslTabLayoutConfig, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTabLayoutConfig");
    }

    public final void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            get_overScroller().abortAnimation();
            if (k()) {
                get_overScroller().startScroll(getScrollX(), getScrollY(), i, 0, this.A);
            } else {
                get_overScroller().startScroll(getScrollX(), getScrollY(), 0, i, this.A);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    public void onDraw(final Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.onDraw(canvas);
            if (this.n) {
                i(canvas, new Function0<Unit>(this, canvas) { // from class: com.angcyo.tablayout.DslTabLayout$onDraw$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Canvas $canvas;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DslTabLayout this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, canvas};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$canvas = canvas;
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DslTabBorder tabBorder;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (tabBorder = this.this$0.getTabBorder()) != null) {
                            tabBorder.N(this.$canvas);
                        }
                    }
                });
            }
            if (this.h && !r0.s(this.i.j0(), 4096)) {
                this.i.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, parcelable) == null) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                super.onRestoreInstanceState(bundle.getParcelable("old"));
                this.k = bundle.getInt("defaultIndex", this.k);
                int i = bundle.getInt("currentIndex", -1);
                getDslSelector().n(-1);
                if (i > 0) {
                    setCurrentItem(i, true, false);
                    return;
                }
                return;
            }
            super.onRestoreInstanceState(parcelable);
        }
    }

    public boolean x(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048705, this, f)) == null) {
            if (!getNeedScroll()) {
                return false;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
            if (!this.x) {
                if (k()) {
                    scrollBy((int) f, 0);
                } else {
                    scrollBy(0, (int) f);
                }
            }
            return true;
        }
        return invokeF.booleanValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getDslSelector().r();
            getDslSelector().q();
            getDslSelector().p();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i.o0(getDslSelector().d());
            DslTabIndicator dslTabIndicator = this.i;
            dslTabIndicator.s0(dslTabIndicator.b0());
            this.i.r0(0.0f);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new LayoutParams(-2, -2, 17);
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public final AttributeSet getAttributeSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a;
        }
        return (AttributeSet) invokeV.objValue;
    }

    public final int getCurrentItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return getDslSelector().d();
        }
        return invokeV.intValue;
    }

    public final View getCurrentItemView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return (View) CollectionsKt___CollectionsKt.getOrNull(getDslSelector().g(), getCurrentItemIndex());
        }
        return (View) invokeV.objValue;
    }

    public final boolean getDrawBadge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public final boolean getDrawBorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public final boolean getDrawDivider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public final boolean getDrawHighlight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public final boolean getDrawIndicator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final m0 getDslSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return (m0) this.F.getValue();
        }
        return (m0) invokeV.objValue;
    }

    public final boolean getItemAutoEquWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public final int getItemDefaultHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final boolean getItemEnableSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final IntRange getItemEquWidthCountRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e;
        }
        return (IntRange) invokeV.objValue;
    }

    public final boolean getItemIsEquWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final int getItemWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final boolean getLayoutScrollAnim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public final int getMaxHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.G + getPaddingTop() + getPaddingBottom();
        }
        return invokeV.intValue;
    }

    public final int getMaxScrollY() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            int maxHeight = getMaxHeight() - getMeasuredHeight();
            if (this.x) {
                i = r0.o(this) / 2;
            } else {
                i = 0;
            }
            return Math.max(maxHeight + i, 0);
        }
        return invokeV.intValue;
    }

    public final int getMaxWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.G + getPaddingStart() + getPaddingEnd();
        }
        return invokeV.intValue;
    }

    public final int getMinScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.x) {
                return (-r0.o(this)) / 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function3<? super android.view.View, ? super com.baidu.tieba.n0, ? super java.lang.Integer, com.baidu.tieba.s0>, kotlin.jvm.functions.Function3<android.view.View, com.baidu.tieba.n0, java.lang.Integer, com.baidu.tieba.s0> */
    public final Function3<View, n0, Integer, s0> getOnTabBadgeConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.t;
        }
        return (Function3) invokeV.objValue;
    }

    public final int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.y;
        }
        return invokeV.intValue;
    }

    public final int getScrollAnimDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    public final n0 getTabBadge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.q;
        }
        return (n0) invokeV.objValue;
    }

    public final Map<Integer, s0> getTabBadgeConfigMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.s;
        }
        return (Map) invokeV.objValue;
    }

    public final DslTabBorder getTabBorder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.m;
        }
        return (DslTabBorder) invokeV.objValue;
    }

    public final Drawable getTabConvexBackgroundDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.w;
        }
        return (Drawable) invokeV.objValue;
    }

    public final int getTabDefaultIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public final o0 getTabDivider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.o;
        }
        return (o0) invokeV.objValue;
    }

    public final boolean getTabEnableSelectorMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.x;
        }
        return invokeV.booleanValue;
    }

    public final p0 getTabHighlight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.v;
        }
        return (p0) invokeV.objValue;
    }

    public final DslTabIndicator getTabIndicator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.i;
        }
        return (DslTabIndicator) invokeV.objValue;
    }

    public final long getTabIndicatorAnimationDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.j;
        }
        return invokeV.longValue;
    }

    public final DslTabLayoutConfig getTabLayoutConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.l;
        }
        return (DslTabLayoutConfig) invokeV.objValue;
    }

    public final int get_childAllWidthSum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.G;
        }
        return invokeV.intValue;
    }

    public final GestureDetectorCompat get_gestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return (GestureDetectorCompat) this.K.getValue();
        }
        return (GestureDetectorCompat) invokeV.objValue;
    }

    public final int get_layoutDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.I;
        }
        return invokeV.intValue;
    }

    public final int get_maxConvexHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public final int get_maxFlingVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.C;
        }
        return invokeV.intValue;
    }

    public final int get_minFlingVelocity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.B;
        }
        return invokeV.intValue;
    }

    public final OverScroller get_overScroller() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return (OverScroller) this.J.getValue();
        }
        return (OverScroller) invokeV.objValue;
    }

    public final ValueAnimator get_scrollAnimator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return (ValueAnimator) this.L.getValue();
        }
        return (ValueAnimator) invokeV.objValue;
    }

    public final Rect get_tempRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.E;
        }
        return (Rect) invokeV.objValue;
    }

    public final int get_touchSlop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public final u0 get_viewPagerDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.M;
        }
        return (u0) invokeV.objValue;
    }

    public final int get_viewPagerScrollState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.N;
        }
        return invokeV.intValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return get_scrollAnimator().isStarted();
        }
        return invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return r0.v(this.y);
        }
        return invokeV.booleanValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (ViewCompat.getLayoutDirection(this) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            super.onFinishInflate();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState();
            Bundle bundle = new Bundle();
            bundle.putParcelable("old", onSaveInstanceState);
            bundle.putInt("defaultIndex", this.k);
            bundle.putInt("currentIndex", getCurrentItemIndex());
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            if (this.c || !getNeedScroll()) {
                if (getScrollX() != 0 || getScrollY() != 0) {
                    scrollTo(0, 0);
                }
            }
        }
    }

    public final void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) != null) || i2 == i) {
            return;
        }
        get_scrollAnimator().cancel();
        if (!this.i.c0()) {
            d();
            return;
        }
        if (i < 0) {
            this.i.o0(i2);
        } else {
            this.i.o0(i);
        }
        this.i.s0(i2);
        if (isInEditMode()) {
            this.i.o0(i2);
        } else if (this.i.b0() == this.i.m0()) {
        } else {
            get_scrollAnimator().setFloatValues(this.i.k0(), 1.0f);
            get_scrollAnimator().start();
        }
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i0 = this.i.i0();
            if (i0 != 1) {
                if (i0 != 2) {
                    return getPaddingStart() + (r0.p(this) / 2);
                }
                return getMeasuredWidth() - getPaddingEnd();
            }
            return getPaddingStart();
        }
        return invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i0 = this.i.i0();
            if (i0 != 1) {
                if (i0 != 2) {
                    return getPaddingTop() + (r0.o(this) / 2);
                }
                return getMeasuredHeight() - getPaddingBottom();
            }
            return getPaddingTop();
        }
        return invokeV.intValue;
    }

    public final int getMaxScrollX() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (l() && k()) {
                if (!this.x) {
                    return 0;
                }
                return r0.p(this) / 2;
            }
            int maxWidth = getMaxWidth() - getMeasuredWidth();
            if (this.x) {
                i = r0.p(this) / 2;
            } else {
                i = 0;
            }
            return Math.max(maxWidth + i, 0);
        }
        return invokeV.intValue;
    }

    public final int getMinScrollX() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (l() && k()) {
                int maxWidth = getMaxWidth() - getMeasuredWidth();
                if (this.x) {
                    i = r0.p(this) / 2;
                } else {
                    i = 0;
                }
                return Math.min(-(maxWidth + i), 0);
            } else if (!this.x) {
                return 0;
            } else {
                return (-r0.p(this)) / 2;
            }
        }
        return invokeV.intValue;
    }

    public final boolean getNeedScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (!this.x) {
                if (k()) {
                    if (l()) {
                        if (getMinScrollX() >= 0) {
                            return false;
                        }
                    } else if (getMaxScrollX() <= 0) {
                        return false;
                    }
                } else if (getMaxScrollY() <= 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && get_overScroller().computeScrollOffset()) {
            scrollTo(get_overScroller().getCurrX(), get_overScroller().getCurrY());
            invalidate();
            if (get_overScroller().getCurrX() < getMinScrollX() || get_overScroller().getCurrX() > getMaxScrollX()) {
                get_overScroller().abortAnimation();
            }
        }
    }

    @Override // android.view.View
    public void draw(final Canvas canvas) {
        n0 n0Var;
        int left;
        int top;
        int right;
        int bottom;
        String y0;
        p0 p0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            int i = 0;
            if (this.h) {
                this.i.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            final Drawable drawable = this.w;
            if (drawable != null) {
                if (k()) {
                    drawable.setBounds(0, this.H, getRight() - getLeft(), getBottom() - getTop());
                } else {
                    drawable.setBounds(0, 0, getMeasuredWidth() - this.H, getBottom() - getTop());
                }
                if ((getScrollX() | getScrollY()) == 0) {
                    drawable.draw(canvas);
                } else {
                    i(canvas, new Function0<Unit>(drawable, canvas) { // from class: com.angcyo.tablayout.DslTabLayout$draw$1$1
                        public static /* synthetic */ Interceptable $ic;
                        public final /* synthetic */ Canvas $canvas;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Drawable $this_apply;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {drawable, canvas};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.$this_apply = drawable;
                            this.$canvas = canvas;
                        }

                        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                this.$this_apply.draw(this.$canvas);
                            }
                        }
                    });
                }
            }
            super.draw(canvas);
            if (this.u && (p0Var = this.v) != null) {
                p0Var.draw(canvas);
            }
            int size = getDslSelector().g().size();
            if (this.p) {
                if (k()) {
                    if (l()) {
                        o0 o0Var = this.o;
                        if (o0Var != null) {
                            int e = o0Var.e() + o0Var.R();
                            int measuredHeight = (getMeasuredHeight() - o0Var.b()) - o0Var.O();
                            int i2 = 0;
                            for (Object obj : getDslSelector().g()) {
                                int i3 = i2 + 1;
                                if (i2 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                View view2 = (View) obj;
                                if (o0Var.V(i2, size)) {
                                    int right2 = view2.getRight() + o0Var.P() + o0Var.S();
                                    o0Var.setBounds(right2 - o0Var.S(), e, right2, measuredHeight);
                                    o0Var.draw(canvas);
                                }
                                if (o0Var.U(i2, size)) {
                                    int right3 = (view2.getRight() - view2.getMeasuredWidth()) - o0Var.Q();
                                    o0Var.setBounds(right3 - o0Var.S(), e, right3, measuredHeight);
                                    o0Var.draw(canvas);
                                }
                                i2 = i3;
                            }
                        }
                    } else {
                        o0 o0Var2 = this.o;
                        if (o0Var2 != null) {
                            int e2 = o0Var2.e() + o0Var2.R();
                            int measuredHeight2 = (getMeasuredHeight() - o0Var2.b()) - o0Var2.O();
                            int i4 = 0;
                            for (Object obj2 : getDslSelector().g()) {
                                int i5 = i4 + 1;
                                if (i4 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                View view3 = (View) obj2;
                                if (o0Var2.V(i4, size)) {
                                    int left2 = (view3.getLeft() - o0Var2.Q()) - o0Var2.S();
                                    o0Var2.setBounds(left2, e2, o0Var2.S() + left2, measuredHeight2);
                                    o0Var2.draw(canvas);
                                }
                                if (o0Var2.U(i4, size)) {
                                    int right4 = view3.getRight() + o0Var2.P();
                                    o0Var2.setBounds(right4, e2, o0Var2.S() + right4, measuredHeight2);
                                    o0Var2.draw(canvas);
                                }
                                i4 = i5;
                            }
                        }
                    }
                } else {
                    o0 o0Var3 = this.o;
                    if (o0Var3 != null) {
                        int paddingStart = getPaddingStart() + o0Var3.P();
                        int measuredWidth = (getMeasuredWidth() - getPaddingEnd()) - o0Var3.Q();
                        int i6 = 0;
                        for (Object obj3 : getDslSelector().g()) {
                            int i7 = i6 + 1;
                            if (i6 < 0) {
                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                            }
                            View view4 = (View) obj3;
                            if (o0Var3.V(i6, size)) {
                                int top2 = (view4.getTop() - o0Var3.O()) - o0Var3.N();
                                o0Var3.setBounds(paddingStart, top2, measuredWidth, o0Var3.N() + top2);
                                o0Var3.draw(canvas);
                            }
                            if (o0Var3.U(i6, size)) {
                                int bottom2 = view4.getBottom() + o0Var3.R();
                                o0Var3.setBounds(paddingStart, bottom2, measuredWidth, o0Var3.N() + bottom2);
                                o0Var3.draw(canvas);
                            }
                            i6 = i7;
                        }
                    }
                }
            }
            if (this.n) {
                i(canvas, new Function0<Unit>(this, canvas) { // from class: com.angcyo.tablayout.DslTabLayout$draw$5
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ Canvas $canvas;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DslTabLayout this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, canvas};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i8 = newInitContext.flag;
                            if ((i8 & 1) != 0) {
                                int i9 = i8 & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$canvas = canvas;
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        DslTabBorder tabBorder;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (tabBorder = this.this$0.getTabBorder()) != null) {
                            tabBorder.draw(this.$canvas);
                        }
                    }
                });
            }
            if (this.h && r0.s(this.i.j0(), 4096)) {
                this.i.draw(canvas);
            }
            if (this.r && (n0Var = this.q) != null) {
                for (Object obj4 : getDslSelector().g()) {
                    int i8 = i + 1;
                    if (i < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    View view5 = (View) obj4;
                    s0 invoke = this.t.invoke(view5, n0Var, Integer.valueOf(i));
                    if (invoke != null && invoke.c() >= 0) {
                        View g = r0.g(view5, invoke.c());
                        if (g != null) {
                            view5 = g;
                        }
                        r0.k(view5, this, this.E);
                        Rect rect = this.E;
                        left = rect.left;
                        top = rect.top;
                        right = rect.right;
                        bottom = rect.bottom;
                    } else {
                        left = view5.getLeft();
                        top = view5.getTop();
                        right = view5.getRight();
                        bottom = view5.getBottom();
                    }
                    if (invoke != null && invoke.h()) {
                        left += view5.getPaddingStart();
                        top += view5.getPaddingTop();
                        right -= view5.getPaddingEnd();
                        bottom -= view5.getPaddingBottom();
                    }
                    n0Var.setBounds(left, top, right, bottom);
                    n0Var.M();
                    if (n0Var.l()) {
                        if (i == size - 1) {
                            y0 = "";
                        } else {
                            y0 = n0Var.y0();
                        }
                        n0Var.u0(y0);
                    }
                    n0Var.draw(canvas);
                    i = i8;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{canvas, child, Long.valueOf(j)})) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(child, "child");
            return super.drawChild(canvas, child, j);
        }
        return invokeCommon.booleanValue;
    }

    public final void e(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.i.r0(f);
            DslTabLayoutConfig dslTabLayoutConfig = this.l;
            if (dslTabLayoutConfig != null) {
                dslTabLayoutConfig.w(this.i.b0(), this.i.m0(), f);
            }
            DslTabLayoutConfig dslTabLayoutConfig2 = this.l;
            if (dslTabLayoutConfig2 != null) {
                List<View> g = getDslSelector().g();
                View view2 = (View) CollectionsKt___CollectionsKt.getOrNull(g, this.i.m0());
                if (view2 != null) {
                    dslTabLayoutConfig2.x((View) CollectionsKt___CollectionsKt.getOrNull(g, this.i.b0()), view2, f);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        InterceptResult invokeL;
        boolean onInterceptTouchEvent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, ev)) == null) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            if (getNeedScroll()) {
                if (ev.getActionMasked() == 0) {
                    get_overScroller().abortAnimation();
                    get_scrollAnimator().cancel();
                }
                if (isEnabled() && (super.onInterceptTouchEvent(ev) || get_gestureDetector().onTouchEvent(ev))) {
                    onInterceptTouchEvent = true;
                }
                onInterceptTouchEvent = false;
            } else {
                if (isEnabled()) {
                    onInterceptTouchEvent = super.onInterceptTouchEvent(ev);
                }
                onInterceptTouchEvent = false;
            }
            if (isEnabled()) {
                if (!this.d) {
                    return true;
                }
                return onInterceptTouchEvent;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!isEnabled()) {
                return false;
            }
            if (getNeedScroll()) {
                get_gestureDetector().onTouchEvent(event);
                if (event.getActionMasked() != 3 && event.getActionMasked() != 1) {
                    if (event.getActionMasked() == 0) {
                        get_overScroller().abortAnimation();
                    }
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                return true;
            } else if (!isEnabled() || !super.onTouchEvent(event)) {
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void f(int i, boolean z) {
        int scrollY;
        int i2;
        int scrollY2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || !getNeedScroll()) {
            return;
        }
        View view2 = (View) CollectionsKt___CollectionsKt.getOrNull(getDslSelector().g(), i);
        if (view2 != null && !ViewCompat.isLaidOut(view2)) {
            return;
        }
        if (k()) {
            int Y = DslTabIndicator.Y(this.i, i, 0, 2, null);
            int b = b();
            if (this.x) {
                i2 = Y - (getMeasuredWidth() / 2);
                scrollY2 = getScrollX();
            } else if (l()) {
                if (Y < b) {
                    i2 = Y - b;
                    scrollY2 = getScrollX();
                } else {
                    scrollY = getScrollX();
                    i3 = -scrollY;
                }
            } else if (Y > b) {
                i2 = Y - b;
                scrollY2 = getScrollX();
            } else {
                scrollY = getScrollX();
                i3 = -scrollY;
            }
            i3 = i2 - scrollY2;
        } else {
            int a0 = DslTabIndicator.a0(this.i, i, 0, 2, null);
            int c = c();
            if (this.x) {
                i2 = a0 - (getMeasuredHeight() / 2);
                scrollY2 = getScrollY();
            } else if (a0 > c) {
                i2 = a0 - c;
                scrollY2 = getScrollY();
            } else if (this.i.i0() == 2 && a0 < c) {
                i2 = a0 - c;
                scrollY2 = getScrollY();
            } else {
                scrollY = getScrollY();
                i3 = -scrollY;
            }
            i3 = i2 - scrollY2;
        }
        if (k()) {
            if (!isInEditMode() && z) {
                B(i3);
                return;
            }
            get_overScroller().abortAnimation();
            scrollBy(i3, 0);
        } else if (!isInEditMode() && z) {
            B(i3);
        } else {
            get_overScroller().abortAnimation();
            scrollBy(0, i3);
        }
    }

    public final void g(Function1<? super DslTabLayoutConfig, Unit> config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            if (this.l == null) {
                setTabLayoutConfig(new DslTabLayoutConfig(this));
            }
            DslTabLayoutConfig dslTabLayoutConfig = this.l;
            if (dslTabLayoutConfig != null) {
                config.invoke(dslTabLayoutConfig);
            }
            getDslSelector().q();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, attributeSet)) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return new LayoutParams(context, attributeSet);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i) == null) {
            super.onRtlPropertiesChanged(i);
            if (i != this.I) {
                this.I = i;
                if (this.y == 0) {
                    C();
                    requestLayout();
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, view2) == null) {
            super.onViewAdded(view2);
            C();
        }
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, view2) == null) {
            super.onViewRemoved(view2);
            C();
        }
    }

    public final void setDrawBadge(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048665, this, z) == null) {
            this.r = z;
        }
    }

    public final void setDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z) == null) {
            this.n = z;
        }
    }

    public final void setDrawDivider(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z) == null) {
            this.p = z;
        }
    }

    public final void setDrawHighlight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z) == null) {
            this.u = z;
        }
    }

    public final void setDrawIndicator(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            this.h = z;
        }
    }

    public final void setItemAutoEquWidth(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z) == null) {
            this.f = z;
        }
    }

    public final void setItemDefaultHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048671, this, i) == null) {
            this.b = i;
        }
    }

    public final void setItemEnableSelector(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z) == null) {
            this.d = z;
        }
    }

    public final void setItemEquWidthCountRange(IntRange intRange) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, intRange) == null) {
            this.e = intRange;
        }
    }

    public final void setItemIsEquWidth(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.c = z;
        }
    }

    public final void setItemWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i) == null) {
            this.g = i;
        }
    }

    public final void setLayoutScrollAnim(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z) == null) {
            this.z = z;
        }
    }

    public final void setOnTabBadgeConfig(Function3<? super View, ? super n0, ? super Integer, s0> function3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, function3) == null) {
            Intrinsics.checkNotNullParameter(function3, "<set-?>");
            this.t = function3;
        }
    }

    public final void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i) == null) {
            this.y = i;
        }
    }

    public final void setScrollAnimDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i) == null) {
            this.A = i;
        }
    }

    public final void setTabBadge(n0 n0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, n0Var) == null) {
            this.q = n0Var;
            if (n0Var != null) {
                n0Var.setCallback(this);
            }
            n0 n0Var2 = this.q;
            if (n0Var2 != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                n0Var2.k(context, this.a);
            }
        }
    }

    public final void setTabBorder(DslTabBorder dslTabBorder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, dslTabBorder) == null) {
            this.m = dslTabBorder;
            if (dslTabBorder != null) {
                dslTabBorder.setCallback(this);
            }
            DslTabBorder dslTabBorder2 = this.m;
            if (dslTabBorder2 != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                dslTabBorder2.k(context, this.a);
            }
        }
    }

    public final void setTabConvexBackgroundDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, drawable) == null) {
            this.w = drawable;
        }
    }

    public final void setTabDefaultIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i) == null) {
            this.k = i;
        }
    }

    public final void setTabDivider(o0 o0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, o0Var) == null) {
            this.o = o0Var;
            if (o0Var != null) {
                o0Var.setCallback(this);
            }
            o0 o0Var2 = this.o;
            if (o0Var2 != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                o0Var2.k(context, this.a);
            }
        }
    }

    public final void setTabEnableSelectorMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z) == null) {
            this.x = z;
        }
    }

    public final void setTabHighlight(p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, p0Var) == null) {
            this.v = p0Var;
            if (p0Var != null) {
                p0Var.setCallback(this);
            }
            p0 p0Var2 = this.v;
            if (p0Var2 != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                p0Var2.k(context, this.a);
            }
        }
    }

    public final void setTabIndicator(DslTabIndicator value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.i = value;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            value.k(context, this.a);
        }
    }

    public final void setTabIndicatorAnimationDuration(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048688, this, j) == null) {
            this.j = j;
        }
    }

    public final void setTabLayoutConfig(DslTabLayoutConfig dslTabLayoutConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, dslTabLayoutConfig) == null) {
            this.l = dslTabLayoutConfig;
            if (dslTabLayoutConfig != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                dslTabLayoutConfig.v(context, this.a);
            }
        }
    }

    public final void set_childAllWidthSum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048691, this, i) == null) {
            this.G = i;
        }
    }

    public final void set_layoutDirection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048692, this, i) == null) {
            this.I = i;
        }
    }

    public final void set_maxConvexHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i) == null) {
            this.H = i;
        }
    }

    public final void set_maxFlingVelocity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048694, this, i) == null) {
            this.C = i;
        }
    }

    public final void set_minFlingVelocity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i) == null) {
            this.B = i;
        }
    }

    public final void set_touchSlop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i) == null) {
            this.D = i;
        }
    }

    public final void set_viewPagerDelegate(u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, u0Var) == null) {
            this.M = u0Var;
        }
    }

    public final void set_viewPagerScrollState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048698, this, i) == null) {
            this.N = i;
        }
    }

    public final void setupViewPager(u0 viewPagerDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, viewPagerDelegate) == null) {
            Intrinsics.checkNotNullParameter(viewPagerDelegate, "viewPagerDelegate");
            this.M = viewPagerDelegate;
        }
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048701, this, i) == null) {
            this.N = i;
            if (i == 0) {
                d();
                getDslSelector().q();
            }
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048703, this, who)) == null) {
            Intrinsics.checkNotNullParameter(who, "who");
            if (!super.verifyDrawable(who) && !Intrinsics.areEqual(who, this.i)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048704, this, i) == null) {
            setCurrentItem(i, true, false);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, layoutParams)) == null) {
            if (layoutParams != null) {
                return new LayoutParams(layoutParams);
            }
            return generateDefaultLayoutParams();
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        r1 = r2.a((r39 & 1) != 0 ? r2.a : null, (r39 & 2) != 0 ? r2.b : 0, (r39 & 4) != 0 ? r2.c : 0, (r39 & 8) != 0 ? r2.d : 0, (r39 & 16) != 0 ? r2.e : 0, (r39 & 32) != 0 ? r2.f : 0, (r39 & 64) != 0 ? r2.g : 0.0f, (r39 & 128) != 0 ? r2.h : 0, (r39 & 256) != 0 ? r2.i : 0, (r39 & 512) != 0 ? r2.j : 0, (r39 & 1024) != 0 ? r2.k : 0, (r39 & 2048) != 0 ? r2.l : 0, (r39 & 4096) != 0 ? r2.m : 0, (r39 & 8192) != 0 ? r2.n : 0, (r39 & 16384) != 0 ? r2.o : 0, (r39 & 32768) != 0 ? r2.p : 0, (r39 & 65536) != 0 ? r2.q : 0, (r39 & 131072) != 0 ? r2.r : 0, (r39 & 262144) != 0 ? r2.s : false, (r39 & 524288) != 0 ? r2.t : 0, (r39 & 1048576) != 0 ? r2.u : 0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final s0 h(int i) {
        InterceptResult invokeI;
        n0 n0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048640, this, i)) == null) {
            s0 s0Var = this.s.get(Integer.valueOf(i));
            if (s0Var == null && ((n0Var = this.q) == null || (r2 = n0Var.x0()) == null || s0Var == null)) {
                s0Var = new s0(null, 0, 0, 0, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 2097151, null);
            }
            return s0Var;
        }
        return (s0) invokeI.objValue;
    }

    public final void i(Canvas canvas, Function0<Unit> action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, canvas, action) == null) {
            Intrinsics.checkNotNullParameter(canvas, "<this>");
            Intrinsics.checkNotNullParameter(action, "action");
            canvas.translate(getScrollX(), getScrollY());
            action.invoke();
            canvas.translate(-getScrollX(), -getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int measuredHeight;
        int measuredHeight2;
        int i6;
        o0 o0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            boolean l = l();
            int paddingStart = getPaddingStart();
            int measuredWidth = getMeasuredWidth() - getPaddingEnd();
            getMeasuredHeight();
            getPaddingBottom();
            if (this.p && (o0Var = this.o) != null) {
                i5 = o0Var.S() + o0Var.P() + o0Var.Q();
            } else {
                i5 = 0;
            }
            List<View> g = getDslSelector().g();
            int i7 = 0;
            for (Object obj : g) {
                int i8 = i7 + 1;
                if (i7 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view2 = (View) obj;
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                    int i9 = ((FrameLayout.LayoutParams) layoutParams2).gravity & 112;
                    if (l) {
                        measuredWidth -= layoutParams2.getMarginEnd();
                    } else {
                        paddingStart += layoutParams2.getMarginStart();
                    }
                    if (this.p) {
                        o0 o0Var2 = this.o;
                        boolean z2 = true;
                        if ((o0Var2 == null || !o0Var2.V(i7, g.size())) ? false : false) {
                            if (l) {
                                measuredWidth -= i5;
                            } else {
                                paddingStart += i5;
                            }
                        }
                    }
                    if (i9 != 16) {
                        if (i9 != 80) {
                            i6 = getPaddingTop() + ((FrameLayout.LayoutParams) layoutParams2).topMargin + view2.getMeasuredHeight();
                            if (!l) {
                                view2.layout(measuredWidth - view2.getMeasuredWidth(), i6 - view2.getMeasuredHeight(), measuredWidth, i6);
                                measuredWidth -= view2.getMeasuredWidth() + layoutParams2.getMarginStart();
                            } else {
                                view2.layout(paddingStart, i6 - view2.getMeasuredHeight(), view2.getMeasuredWidth() + paddingStart, i6);
                                paddingStart += view2.getMeasuredWidth() + layoutParams2.getMarginEnd();
                            }
                            i7 = i8;
                        } else {
                            measuredHeight = getMeasuredHeight();
                            measuredHeight2 = getPaddingBottom();
                        }
                    } else {
                        measuredHeight = getMeasuredHeight() - getPaddingBottom();
                        measuredHeight2 = ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - this.H) / 2) - (view2.getMeasuredHeight() / 2);
                    }
                    i6 = measuredHeight - measuredHeight2;
                    if (!l) {
                    }
                    i7 = i8;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                }
            }
            y();
            if (getDslSelector().d() < 0) {
                setCurrentItem$default(this, this.k, false, false, 6, null);
            } else if (get_overScroller().isFinished()) {
                f(getDslSelector().d(), this.z);
            }
        }
    }

    public final void n(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int paddingStart;
        int measuredWidth;
        int i6;
        boolean z2;
        o0 o0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int paddingTop = getPaddingTop();
            getPaddingStart();
            if (this.p && (o0Var = this.o) != null) {
                i5 = o0Var.N() + o0Var.R() + o0Var.O();
            } else {
                i5 = 0;
            }
            List<View> g = getDslSelector().g();
            int i7 = 0;
            for (Object obj : g) {
                int i8 = i7 + 1;
                if (i7 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view2 = (View) obj;
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(((FrameLayout.LayoutParams) layoutParams2).gravity, 0) & 7;
                    int i9 = paddingTop + ((FrameLayout.LayoutParams) layoutParams2).topMargin;
                    if (this.p) {
                        o0 o0Var2 = this.o;
                        if (o0Var2 != null && o0Var2.V(i7, g.size())) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            i9 += i5;
                        }
                    }
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 5) {
                            paddingStart = getPaddingLeft();
                            measuredWidth = ((FrameLayout.LayoutParams) layoutParams2).leftMargin;
                        } else {
                            i6 = ((getMeasuredWidth() - getPaddingRight()) - view2.getMeasuredWidth()) - ((FrameLayout.LayoutParams) layoutParams2).rightMargin;
                            view2.layout(i6, i9, view2.getMeasuredWidth() + i6, view2.getMeasuredHeight() + i9);
                            paddingTop = i9 + view2.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams2).bottomMargin;
                            i7 = i8;
                        }
                    } else {
                        paddingStart = getPaddingStart();
                        measuredWidth = ((((getMeasuredWidth() - getPaddingStart()) - getPaddingEnd()) - this.H) / 2) - (view2.getMeasuredWidth() / 2);
                    }
                    i6 = paddingStart + measuredWidth;
                    view2.layout(i6, i9, view2.getMeasuredWidth() + i6, view2.getMeasuredHeight() + i9);
                    paddingTop = i9 + view2.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams2).bottomMargin;
                    i7 = i8;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i, int i2) {
        int i3;
        int i4;
        Ref.IntRef intRef;
        int i5;
        int i6;
        Ref.IntRef intRef2;
        int i7;
        int i8;
        Ref.IntRef intRef3;
        Ref.IntRef intRef4;
        String str;
        int a;
        Ref.IntRef intRef5;
        String str2;
        Ref.IntRef intRef6;
        int i9;
        int i10;
        Ref.IntRef intRef7;
        int i11;
        int i12;
        Ref.IntRef intRef8;
        int marginStart;
        int marginEnd;
        boolean z;
        boolean z2;
        o0 o0Var;
        boolean z3;
        int a2;
        Ref.IntRef intRef9;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        o0 o0Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048647, this, i, i2) == null) {
            int i13 = i;
            getDslSelector().r();
            List<View> g = getDslSelector().g();
            int size = g.size();
            if (getSuggestedMinimumHeight() > 0) {
                i3 = getSuggestedMinimumHeight();
            } else {
                i3 = this.b;
            }
            int i14 = i3;
            if (size == 0) {
                setMeasuredDimension(ViewGroup.getDefaultSize(getSuggestedMinimumWidth(), i13), ViewGroup.getDefaultSize(i14, i2));
                return;
            }
            Ref.IntRef intRef10 = new Ref.IntRef();
            intRef10.element = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            Ref.IntRef intRef11 = new Ref.IntRef();
            intRef11.element = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            int i15 = 0;
            this.H = 0;
            Ref.IntRef intRef12 = new Ref.IntRef();
            intRef12.element = -1;
            Ref.IntRef intRef13 = new Ref.IntRef();
            intRef13.element = i14;
            if (mode2 == 0 && intRef11.element == 0) {
                intRef11.element = Integer.MAX_VALUE;
            }
            if (mode == 0 && intRef10.element == 0) {
                intRef10.element = Integer.MAX_VALUE;
            }
            if (this.p && (o0Var2 = this.o) != null) {
                i4 = o0Var2.S() + o0Var2.P() + o0Var2.Q();
            } else {
                i4 = 0;
            }
            String str3 = "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams";
            if (this.f) {
                Iterator it = g.iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    int i17 = i16 + 1;
                    if (i16 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    Iterator it2 = it;
                    View view2 = (View) next;
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if (layoutParams != null) {
                        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                        measureChild(view2, i13, i2);
                        i15 += layoutParams2.getMarginStart() + layoutParams2.getMarginEnd() + view2.getMeasuredWidth();
                        if (this.p) {
                            o0 o0Var3 = this.o;
                            if (o0Var3 != null && o0Var3.V(i16, g.size())) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7) {
                                i15 += i4;
                            }
                            o0 o0Var4 = this.o;
                            if (o0Var4 != null && o0Var4.U(i16, g.size())) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (z8) {
                                i15 += i4;
                            }
                        }
                        i13 = i;
                        i16 = i17;
                        it = it2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                    }
                }
                if (i15 <= intRef10.element) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.c = z6;
            }
            IntRange intRange = this.e;
            if (intRange != null) {
                this.c = intRange.contains(size);
                Unit unit = Unit.INSTANCE;
            }
            if (this.c) {
                int i18 = this.g;
                if (i18 > 0) {
                    intRef = intRef13;
                } else {
                    int paddingStart = getPaddingStart() + getPaddingEnd();
                    Iterator it3 = g.iterator();
                    int i19 = 0;
                    while (it3.hasNext()) {
                        Object next2 = it3.next();
                        int i20 = i19 + 1;
                        if (i19 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        View view3 = (View) next2;
                        Iterator it4 = it3;
                        if (this.p) {
                            o0 o0Var5 = this.o;
                            intRef9 = intRef13;
                            if (o0Var5 != null && o0Var5.V(i19, g.size())) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                                paddingStart += i4;
                            }
                            o0 o0Var6 = this.o;
                            if (o0Var6 != null && o0Var6.U(i19, g.size())) {
                                z5 = true;
                                if (z5) {
                                    paddingStart += i4;
                                }
                            }
                            z5 = false;
                            if (z5) {
                            }
                        } else {
                            intRef9 = intRef13;
                        }
                        ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                        if (layoutParams3 != null) {
                            LayoutParams layoutParams4 = (LayoutParams) layoutParams3;
                            paddingStart += layoutParams4.getMarginStart() + layoutParams4.getMarginEnd();
                            it3 = it4;
                            i19 = i20;
                            intRef13 = intRef9;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                        }
                    }
                    intRef = intRef13;
                    i18 = (intRef10.element - paddingStart) / size;
                }
                i6 = r0.f(i18);
                i5 = 0;
            } else {
                intRef = intRef13;
                i5 = 0;
                i6 = -1;
            }
            this.G = i5;
            int i21 = 0;
            int i22 = 0;
            for (Object obj : g) {
                int i23 = i21 + 1;
                if (i21 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view4 = (View) obj;
                ViewGroup.LayoutParams layoutParams5 = view4.getLayoutParams();
                if (layoutParams5 != null) {
                    LayoutParams layoutParams6 = (LayoutParams) layoutParams5;
                    if (layoutParams6.k() < 0.0f) {
                        str2 = str3;
                        intRef7 = intRef;
                        int i24 = i21;
                        i10 = mode;
                        int[] b = r0.b(this, layoutParams6.j(), layoutParams6.i(), intRef10.element, intRef11.element, 0, 0);
                        if (this.c) {
                            a2 = i6;
                        } else if (b[0] > 0) {
                            a2 = r0.f(b[0]);
                        } else {
                            int i25 = ((FrameLayout.LayoutParams) layoutParams6).width;
                            if (i25 == -1) {
                                a2 = r0.f((intRef10.element - getPaddingStart()) - getPaddingEnd());
                            } else if (i25 > 0) {
                                a2 = r0.f(i25);
                            } else {
                                a2 = r0.a((intRef10.element - getPaddingStart()) - getPaddingEnd());
                            }
                        }
                        intRef12.element = a2;
                        intRef6 = intRef12;
                        i11 = i24;
                        i9 = mode2;
                        i12 = i14;
                        intRef8 = intRef11;
                        q(this, intRef10, intRef11, mode2, i14, intRef12, intRef7, view4, null, 256, null);
                        marginStart = view4.getMeasuredWidth() + layoutParams6.getMarginStart();
                        marginEnd = layoutParams6.getMarginEnd();
                    } else {
                        str2 = str3;
                        intRef6 = intRef12;
                        i9 = mode2;
                        i10 = mode;
                        intRef7 = intRef;
                        i11 = i21;
                        i12 = i14;
                        intRef8 = intRef11;
                        marginStart = layoutParams6.getMarginStart();
                        marginEnd = layoutParams6.getMarginEnd();
                    }
                    int i26 = marginStart + marginEnd;
                    if (this.p) {
                        o0 o0Var7 = this.o;
                        if (o0Var7 != null) {
                            z = true;
                            if (o0Var7.V(i11, g.size())) {
                                z2 = true;
                                if (z2) {
                                    i26 += i4;
                                }
                                o0Var = this.o;
                                if (o0Var == null && o0Var.U(i11, g.size()) == z) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (!z3) {
                                    i26 += i4;
                                }
                            }
                        } else {
                            z = true;
                        }
                        z2 = false;
                        if (z2) {
                        }
                        o0Var = this.o;
                        if (o0Var == null) {
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    Ref.IntRef intRef14 = intRef7;
                    intRef14.element = Math.max(intRef14.element, view4.getMeasuredHeight());
                    i22 += i26;
                    this.G += i26;
                    mode2 = i9;
                    intRef11 = intRef8;
                    i14 = i12;
                    i21 = i23;
                    str3 = str2;
                    intRef12 = intRef6;
                    intRef = intRef14;
                    mode = i10;
                } else {
                    throw new NullPointerException(str3);
                }
            }
            Ref.IntRef intRef15 = intRef12;
            int i27 = mode2;
            int i28 = mode;
            Ref.IntRef intRef16 = intRef;
            int i29 = i14;
            Ref.IntRef intRef17 = intRef11;
            String str4 = str3;
            int i30 = intRef10.element - i22;
            for (View view5 : g) {
                ViewGroup.LayoutParams layoutParams7 = view5.getLayoutParams();
                if (layoutParams7 != null) {
                    LayoutParams layoutParams8 = (LayoutParams) layoutParams7;
                    if (layoutParams8.k() > 0.0f) {
                        int[] b2 = r0.b(this, layoutParams8.j(), layoutParams8.i(), intRef10.element, intRef17.element, 0, 0);
                        if (this.c) {
                            a = i6;
                        } else if (i30 > 0) {
                            a = r0.e(i30 * layoutParams8.k());
                        } else if (b2[0] > 0) {
                            a = r0.f(i22);
                        } else {
                            int i31 = ((FrameLayout.LayoutParams) layoutParams8).width;
                            if (i31 == -1) {
                                a = r0.f((intRef10.element - getPaddingStart()) - getPaddingEnd());
                            } else if (i31 > 0) {
                                a = r0.f(i31);
                            } else {
                                a = r0.a((intRef10.element - getPaddingStart()) - getPaddingEnd());
                            }
                            intRef5 = intRef15;
                            intRef5.element = a;
                            intRef4 = intRef5;
                            i8 = i30;
                            intRef3 = intRef17;
                            str = str4;
                            q(this, intRef10, intRef17, i27, i29, intRef5, intRef16, view5, null, 256, null);
                            intRef16.element = Math.max(intRef16.element, view5.getMeasuredHeight());
                            this.G += view5.getMeasuredWidth();
                        }
                        intRef5 = intRef15;
                        intRef5.element = a;
                        intRef4 = intRef5;
                        i8 = i30;
                        intRef3 = intRef17;
                        str = str4;
                        q(this, intRef10, intRef17, i27, i29, intRef5, intRef16, view5, null, 256, null);
                        intRef16.element = Math.max(intRef16.element, view5.getMeasuredHeight());
                        this.G += view5.getMeasuredWidth();
                    } else {
                        i8 = i30;
                        intRef3 = intRef17;
                        intRef4 = intRef15;
                        str = str4;
                    }
                    str4 = str;
                    i30 = i8;
                    intRef17 = intRef3;
                    intRef15 = intRef4;
                } else {
                    throw new NullPointerException(str4);
                }
            }
            Ref.IntRef intRef18 = intRef17;
            Ref.IntRef intRef19 = intRef15;
            if (i27 == Integer.MIN_VALUE) {
                int f = r0.f(Math.max(intRef16.element - this.H, (getSuggestedMinimumHeight() - getPaddingTop()) - getPaddingBottom()));
                for (View view6 : g) {
                    p(this, intRef10, intRef18, i27, i29, intRef19, intRef16, view6, Integer.valueOf(f));
                }
            }
            if (i28 != 1073741824) {
                intRef10.element = Math.min(this.G + getPaddingStart() + getPaddingEnd(), intRef10.element);
            }
            if (g.isEmpty()) {
                if (getSuggestedMinimumHeight() > 0) {
                    i7 = getSuggestedMinimumHeight();
                } else {
                    i7 = this.b;
                }
                intRef2 = intRef18;
                intRef2.element = i7;
            } else {
                intRef2 = intRef18;
                if (i27 != 1073741824) {
                    intRef2.element = Math.max((intRef16.element - this.H) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight());
                }
            }
            setMeasuredDimension(intRef10.element, intRef2.element + this.H);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (k()) {
                m(z, i, i2, i3, i4);
            } else {
                n(z, i, i2, i3, i4);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048658, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            y();
            if (getDslSelector().d() < 0) {
                setCurrentItem$default(this, this.k, false, false, 6, null);
            } else if (get_overScroller().isFinished()) {
                f(getDslSelector().d(), this.z);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048663, this, i, i2) == null) {
            if (k()) {
                if (i > getMaxScrollX()) {
                    super.scrollTo(getMaxScrollX(), 0);
                } else if (i < getMinScrollX()) {
                    super.scrollTo(getMinScrollX(), 0);
                } else {
                    super.scrollTo(i, 0);
                }
            } else if (i2 > getMaxScrollY()) {
                super.scrollTo(0, getMaxScrollY());
            } else if (i2 < getMinScrollY()) {
                super.scrollTo(0, getMinScrollY());
            } else {
                super.scrollTo(0, i2);
            }
        }
    }

    public final void setCurrentItem(int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048664, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (getCurrentItemIndex() == i) {
                f(i, this.i.c0());
            } else {
                m0.m(getDslSelector(), i, true, z, z2, false, 16, null);
            }
        }
    }

    public final void z(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048707, this, i, i2, i3) == null) {
            int A = A(this, i);
            get_overScroller().abortAnimation();
            if (k()) {
                get_overScroller().fling(getScrollX(), getScrollY(), A, 0, i2, i3, 0, 0, getMeasuredWidth(), 0);
            } else {
                get_overScroller().fling(getScrollX(), getScrollY(), 0, A, 0, 0, i2, i3, 0, getMeasuredHeight());
            }
            postInvalidate();
        }
    }

    public void t(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048700, this, f) == null) && getNeedScroll()) {
            if (this.x) {
                if (k() && l()) {
                    if (f < 0.0f) {
                        setCurrentItem$default(this, getDslSelector().d() - 1, false, false, 6, null);
                    } else if (f > 0.0f) {
                        setCurrentItem$default(this, getDslSelector().d() + 1, false, false, 6, null);
                    }
                } else if (f < 0.0f) {
                    setCurrentItem$default(this, getDslSelector().d() + 1, false, false, 6, null);
                } else if (f > 0.0f) {
                    setCurrentItem$default(this, getDslSelector().d() - 1, false, false, 6, null);
                }
            } else if (k()) {
                if (l()) {
                    z(-((int) f), getMinScrollX(), 0);
                } else {
                    z(-((int) f), 0, getMaxScrollX());
                }
            } else {
                z(-((int) f), 0, getMaxHeight());
            }
        }
    }

    public final void v(int i, float f, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048702, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) != null) || j()) {
            return;
        }
        u0 u0Var = this.M;
        if (u0Var != null) {
            i3 = u0Var.b();
        } else {
            i3 = 0;
        }
        if (i < i3) {
            if (this.N == 1) {
                this.i.o0(i + 1);
                this.i.s0(i);
            }
            e(1 - f);
            return;
        }
        if (this.N == 1) {
            this.i.o0(i);
            this.i.s0(i + 1);
        }
        e(f);
    }
}
