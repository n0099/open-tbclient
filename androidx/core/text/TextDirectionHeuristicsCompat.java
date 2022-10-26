package androidx.core.text;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.CharBuffer;
import java.util.Locale;
/* loaded from: classes.dex */
public final class TextDirectionHeuristicsCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final TextDirectionHeuristicCompat ANYRTL_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE;
    public static final TextDirectionHeuristicCompat LTR;
    public static final TextDirectionHeuristicCompat RTL;
    public static final int STATE_FALSE = 1;
    public static final int STATE_TRUE = 0;
    public static final int STATE_UNKNOWN = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface TextDirectionAlgorithm {
        int checkRtl(CharSequence charSequence, int i, int i2);
    }

    public static int isRtlText(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                return (i == 1 || i == 2) ? 0 : 2;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public static int isRtlTextOrFormat(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i != 0) {
                if (i == 1 || i == 2) {
                    return 0;
                }
                switch (i) {
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                        return 0;
                    default:
                        return 2;
                }
            }
            return 1;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes.dex */
    public static class AnyStrong implements TextDirectionAlgorithm {
        public static /* synthetic */ Interceptable $ic;
        public static final AnyStrong INSTANCE_RTL;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean mLookForRtl;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(816161803, "Landroidx/core/text/TextDirectionHeuristicsCompat$AnyStrong;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(816161803, "Landroidx/core/text/TextDirectionHeuristicsCompat$AnyStrong;");
                    return;
                }
            }
            INSTANCE_RTL = new AnyStrong(true);
        }

        public AnyStrong(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mLookForRtl = z;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence charSequence, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, charSequence, i, i2)) == null) {
                int i3 = i2 + i;
                boolean z = false;
                while (i < i3) {
                    int isRtlText = TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(charSequence.charAt(i)));
                    if (isRtlText != 0) {
                        if (isRtlText == 1) {
                            if (!this.mLookForRtl) {
                                return 1;
                            }
                        } else {
                            continue;
                            i++;
                        }
                    } else if (this.mLookForRtl) {
                        return 0;
                    }
                    z = true;
                    i++;
                }
                if (z) {
                    return this.mLookForRtl ? 1 : 0;
                }
                return 2;
            }
            return invokeLII.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class FirstStrong implements TextDirectionAlgorithm {
        public static /* synthetic */ Interceptable $ic;
        public static final FirstStrong INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1463627271, "Landroidx/core/text/TextDirectionHeuristicsCompat$FirstStrong;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1463627271, "Landroidx/core/text/TextDirectionHeuristicsCompat$FirstStrong;");
                    return;
                }
            }
            INSTANCE = new FirstStrong();
        }

        public FirstStrong() {
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

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(CharSequence charSequence, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, charSequence, i, i2)) == null) {
                int i3 = i2 + i;
                int i4 = 2;
                while (i < i3 && i4 == 2) {
                    i4 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(charSequence.charAt(i)));
                    i++;
                }
                return i4;
            }
            return invokeLII.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextDirectionAlgorithm mAlgorithm;

        public abstract boolean defaultIsRtl();

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textDirectionAlgorithm};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAlgorithm = textDirectionAlgorithm;
        }

        private boolean doCheck(CharSequence charSequence, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, this, charSequence, i, i2)) == null) {
                int checkRtl = this.mAlgorithm.checkRtl(charSequence, i, i2);
                if (checkRtl == 0) {
                    return true;
                }
                if (checkRtl != 1) {
                    return defaultIsRtl();
                }
                return false;
            }
            return invokeLII.booleanValue;
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(CharSequence charSequence, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2)) == null) {
                if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
                    if (this.mAlgorithm == null) {
                        return defaultIsRtl();
                    }
                    return doCheck(charSequence, i, i2);
                }
                throw new IllegalArgumentException();
            }
            return invokeLII.booleanValue;
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] cArr, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, cArr, i, i2)) == null) {
                return isRtl(CharBuffer.wrap(cArr), i, i2);
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean mDefaultIsRtl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textDirectionAlgorithm, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((TextDirectionAlgorithm) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDefaultIsRtl = z;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public boolean defaultIsRtl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mDefaultIsRtl;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        public static /* synthetic */ Interceptable $ic;
        public static final TextDirectionHeuristicLocale INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-586312266, "Landroidx/core/text/TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-586312266, "Landroidx/core/text/TextDirectionHeuristicsCompat$TextDirectionHeuristicLocale;");
                    return;
                }
            }
            INSTANCE = new TextDirectionHeuristicLocale();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextDirectionHeuristicLocale() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((TextDirectionAlgorithm) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public boolean defaultIsRtl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(377328330, "Landroidx/core/text/TextDirectionHeuristicsCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(377328330, "Landroidx/core/text/TextDirectionHeuristicsCompat;");
                return;
            }
        }
        LTR = new TextDirectionHeuristicInternal(null, false);
        RTL = new TextDirectionHeuristicInternal(null, true);
        FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
        FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
        ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
        LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }

    public TextDirectionHeuristicsCompat() {
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
}
