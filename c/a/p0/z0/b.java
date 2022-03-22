package c.a.p0.z0;

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
import c.a.d.f.p.n;
import c.a.o0.s.c.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
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
    public static final KeyEvent a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f20858b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ u f20859c;

        public a(EditText editText, Context context, u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, context, uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editText;
            this.f20858b = context;
            this.f20859c = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) || aVar == null) {
                return;
            }
            int selectionStart = this.a.getSelectionStart();
            b.f(this.f20858b, this.a, new SpannableStringBuilder(this.f20859c.c()), selectionStart < 0 ? 0 : selectionStart, aVar, this.f20859c.getType());
        }
    }

    /* renamed from: c.a.p0.z0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1560b extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f20860b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f20861c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f20862d;

        public C1560b(EditText editText, Context context, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, context, spannableStringBuilder, emotionGroupType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editText;
            this.f20860b = context;
            this.f20861c = spannableStringBuilder;
            this.f20862d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) {
                super.onLoaded((C1560b) aVar, str, i);
                if (aVar != null) {
                    int selectionStart = this.a.getSelectionStart();
                    b.f(this.f20860b, this.a, this.f20861c, selectionStart < 0 ? 0 : selectionStart, aVar, this.f20862d);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f20863b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20864c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f20865d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f20866e;

        public c(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.f20863b = i;
            this.f20864c = i2;
            this.f20865d = iArr;
            this.f20866e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            g gVar;
            g gVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) {
                super.onLoaded((c) aVar, str, i);
                if (aVar != null) {
                    Bitmap p = aVar.p();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                    int width = (int) (p.getWidth() * (UbsABTestHelper.isResizeEmotionABTest() ? 0.4d : 0.5d));
                    bitmapDrawable.setBounds(0, 0, width, width);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new c.a.d.o.b(bitmapDrawable, 1), this.f20863b, this.f20864c, 33);
                    int[] iArr = this.f20865d;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 != 0 || (gVar2 = this.f20866e) == null) {
                        return;
                    }
                    gVar2.a(this.a);
                    return;
                }
                this.a.setSpan("", this.f20863b, this.f20864c, 33);
                int[] iArr2 = this.f20865d;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 != 0 || (gVar = this.f20866e) == null) {
                    return;
                }
                gVar.a(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f20867b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20868c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f20869d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f20870e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f20871f;

        public d(Context context, SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f20867b = spannableStringBuilder;
            this.f20868c = i;
            this.f20869d = i2;
            this.f20870e = iArr;
            this.f20871f = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            g gVar;
            Bitmap p;
            g gVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) {
                super.onLoaded((d) aVar, str, i);
                if (aVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
                    int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                    if (width > n.k(this.a) * 0.6d) {
                        width = (int) (p.getWidth() * 0.5d);
                    }
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.f20867b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f20868c, this.f20869d, 33);
                    int[] iArr = this.f20870e;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 != 0 || (gVar2 = this.f20871f) == null) {
                        return;
                    }
                    gVar2.a(this.f20867b);
                    return;
                }
                this.f20867b.setSpan("", this.f20868c, this.f20869d, 33);
                int[] iArr2 = this.f20870e;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 != 0 || (gVar = this.f20871f) == null) {
                    return;
                }
                gVar.a(this.f20867b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f20872b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20873c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f20874d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f20875e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f20876f;

        public e(Context context, SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f20872b = spannableStringBuilder;
            this.f20873c = i;
            this.f20874d = i2;
            this.f20875e = iArr;
            this.f20876f = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            g gVar;
            Bitmap p;
            g gVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) {
                super.onLoaded((e) aVar, str, i);
                if (aVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
                    int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                    if (width > n.k(this.a) * 0.6d) {
                        width = (int) (p.getWidth() * 0.5d);
                    }
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.f20872b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f20873c, this.f20874d, 33);
                    int[] iArr = this.f20875e;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 != 0 || (gVar2 = this.f20876f) == null) {
                        return;
                    }
                    gVar2.a(this.f20872b);
                    return;
                }
                this.f20872b.setSpan("", this.f20873c, this.f20874d, 33);
                int[] iArr2 = this.f20875e;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 != 0 || (gVar = this.f20876f) == null) {
                    return;
                }
                gVar.a(this.f20872b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f20877b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20878c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f20879d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f20880e;

        public f(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.f20877b = i;
            this.f20878c = i2;
            this.f20879d = iArr;
            this.f20880e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            g gVar;
            g gVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) {
                super.onLoaded((f) aVar, str, i);
                if (aVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds54);
                    bitmapDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new c.a.d.o.b(bitmapDrawable, 1), this.f20877b, this.f20878c, 33);
                    int[] iArr = this.f20879d;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 != 0 || (gVar2 = this.f20880e) == null) {
                        return;
                    }
                    gVar2.a(this.a);
                    return;
                }
                this.a.setSpan("", this.f20877b, this.f20878c, 33);
                int[] iArr2 = this.f20879d;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 != 0 || (gVar = this.f20880e) == null) {
                    return;
                }
                gVar.a(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(SpannableStringBuilder spannableStringBuilder);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1683343831, "Lc/a/p0/z0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1683343831, "Lc/a/p0/z0/b;");
                return;
            }
        }
        a = new KeyEvent(0, 67);
    }

    public static void a(EditText editText) {
        Editable text;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, editText) == null) || editText == null || (text = editText.getText()) == null) {
            return;
        }
        int selectionStart = editText.getSelectionStart() - 1;
        if (selectionStart > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
            editText.onKeyDown(67, a);
        }
        editText.onKeyDown(67, a);
        int selectionStart2 = editText.getSelectionStart();
        if (text != null) {
            editText.setSelection(selectionStart2);
        }
    }

    public static void b(Context context, u uVar, EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, context, uVar, editText) == null) || uVar == null || editText == null || uVar.c() == null) {
            return;
        }
        String c2 = uVar.c();
        EmotionGroupType type = uVar.getType();
        if (type != EmotionGroupType.LOCAL && type != EmotionGroupType.USER_COLLECT && !c2.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            editText.getText().insert(editText.getSelectionStart(), c2);
        } else if (c2 != null) {
            c.a.d.f.l.d.h().k(c2, 20, new C1560b(editText, context, new SpannableStringBuilder(c2), type), 0, 0, BdUniqueId.gen(), null, c2, Boolean.FALSE, null);
        }
    }

    public static void c(Context context, u uVar, EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, context, uVar, editText) == null) || uVar == null || TextUtils.isEmpty(uVar.c()) || TextUtils.isEmpty(uVar.f()) || editText == null) {
            return;
        }
        editText.getText().toString();
        c.a.d.f.l.d.h().k(uVar.f(), 10, new a(editText, context, uVar), 0, 0, BdUniqueId.gen(), new Object[0]);
    }

    public static void d(Context context, CharSequence charSequence, g gVar) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, charSequence, gVar) == null) || context == null || TextUtils.isEmpty(charSequence) || gVar == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int[] iArr = {c.a.p0.z0.a.a(charSequence)};
        if (iArr[0] <= 0) {
            if (gVar != null) {
                gVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = c.a.p0.z0.a.a.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                c.a.d.f.l.d.h().k(group, 20, new f(spannableStringBuilder, start, end, iArr, gVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
            }
        }
    }

    public static void e(Context context, CharSequence charSequence, g gVar) {
        String str;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, context, charSequence, gVar) == null) || context == null || TextUtils.isEmpty(charSequence) || gVar == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int[] iArr = {c.a.p0.z0.a.a(charSequence)};
        if (iArr[0] <= 0) {
            if (gVar != null) {
                gVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = c.a.p0.z0.a.a.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                c.a.d.f.l.d.h().k(group, 20, new c(spannableStringBuilder, start, end, iArr, gVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableStringBuilder);
        while (true) {
            str = ",";
            if (!matcher2.find()) {
                break;
            }
            String group2 = matcher2.group();
            String[] split = group2.split(",");
            if (split != null && split.length == 5) {
                c.a.d.f.l.d.h().k(group2, 20, new d(context, spannableStringBuilder, matcher2.start(), matcher2.end(), iArr, gVar), 0, 0, BdUniqueId.gen(), null, group2, Boolean.FALSE, null);
            }
        }
        Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(spannableStringBuilder);
        while (matcher3.find()) {
            String[] split2 = matcher3.group().split(str);
            if (split2 != null && split2.length == 6) {
                String str2 = str;
                e eVar = new e(context, spannableStringBuilder, matcher3.start(), matcher3.end(), iArr, gVar);
                if (!TextUtils.isEmpty(split2[1])) {
                    c.a.d.f.l.d.h().k(Uri.decode(split2[1].replace("net_", "")), 10, eVar, 0, 0, BdUniqueId.gen(), new Object[0]);
                }
                str = str2;
            }
        }
    }

    public static void f(Context context, EditText editText, SpannableStringBuilder spannableStringBuilder, int i, c.a.d.o.d.a aVar, EmotionGroupType emotionGroupType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, editText, spannableStringBuilder, Integer.valueOf(i), aVar, emotionGroupType}) == null) || context == null || editText == null || TextUtils.isEmpty(spannableStringBuilder) || aVar == null) {
            return;
        }
        Bitmap p = aVar.p();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
        int width = p.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            int i2 = UbsABTestHelper.isResizeEmotionABTest() ? (int) (width * 0.4d) : (int) (width * 0.5d);
            bitmapDrawable.setBounds(0, 0, i2, i2);
        } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
            int width2 = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
            if (width2 > editText.getMeasuredWidth()) {
                width2 = (int) (p.getWidth() * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new c.a.p0.z0.d.a(bitmapDrawable, 1), 0, spannableStringBuilder.length(), 33);
        editText.getText().insert(i, spannableStringBuilder);
    }
}
