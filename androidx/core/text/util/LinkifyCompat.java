package androidx.core.text.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.PatternsCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class LinkifyCompat {
    public static /* synthetic */ Interceptable $ic;
    public static final Comparator<LinkSpec> COMPARATOR;
    public static final String[] EMPTY_STRING;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class LinkSpec {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int end;
        public URLSpan frameworkAddedSpan;
        public int start;
        public String url;

        public LinkSpec() {
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
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface LinkifyMask {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1387922392, "Landroidx/core/text/util/LinkifyCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1387922392, "Landroidx/core/text/util/LinkifyCompat;");
                return;
            }
        }
        EMPTY_STRING = new String[0];
        COMPARATOR = new Comparator<LinkSpec>() { // from class: androidx.core.text.util.LinkifyCompat.1
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(LinkSpec linkSpec, LinkSpec linkSpec2) {
                InterceptResult invokeLL;
                int i;
                int i2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, linkSpec, linkSpec2)) == null) {
                    int i3 = linkSpec.start;
                    int i4 = linkSpec2.start;
                    if (i3 < i4) {
                        return -1;
                    }
                    if (i3 <= i4 && (i = linkSpec.end) >= (i2 = linkSpec2.end)) {
                        return i > i2 ? -1 : 0;
                    }
                    return 1;
                }
                return invokeLL.intValue;
            }
        };
    }

    public LinkifyCompat() {
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

    public static void addLinkMovementMethod(@NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, textView) == null) && !(textView.getMovementMethod() instanceof LinkMovementMethod) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, spannable, i)) == null) {
            if (shouldAddLinksFallbackToFramework()) {
                return Linkify.addLinks(spannable, i);
            }
            if (i == 0) {
                return false;
            }
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
            for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
                spannable.removeSpan(uRLSpanArr[length]);
            }
            if ((i & 4) != 0) {
                Linkify.addLinks(spannable, 4);
            }
            ArrayList arrayList = new ArrayList();
            if ((i & 1) != 0) {
                gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
            }
            if ((i & 2) != 0) {
                gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{WebView.SCHEME_MAILTO}, null, null);
            }
            if ((i & 8) != 0) {
                gatherMapLinks(arrayList, spannable);
            }
            pruneOverlaps(arrayList, spannable);
            if (arrayList.size() == 0) {
                return false;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                LinkSpec linkSpec = (LinkSpec) it.next();
                if (linkSpec.frameworkAddedSpan == null) {
                    applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable);
                }
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static void applyLink(String str, int i, int i2, Spannable spannable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), spannable}) == null) {
            spannable.setSpan(new URLSpan(str), i, i2, 33);
        }
    }

    public static String findAddress(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return android.webkit.WebView.findAddress(str);
            }
            return FindAddress.findAddress(str);
        }
        return (String) invokeL.objValue;
    }

    public static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{arrayList, spannable, pattern, strArr, matchFilter, transformFilter}) == null) {
            Matcher matcher = pattern.matcher(spannable);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                    LinkSpec linkSpec = new LinkSpec();
                    linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                    linkSpec.start = start;
                    linkSpec.end = end;
                    arrayList.add(linkSpec);
                }
            }
        }
    }

    public static void gatherMapLinks(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, arrayList, spannable) == null) {
            String obj = spannable.toString();
            int i = 0;
            while (true) {
                try {
                    String findAddress = findAddress(obj);
                    if (findAddress != null && (indexOf = obj.indexOf(findAddress)) >= 0) {
                        LinkSpec linkSpec = new LinkSpec();
                        int length = findAddress.length() + indexOf;
                        linkSpec.start = indexOf + i;
                        i += length;
                        linkSpec.end = i;
                        obj = obj.substring(length);
                        try {
                            String encode = URLEncoder.encode(findAddress, "UTF-8");
                            linkSpec.url = WebView.SCHEME_GEO + encode;
                            arrayList.add(linkSpec);
                        } catch (UnsupportedEncodingException unused) {
                        }
                    }
                    return;
                } catch (UnsupportedOperationException unused2) {
                    return;
                }
            }
        }
    }

    public static String makeUrl(@NonNull String str, @NonNull String[] strArr, Matcher matcher, @Nullable Linkify.TransformFilter transformFilter) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65551, null, str, strArr, matcher, transformFilter)) == null) {
            if (transformFilter != null) {
                str = transformFilter.transformUrl(matcher, str);
            }
            int i = 0;
            while (true) {
                z = true;
                if (i >= strArr.length) {
                    z = false;
                    break;
                } else if (!str.regionMatches(true, 0, strArr[i], 0, strArr[i].length())) {
                    i++;
                } else if (!str.regionMatches(false, 0, strArr[i], 0, strArr[i].length())) {
                    str = strArr[i] + str.substring(strArr[i].length());
                }
            }
            if (z || strArr.length <= 0) {
                return str;
            }
            return strArr[0] + str;
        }
        return (String) invokeLLLL.objValue;
    }

    public static void pruneOverlaps(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, arrayList, spannable) == null) {
            int i2 = 0;
            Object[] objArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
            for (int i3 = 0; i3 < objArr.length; i3++) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.frameworkAddedSpan = objArr[i3];
                linkSpec.start = spannable.getSpanStart(objArr[i3]);
                linkSpec.end = spannable.getSpanEnd(objArr[i3]);
                arrayList.add(linkSpec);
            }
            Collections.sort(arrayList, COMPARATOR);
            int size = arrayList.size();
            while (i2 < size - 1) {
                LinkSpec linkSpec2 = arrayList.get(i2);
                int i4 = i2 + 1;
                LinkSpec linkSpec3 = arrayList.get(i4);
                int i5 = linkSpec2.start;
                int i6 = linkSpec3.start;
                if (i5 <= i6 && (i = linkSpec2.end) > i6) {
                    int i7 = linkSpec3.end;
                    int i8 = (i7 > i && i - i5 <= i7 - i6) ? i - i5 < i7 - i6 ? i2 : -1 : i4;
                    if (i8 != -1) {
                        Object obj = arrayList.get(i8).frameworkAddedSpan;
                        if (obj != null) {
                            spannable.removeSpan(obj);
                        }
                        arrayList.remove(i8);
                        size--;
                    }
                }
                i2 = i4;
            }
        }
    }

    public static boolean shouldAddLinksFallbackToFramework() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? Build.VERSION.SDK_INT >= 28 : invokeV.booleanValue;
    }

    public static boolean addLinks(@NonNull TextView textView, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, textView, i)) == null) {
            if (shouldAddLinksFallbackToFramework()) {
                return Linkify.addLinks(textView, i);
            }
            if (i == 0) {
                return false;
            }
            CharSequence text = textView.getText();
            if (text instanceof Spannable) {
                if (addLinks((Spannable) text, i)) {
                    addLinkMovementMethod(textView);
                    return true;
                }
                return false;
            }
            SpannableString valueOf = SpannableString.valueOf(text);
            if (addLinks(valueOf, i)) {
                addLinkMovementMethod(textView);
                textView.setText(valueOf);
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, textView, pattern, str) == null) {
            if (shouldAddLinksFallbackToFramework()) {
                Linkify.addLinks(textView, pattern, str);
            } else {
                addLinks(textView, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
            }
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, textView, pattern, str, matchFilter, transformFilter) == null) {
            if (shouldAddLinksFallbackToFramework()) {
                Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
            } else {
                addLinks(textView, pattern, str, (String[]) null, matchFilter, transformFilter);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{textView, pattern, str, strArr, matchFilter, transformFilter}) == null) {
            if (shouldAddLinksFallbackToFramework()) {
                Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
                return;
            }
            SpannableString valueOf = SpannableString.valueOf(textView.getText());
            if (addLinks(valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
                textView.setText(valueOf);
                addLinkMovementMethod(textView);
            }
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, spannable, pattern, str)) == null) {
            if (shouldAddLinksFallbackToFramework()) {
                return Linkify.addLinks(spannable, pattern, str);
            }
            return addLinks(spannable, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65544, null, spannable, pattern, str, matchFilter, transformFilter)) == null) {
            if (shouldAddLinksFallbackToFramework()) {
                return Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter);
            }
            return addLinks(spannable, pattern, str, (String[]) null, matchFilter, transformFilter);
        }
        return invokeLLLLL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{spannable, pattern, str, strArr, matchFilter, transformFilter})) == null) {
            if (shouldAddLinksFallbackToFramework()) {
                return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
            }
            if (str == null) {
                str = "";
            }
            if (strArr == null || strArr.length < 1) {
                strArr = EMPTY_STRING;
            }
            String[] strArr2 = new String[strArr.length + 1];
            strArr2[0] = str.toLowerCase(Locale.ROOT);
            int i = 0;
            while (i < strArr.length) {
                String str2 = strArr[i];
                i++;
                strArr2[i] = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
            }
            Matcher matcher = pattern.matcher(spannable);
            boolean z = false;
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) {
                    applyLink(makeUrl(matcher.group(0), strArr2, matcher, transformFilter), start, end, spannable);
                    z = true;
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }
}
