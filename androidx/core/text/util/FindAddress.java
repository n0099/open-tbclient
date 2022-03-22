package androidx.core.text.util;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.d.D;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FindAddress {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HOUSE_COMPONENT = "(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
    public static final String HOUSE_END = "(?=[,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    public static final String HOUSE_POST_DELIM = ",\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    public static final String HOUSE_PRE_DELIM = ":,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    public static final int MAX_ADDRESS_LINES = 5;
    public static final int MAX_ADDRESS_WORDS = 14;
    public static final int MAX_LOCATION_NAME_DISTANCE = 5;
    public static final int MIN_ADDRESS_WORDS = 4;
    public static final String NL = "\n\u000b\f\r\u0085\u2028\u2029";
    public static final String SP = "\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000";
    public static final String WORD_DELIM = ",*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    public static final String WORD_END = "(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";
    public static final String WS = "\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";
    public static final int kMaxAddressNameWordLength = 25;
    public static final Pattern sHouseNumberRe;
    public static final Pattern sLocationNameRe;
    public static final Pattern sStateRe;
    public static final ZipRange[] sStateZipCodeRanges;
    public static final Pattern sSuffixedNumberRe;
    public static final Pattern sWordRe;
    public static final Pattern sZipCodeRe;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class ZipRange {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mException1;
        public int mException2;
        public int mHigh;
        public int mLow;

        public ZipRange(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLow = i;
            this.mHigh = i2;
            this.mException1 = i3;
            this.mException2 = i4;
        }

        public boolean matches(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                int parseInt = Integer.parseInt(str.substring(0, 2));
                return (this.mLow <= parseInt && parseInt <= this.mHigh) || parseInt == this.mException1 || parseInt == this.mException2;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-354166303, "Landroidx/core/text/util/FindAddress;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-354166303, "Landroidx/core/text/util/FindAddress;");
                return;
            }
        }
        sStateZipCodeRanges = new ZipRange[]{new ZipRange(99, 99, -1, -1), new ZipRange(35, 36, -1, -1), new ZipRange(71, 72, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(85, 86, -1, -1), new ZipRange(90, 96, -1, -1), new ZipRange(80, 81, -1, -1), new ZipRange(6, 6, -1, -1), new ZipRange(20, 20, -1, -1), new ZipRange(19, 19, -1, -1), new ZipRange(32, 34, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(30, 31, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(50, 52, -1, -1), new ZipRange(83, 83, -1, -1), new ZipRange(60, 62, -1, -1), new ZipRange(46, 47, -1, -1), new ZipRange(66, 67, 73, -1), new ZipRange(40, 42, -1, -1), new ZipRange(70, 71, -1, -1), new ZipRange(1, 2, -1, -1), new ZipRange(20, 21, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(48, 49, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(63, 65, -1, -1), new ZipRange(96, 96, -1, -1), new ZipRange(38, 39, -1, -1), new ZipRange(55, 56, -1, -1), new ZipRange(27, 28, -1, -1), new ZipRange(58, 58, -1, -1), new ZipRange(68, 69, -1, -1), new ZipRange(3, 4, -1, -1), new ZipRange(7, 8, -1, -1), new ZipRange(87, 88, 86, -1), new ZipRange(88, 89, 96, -1), new ZipRange(10, 14, 0, 6), new ZipRange(43, 45, -1, -1), new ZipRange(73, 74, -1, -1), new ZipRange(97, 97, -1, -1), new ZipRange(15, 19, -1, -1), new ZipRange(6, 6, 0, 9), new ZipRange(96, 96, -1, -1), new ZipRange(2, 2, -1, -1), new ZipRange(29, 29, -1, -1), new ZipRange(57, 57, -1, -1), new ZipRange(37, 38, -1, -1), new ZipRange(75, 79, 87, 88), new ZipRange(84, 84, -1, -1), new ZipRange(22, 24, 20, -1), new ZipRange(6, 9, -1, -1), new ZipRange(5, 5, -1, -1), new ZipRange(98, 99, -1, -1), new ZipRange(53, 54, -1, -1), new ZipRange(24, 26, -1, -1), new ZipRange(82, 83, -1, -1)};
        sWordRe = Pattern.compile("[^,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]+(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sHouseNumberRe = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sStateRe = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+of[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+states[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+of[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+mariana[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+carolina)|(nd|north[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+dakota)|(ne|nebraska)|(nh|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+hampshire)|(nj|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+jersey)|(nm|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+mexico)|(nv|nevada)|(ny|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+rico)|(pw|palau)|(ri|rhode[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+island)|(sc|south[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+carolina)|(sd|south[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+virginia)|(wy|wyoming))(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sLocationNameRe = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
        sSuffixedNumberRe = Pattern.compile("([0-9]+)(st|nd|rd|th)", 2);
        sZipCodeRe = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);
    }

    public FindAddress() {
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        return -r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d9, code lost:
        if (r10 <= 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00db, code lost:
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00dc, code lost:
        if (r9 <= 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00df, code lost:
        r9 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e1, code lost:
        return -r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int attemptMatch(String str, MatchResult matchResult) {
        InterceptResult invokeLL;
        int length;
        MatchResult matchState;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65538, null, str, matchResult)) != null) {
            return invokeLL.intValue;
        }
        int end = matchResult.end();
        Matcher matcher = sWordRe.matcher(str);
        String str2 = "";
        int i = 1;
        int i2 = 1;
        boolean z = true;
        boolean z2 = false;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            if (end < str.length()) {
                if (!matcher.find(end)) {
                    length = str.length();
                    break;
                } else if (matcher.end() - matcher.start() > 25) {
                    length = matcher.end();
                    break;
                } else {
                    while (end < matcher.start()) {
                        int i5 = end + 1;
                        if (NL.indexOf(str.charAt(end)) != -1) {
                            i++;
                        }
                        end = i5;
                    }
                    if (i > 5 || (i2 = i2 + 1) > 14) {
                        break;
                    }
                    if (matchHouseNumber(str, end) == null) {
                        if (!isValidLocationName(matcher.group(0))) {
                            if (i2 == 5 && !z2) {
                                end = matcher.end();
                                break;
                            }
                            if (z2 && i2 > 4 && (matchState = matchState(str, end)) != null) {
                                if (str2.equals("et") && matchState.group(0).equals("al")) {
                                    end = matchState.end();
                                    break;
                                }
                                Matcher matcher2 = sWordRe.matcher(str);
                                if (matcher2.find(matchState.end())) {
                                    if (isValidZipCode(matcher2.group(0), matchState)) {
                                        return matcher2.end();
                                    }
                                } else {
                                    i4 = matchState.end();
                                }
                            }
                            z = false;
                        } else {
                            z = false;
                            z2 = true;
                        }
                    } else if (z && i > 1) {
                        return -end;
                    } else {
                        if (i3 == -1) {
                            i3 = end;
                        }
                    }
                    str2 = matcher.group(0);
                    end = matcher.end();
                }
            } else {
                break;
            }
        }
    }

    public static boolean checkHouseNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (Character.isDigit(str.charAt(i2))) {
                    i++;
                }
            }
            if (i > 5) {
                return false;
            }
            Matcher matcher = sSuffixedNumberRe.matcher(str);
            if (matcher.find()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                if (parseInt == 0) {
                    return false;
                }
                String lowerCase = matcher.group(2).toLowerCase(Locale.getDefault());
                int i3 = parseInt % 10;
                String str2 = D.COLUMU_PLUGIN_APPLICATION_THEME;
                if (i3 == 1) {
                    if (parseInt % 100 != 11) {
                        str2 = "st";
                    }
                    return lowerCase.equals(str2);
                } else if (i3 == 2) {
                    if (parseInt % 100 != 12) {
                        str2 = "nd";
                    }
                    return lowerCase.equals(str2);
                } else if (i3 != 3) {
                    return lowerCase.equals(D.COLUMU_PLUGIN_APPLICATION_THEME);
                } else {
                    if (parseInt % 100 != 13) {
                        str2 = "rd";
                    }
                    return lowerCase.equals(str2);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String findAddress(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            Matcher matcher = sHouseNumberRe.matcher(str);
            int i = 0;
            while (matcher.find(i)) {
                if (checkHouseNumber(matcher.group(0))) {
                    int start = matcher.start();
                    int attemptMatch = attemptMatch(str, matcher);
                    if (attemptMatch > 0) {
                        return str.substring(start, attemptMatch);
                    }
                    i = -attemptMatch;
                } else {
                    i = matcher.end();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @VisibleForTesting
    public static boolean isValidLocationName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? sLocationNameRe.matcher(str).matches() : invokeL.booleanValue;
    }

    public static boolean isValidZipCode(String str, MatchResult matchResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, matchResult)) == null) {
            if (matchResult == null) {
                return false;
            }
            int groupCount = matchResult.groupCount();
            while (true) {
                if (groupCount <= 0) {
                    break;
                }
                int i = groupCount - 1;
                if (matchResult.group(groupCount) != null) {
                    groupCount = i;
                    break;
                }
                groupCount = i;
            }
            return sZipCodeRe.matcher(str).matches() && sStateZipCodeRanges[groupCount].matches(str);
        }
        return invokeLL.booleanValue;
    }

    @VisibleForTesting
    public static MatchResult matchHouseNumber(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, str, i)) == null) {
            if (i <= 0 || HOUSE_PRE_DELIM.indexOf(str.charAt(i - 1)) != -1) {
                Matcher region = sHouseNumberRe.matcher(str).region(i, str.length());
                if (region.lookingAt()) {
                    MatchResult matchResult = region.toMatchResult();
                    if (checkHouseNumber(matchResult.group(0))) {
                        return matchResult;
                    }
                }
                return null;
            }
            return null;
        }
        return (MatchResult) invokeLI.objValue;
    }

    @VisibleForTesting
    public static MatchResult matchState(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, str, i)) == null) {
            if (i <= 0 || WORD_DELIM.indexOf(str.charAt(i - 1)) != -1) {
                Matcher region = sStateRe.matcher(str).region(i, str.length());
                if (region.lookingAt()) {
                    return region.toMatchResult();
                }
                return null;
            }
            return null;
        }
        return (MatchResult) invokeLI.objValue;
    }

    @VisibleForTesting
    public static boolean isValidZipCode(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) ? isValidZipCode(str, matchState(str2, 0)) : invokeLL.booleanValue;
    }

    @VisibleForTesting
    public static boolean isValidZipCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? sZipCodeRe.matcher(str).matches() : invokeL.booleanValue;
    }
}
