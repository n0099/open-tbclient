package b.a.r0.m3.j0;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import b.a.q0.c1.u;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
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
/* loaded from: classes5.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final Pattern f22470f;

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f22471g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f22472a;

    /* renamed from: b  reason: collision with root package name */
    public String f22473b;

    /* renamed from: c  reason: collision with root package name */
    public String f22474c;

    /* renamed from: d  reason: collision with root package name */
    public String f22475d;

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f22476e;

    /* loaded from: classes5.dex */
    public class a extends u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f22477f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m mVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22477f = mVar;
        }

        @Override // b.a.q0.c1.u, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b(this.f22477f.f22473b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f22478f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(m mVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22478f = mVar;
        }

        @Override // b.a.q0.c1.u, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Matcher matcher = m.f22470f.matcher(this.f22478f.f22475d);
                if (matcher.find()) {
                    try {
                        String group = matcher.group();
                        a(group.substring(group.lastIndexOf("/") + 1));
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                Matcher matcher2 = m.f22471g.matcher(this.f22478f.f22475d);
                if (matcher2.find()) {
                    try {
                        String group2 = matcher2.group();
                        a(group2.substring(group2.lastIndexOf("=") + 1));
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                b(this.f22478f.f22475d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f22479f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(m mVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22479f = mVar;
        }

        @Override // b.a.q0.c1.u, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f22479f.f22473b != null) {
                    this.f22479f.f22473b.replace("@", "").replace(" ", "");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getContext()).createNormalConfig(b.a.e.f.m.b.g(this.f22479f.f22475d, 0L), false, false)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(223513784, "Lb/a/r0/m3/j0/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(223513784, "Lb/a/r0/m3/j0/m;");
                return;
            }
        }
        f22470f = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
        f22471g = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22472a = 0;
        this.f22473b = null;
        this.f22475d = null;
        this.f22476e = null;
    }

    public static boolean k(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3)) == null) ? (i2 != 0 || i3 == 3 || i3 == 2) ? false : true : invokeII.booleanValue;
    }

    public SpannableStringBuilder e(SpannableString spannableString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, spannableString)) == null) {
            if (this.f22476e == null) {
                this.f22476e = new SpannableStringBuilder();
            }
            this.f22476e.append((CharSequence) spannableString);
            return this.f22476e;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22474c : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22475d : (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22472a : invokeV.intValue;
    }

    public SpannableString h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            int i2 = this.f22472a;
            if (i2 != 0) {
                if (i2 == 1) {
                    if (!this.f22473b.endsWith(" ")) {
                        this.f22473b += " ";
                    }
                    SpannableString spannableString = new SpannableString(this.f22473b);
                    spannableString.setSpan(new b(this, context), 0, this.f22473b.length() - 1, 33);
                    return spannableString;
                } else if (i2 == 2) {
                    SpannableString spannableString2 = new SpannableString(this.f22473b + " ");
                    b.a.e.m.d.a face = TbadkCoreApplication.getInst().getFace(this.f22473b);
                    if (face != null) {
                        BitmapDrawable j = face.j();
                        j.setBounds(0, 0, face.r(), face.m());
                        spannableString2.setSpan(new ImageSpan(j, 1), 0, this.f22473b.length(), 33);
                    }
                    return spannableString2;
                } else if (i2 == 4) {
                    if (!this.f22473b.endsWith(" ")) {
                        this.f22473b += " ";
                    }
                    SpannableString spannableString3 = new SpannableString(this.f22473b);
                    spannableString3.setSpan(new c(this, context), 0, this.f22473b.length() - 1, 33);
                    return spannableString3;
                } else if (i2 != 5) {
                    return null;
                } else {
                    if (!this.f22473b.endsWith(" ")) {
                        this.f22473b += " ";
                    }
                    String string = context.getString(R.string.video);
                    String str = string + this.f22473b;
                    SpannableString spannableString4 = new SpannableString(str);
                    spannableString4.setSpan(new a(this, context), string.length(), str.length() - 1, 33);
                    return spannableString4;
                }
            }
            return new SpannableString(this.f22473b);
        }
        return (SpannableString) invokeL.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22473b : (String) invokeV.objValue;
    }

    public SpannableStringBuilder j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22476e : (SpannableStringBuilder) invokeV.objValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f22472a = i2;
        }
    }
}
