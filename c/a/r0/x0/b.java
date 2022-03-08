package c.a.r0.x0;

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
import c.a.q0.s.c.u;
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
        public final /* synthetic */ Context f24473b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ u f24474c;

        public a(EditText editText, Context context, u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, context, uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editText;
            this.f24473b = context;
            this.f24474c = uVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null) {
                return;
            }
            int selectionStart = this.a.getSelectionStart();
            b.f(this.f24473b, this.a, new SpannableStringBuilder(this.f24474c.c()), selectionStart < 0 ? 0 : selectionStart, aVar, this.f24474c.getType());
        }
    }

    /* renamed from: c.a.r0.x0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1506b extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f24475b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f24476c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ EmotionGroupType f24477d;

        public C1506b(EditText editText, Context context, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
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
            this.a = editText;
            this.f24475b = context;
            this.f24476c = spannableStringBuilder;
            this.f24477d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((C1506b) aVar, str, i2);
                if (aVar != null) {
                    int selectionStart = this.a.getSelectionStart();
                    b.f(this.f24475b, this.a, this.f24476c, selectionStart < 0 ? 0 : selectionStart, aVar, this.f24477d);
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
        public final /* synthetic */ int f24478b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24479c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f24480d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f24481e;

        public c(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), iArr, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.f24478b = i2;
            this.f24479c = i3;
            this.f24480d = iArr;
            this.f24481e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i2) {
            g gVar;
            g gVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((c) aVar, str, i2);
                if (aVar != null) {
                    Bitmap p = aVar.p();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                    int width = (int) (p.getWidth() * (UbsABTestHelper.isResizeEmotionABTest() ? 0.4d : 0.5d));
                    bitmapDrawable.setBounds(0, 0, width, width);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new c.a.d.o.b(bitmapDrawable, 1), this.f24478b, this.f24479c, 33);
                    int[] iArr = this.f24480d;
                    int i3 = iArr[0] - 1;
                    iArr[0] = i3;
                    if (i3 != 0 || (gVar2 = this.f24481e) == null) {
                        return;
                    }
                    gVar2.a(this.a);
                    return;
                }
                this.a.setSpan("", this.f24478b, this.f24479c, 33);
                int[] iArr2 = this.f24480d;
                int i4 = iArr2[0] - 1;
                iArr2[0] = i4;
                if (i4 != 0 || (gVar = this.f24481e) == null) {
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
        public final /* synthetic */ SpannableStringBuilder f24482b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24483c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f24484d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f24485e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f24486f;

        public d(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), iArr, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f24482b = spannableStringBuilder;
            this.f24483c = i2;
            this.f24484d = i3;
            this.f24485e = iArr;
            this.f24486f = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i2) {
            g gVar;
            Bitmap p;
            g gVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((d) aVar, str, i2);
                if (aVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.ds80);
                    int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                    if (width > n.k(this.a) * 0.6d) {
                        width = (int) (p.getWidth() * 0.5d);
                    }
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.f24482b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f24483c, this.f24484d, 33);
                    int[] iArr = this.f24485e;
                    int i3 = iArr[0] - 1;
                    iArr[0] = i3;
                    if (i3 != 0 || (gVar2 = this.f24486f) == null) {
                        return;
                    }
                    gVar2.a(this.f24482b);
                    return;
                }
                this.f24482b.setSpan("", this.f24483c, this.f24484d, 33);
                int[] iArr2 = this.f24485e;
                int i4 = iArr2[0] - 1;
                iArr2[0] = i4;
                if (i4 != 0 || (gVar = this.f24486f) == null) {
                    return;
                }
                gVar.a(this.f24482b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f24487b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24488c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f24489d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int[] f24490e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f24491f;

        public e(Context context, SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), iArr, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f24487b = spannableStringBuilder;
            this.f24488c = i2;
            this.f24489d = i3;
            this.f24490e = iArr;
            this.f24491f = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i2) {
            g gVar;
            Bitmap p;
            g gVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((e) aVar, str, i2);
                if (aVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.ds80);
                    int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                    if (width > n.k(this.a) * 0.6d) {
                        width = (int) (p.getWidth() * 0.5d);
                    }
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.f24487b.setSpan(new ImageSpan(bitmapDrawable, 0), this.f24488c, this.f24489d, 33);
                    int[] iArr = this.f24490e;
                    int i3 = iArr[0] - 1;
                    iArr[0] = i3;
                    if (i3 != 0 || (gVar2 = this.f24491f) == null) {
                        return;
                    }
                    gVar2.a(this.f24487b);
                    return;
                }
                this.f24487b.setSpan("", this.f24488c, this.f24489d, 33);
                int[] iArr2 = this.f24490e;
                int i4 = iArr2[0] - 1;
                iArr2[0] = i4;
                if (i4 != 0 || (gVar = this.f24491f) == null) {
                    return;
                }
                gVar.a(this.f24487b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f24492b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24493c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f24494d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f24495e;

        public f(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int[] iArr, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), iArr, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.f24492b = i2;
            this.f24493c = i3;
            this.f24494d = iArr;
            this.f24495e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i2) {
            g gVar;
            g gVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((f) aVar, str, i2);
                if (aVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.p());
                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds54);
                    bitmapDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new c.a.d.o.b(bitmapDrawable, 1), this.f24492b, this.f24493c, 33);
                    int[] iArr = this.f24494d;
                    int i3 = iArr[0] - 1;
                    iArr[0] = i3;
                    if (i3 != 0 || (gVar2 = this.f24495e) == null) {
                        return;
                    }
                    gVar2.a(this.a);
                    return;
                }
                this.a.setSpan("", this.f24492b, this.f24493c, 33);
                int[] iArr2 = this.f24494d;
                int i4 = iArr2[0] - 1;
                iArr2[0] = i4;
                if (i4 != 0 || (gVar = this.f24495e) == null) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1800429797, "Lc/a/r0/x0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1800429797, "Lc/a/r0/x0/b;");
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
            c.a.d.f.l.d.h().k(c2, 20, new C1506b(editText, context, new SpannableStringBuilder(c2), type), 0, 0, BdUniqueId.gen(), null, c2, Boolean.FALSE, null);
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
        int[] iArr = {c.a.r0.x0.a.a(charSequence)};
        if (iArr[0] <= 0) {
            if (gVar != null) {
                gVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = c.a.r0.x0.a.a.matcher(spannableStringBuilder);
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
        int[] iArr = {c.a.r0.x0.a.a(charSequence)};
        if (iArr[0] <= 0) {
            if (gVar != null) {
                gVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = c.a.r0.x0.a.a.matcher(spannableStringBuilder);
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

    public static void f(Context context, EditText editText, SpannableStringBuilder spannableStringBuilder, int i2, c.a.d.o.d.a aVar, EmotionGroupType emotionGroupType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, editText, spannableStringBuilder, Integer.valueOf(i2), aVar, emotionGroupType}) == null) || context == null || editText == null || TextUtils.isEmpty(spannableStringBuilder) || aVar == null) {
            return;
        }
        Bitmap p = aVar.p();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
        int width = p.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            int i3 = UbsABTestHelper.isResizeEmotionABTest() ? (int) (width * 0.4d) : (int) (width * 0.5d);
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
        spannableStringBuilder.setSpan(new c.a.r0.x0.d.a(bitmapDrawable, 1), 0, spannableStringBuilder.length(), 33);
        editText.getText().insert(i2, spannableStringBuilder);
    }
}
