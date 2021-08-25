package c.a.q0.p0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.t.c.v;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final KeyEvent f23495a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f23496a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f23497b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ v f23498c;

        public a(EditText editText, Context context, v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, context, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23496a = editText;
            this.f23497b = context;
            this.f23498c = vVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            int selectionStart = this.f23496a.getSelectionStart();
            b.e(this.f23497b, this.f23496a, new SpannableStringBuilder(this.f23498c.c()), selectionStart < 0 ? 0 : selectionStart, aVar, this.f23498c.f());
        }
    }

    /* renamed from: c.a.q0.p0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1085b extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f23499a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f23500b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f23501c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f23502d;

        public C1085b(EditText editText, Context context, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, context, spannableStringBuilder, emotionGroupType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23499a = editText;
            this.f23500b = context;
            this.f23501c = spannableStringBuilder;
            this.f23502d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((C1085b) aVar, str, i2);
                if (aVar != null) {
                    int selectionStart = this.f23499a.getSelectionStart();
                    b.e(this.f23500b, this.f23499a, this.f23501c, selectionStart < 0 ? 0 : selectionStart, aVar, this.f23502d);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f23503a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f23504b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f23505c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f23506d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f23507e;

        public c(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), iArr, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23503a = spannableStringBuilder;
            this.f23504b = i2;
            this.f23505c = i3;
            this.f23506d = iArr;
            this.f23507e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            f fVar;
            f fVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((c) aVar, str, i2);
                if (aVar != null) {
                    Bitmap p = aVar.p();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                    int width = (int) (p.getWidth() * (c.a.p0.b.d.Z() ? 0.4d : 0.5d));
                    bitmapDrawable.setBounds(0, 0, width, width);
                    bitmapDrawable.setGravity(119);
                    this.f23503a.setSpan(new c.a.e.l.b(bitmapDrawable, 1), this.f23504b, this.f23505c, 33);
                    int[] iArr = this.f23506d;
                    int i3 = iArr[0] - 1;
                    iArr[0] = i3;
                    if (i3 != 0 || (fVar2 = this.f23507e) == null) {
                        return;
                    }
                    fVar2.a(this.f23503a);
                    return;
                }
                this.f23503a.setSpan("", this.f23504b, this.f23505c, 33);
                int[] iArr2 = this.f23506d;
                int i4 = iArr2[0] - 1;
                iArr2[0] = i4;
                if (i4 != 0 || (fVar = this.f23507e) == null) {
                    return;
                }
                fVar.a(this.f23503a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f23508a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f23509b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f23510c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f23511d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f23512e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f23513f;

        public d(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), iArr, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23508a = context;
            this.f23509b = spannableStringBuilder;
            this.f23510c = i2;
            this.f23511d = i3;
            this.f23512e = iArr;
            this.f23513f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            f fVar;
            Bitmap p;
            f fVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((d) aVar, str, i2);
                if (aVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                    int dimensionPixelSize = this.f23508a.getResources().getDimensionPixelSize(R.dimen.ds80);
                    int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                    if (width > l.k(this.f23508a) * 0.6d) {
                        width = (int) (p.getWidth() * 0.5d);
                    }
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.f23509b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f23510c, this.f23511d, 33);
                    int[] iArr = this.f23512e;
                    int i3 = iArr[0] - 1;
                    iArr[0] = i3;
                    if (i3 != 0 || (fVar2 = this.f23513f) == null) {
                        return;
                    }
                    fVar2.a(this.f23509b);
                    return;
                }
                this.f23509b.setSpan("", this.f23510c, this.f23511d, 33);
                int[] iArr2 = this.f23512e;
                int i4 = iArr2[0] - 1;
                iArr2[0] = i4;
                if (i4 != 0 || (fVar = this.f23513f) == null) {
                    return;
                }
                fVar.a(this.f23509b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends c.a.e.e.l.c<c.a.e.l.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f23514a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f23515b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f23516c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f23517d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f23518e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f23519f;

        public e(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), iArr, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23514a = context;
            this.f23515b = spannableStringBuilder;
            this.f23516c = i2;
            this.f23517d = i3;
            this.f23518e = iArr;
            this.f23519f = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.l.c
        public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
            f fVar;
            Bitmap p;
            f fVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((e) aVar, str, i2);
                if (aVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                    int dimensionPixelSize = this.f23514a.getResources().getDimensionPixelSize(R.dimen.ds80);
                    int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                    if (width > l.k(this.f23514a) * 0.6d) {
                        width = (int) (p.getWidth() * 0.5d);
                    }
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.f23515b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f23516c, this.f23517d, 33);
                    int[] iArr = this.f23518e;
                    int i3 = iArr[0] - 1;
                    iArr[0] = i3;
                    if (i3 != 0 || (fVar2 = this.f23519f) == null) {
                        return;
                    }
                    fVar2.a(this.f23515b);
                    return;
                }
                this.f23515b.setSpan("", this.f23516c, this.f23517d, 33);
                int[] iArr2 = this.f23518e;
                int i4 = iArr2[0] - 1;
                iArr2[0] = i4;
                if (i4 != 0 || (fVar = this.f23519f) == null) {
                    return;
                }
                fVar.a(this.f23515b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(SpannableStringBuilder spannableStringBuilder);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(50231294, "Lc/a/q0/p0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(50231294, "Lc/a/q0/p0/b;");
                return;
            }
        }
        f23495a = new KeyEvent(0, 67);
    }

    public static void a(EditText editText) {
        Editable text;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, editText) == null) || editText == null || (text = editText.getText()) == null) {
            return;
        }
        int selectionStart = editText.getSelectionStart() - 1;
        if (selectionStart > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
            editText.onKeyDown(67, f23495a);
        }
        editText.onKeyDown(67, f23495a);
        int selectionStart2 = editText.getSelectionStart();
        if (text != null) {
            editText.setSelection(selectionStart2);
        }
    }

    public static void b(Context context, v vVar, EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, context, vVar, editText) == null) || vVar == null || editText == null || vVar.c() == null) {
            return;
        }
        String c2 = vVar.c();
        EmotionGroupType f2 = vVar.f();
        if (f2 != EmotionGroupType.LOCAL && f2 != EmotionGroupType.USER_COLLECT && !c2.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            editText.getText().insert(editText.getSelectionStart(), c2);
        } else if (c2 != null) {
            c.a.e.e.l.d.h().k(c2, 20, new C1085b(editText, context, new SpannableStringBuilder(c2), f2), 0, 0, BdUniqueId.gen(), null, c2, Boolean.FALSE, null);
        }
    }

    public static void c(Context context, v vVar, EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, context, vVar, editText) == null) || vVar == null || TextUtils.isEmpty(vVar.c()) || TextUtils.isEmpty(vVar.g()) || editText == null) {
            return;
        }
        editText.getText().toString();
        c.a.e.e.l.d.h().k(vVar.g(), 10, new a(editText, context, vVar), 0, 0, BdUniqueId.gen(), new Object[0]);
    }

    public static void d(Context context, String str, f fVar) {
        String str2;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, fVar) == null) || context == null || TextUtils.isEmpty(str) || fVar == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int[] iArr = {c.a.q0.p0.a.a(str)};
        if (iArr[0] <= 0) {
            if (fVar != null) {
                fVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = c.a.q0.p0.a.f23493a.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                c.a.e.e.l.d.h().k(group, 20, new c(spannableStringBuilder, start, end, iArr, fVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableStringBuilder);
        while (true) {
            str2 = ",";
            if (!matcher2.find()) {
                break;
            }
            String group2 = matcher2.group();
            String[] split = group2.split(",");
            if (split != null && split.length == 5) {
                c.a.e.e.l.d.h().k(group2, 20, new d(context, spannableStringBuilder, matcher2.start(), matcher2.end(), iArr, fVar), 0, 0, BdUniqueId.gen(), null, group2, Boolean.FALSE, null);
            }
        }
        Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(spannableStringBuilder);
        while (matcher3.find()) {
            String[] split2 = matcher3.group().split(str2);
            if (split2 != null && split2.length == 6) {
                String str3 = str2;
                e eVar = new e(context, spannableStringBuilder, matcher3.start(), matcher3.end(), iArr, fVar);
                if (!TextUtils.isEmpty(split2[1])) {
                    c.a.e.e.l.d.h().k(Uri.decode(split2[1].replace("net_", "")), 10, eVar, 0, 0, BdUniqueId.gen(), new Object[0]);
                }
                str2 = str3;
            }
        }
    }

    public static void e(Context context, EditText editText, SpannableStringBuilder spannableStringBuilder, int i2, c.a.e.l.d.a aVar, EmotionGroupType emotionGroupType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, editText, spannableStringBuilder, Integer.valueOf(i2), aVar, emotionGroupType}) == null) || context == null || editText == null || TextUtils.isEmpty(spannableStringBuilder) || aVar == null) {
            return;
        }
        Bitmap p = aVar.p();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
        int width = p.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            int i3 = c.a.p0.b.d.Z() ? (int) (width * 0.4d) : (int) (width * 0.5d);
            bitmapDrawable.setBounds(0, 0, i3, i3);
        } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds80);
            int width2 = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
            if (width2 > editText.getMeasuredWidth()) {
                width2 = (int) (p.getWidth() * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new c.a.q0.p0.d.a(bitmapDrawable, 1), 0, spannableStringBuilder.length(), 33);
        editText.getText().insert(i2, spannableStringBuilder);
    }
}
