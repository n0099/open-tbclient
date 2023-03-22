package com.baidu.tbadk.core.util;

import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.cmdRouter.CmdRouter;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.log.ActivityLog;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.tieba.hi;
import com.baidu.tieba.hv4;
import com.baidu.tieba.jg;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.vt5;
import com.baidu.tieba.w58;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class UrlManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_PARAM = "default_param";
    public static final int MATCH = 0;
    public static final int MATCH_AND_FINISH_WEBVIEW = 1;
    public static final int MATCH_REDIRECT_BACK = 2;
    public static final int NOT_MATCH = 3;
    public static final String TAG = "scheme";
    public static final String YUN_PUSH_TAG = "yun_push_tag";
    public static UrlManager mInstance = null;
    public static final Pattern pattern;
    public static final String patternText = "(http://|ftp://|https://|www){1,1}[^一-龥\\s]*";
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentHashMap<String, UrlSchemaHandler> mHandlers;
    public final List<UrlDealListener> mListeners;
    public UrlWebDealListener mWebListener;

    /* loaded from: classes3.dex */
    public interface UrlDealListener {
        int deal(TbPageContext<?> tbPageContext, String[] strArr);
    }

    /* loaded from: classes3.dex */
    public interface UrlSchemaHandler {
        void deal(TbPageContext<?> tbPageContext, Map<String, String> map);
    }

    /* loaded from: classes3.dex */
    public interface UrlWebDealListener {
        void deal(TbPageContext<?> tbPageContext, String str, String str2, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2, Bundle bundle);
    }

    /* loaded from: classes3.dex */
    public interface UrlWebDialogCancelListener {
        void onCancel();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(375116253, "Lcom/baidu/tbadk/core/util/UrlManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(375116253, "Lcom/baidu/tbadk/core/util/UrlManager;");
                return;
            }
        }
        mInstance = new UrlManager() { // from class: com.baidu.tbadk.core.util.UrlManager.1
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
                        AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext.callArgs[0];
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        };
        pattern = Pattern.compile(patternText, 2);
    }

    public static UrlManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return mInstance;
        }
        return (UrlManager) invokeV.objValue;
    }

    public UrlManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mListeners = new LinkedList();
        this.mHandlers = new ConcurrentHashMap<>();
        this.mWebListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addListenerInner(UrlDealListener urlDealListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, urlDealListener) == null) && !this.mListeners.contains(urlDealListener)) {
            this.mListeners.add(urlDealListener);
        }
    }

    public static String getParamStr(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (StringUtils.isNull(str) || (split = str.split("[?]")) == null || split.length <= 1) {
                return null;
            }
            return split[1];
        }
        return (String) invokeL.objValue;
    }

    public boolean UrlValidated(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (pattern.matcher(str).find()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void addListener(UrlDealListener urlDealListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlDealListener) == null) {
            if (hi.E()) {
                addListenerInner(urlDealListener);
            } else {
                jg.a().post(new Runnable(this, urlDealListener) { // from class: com.baidu.tbadk.core.util.UrlManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ UrlManager this$0;
                    public final /* synthetic */ UrlDealListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, urlDealListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = urlDealListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.this$0.addListenerInner(this.val$listener);
                    }
                });
            }
        }
    }

    public boolean dealOneLink(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return dealOneLink(new String[]{str});
        }
        return invokeL.booleanValue;
    }

    public boolean isPbUrl(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, charSequence)) == null) {
            if (charSequence == null) {
                return false;
            }
            return TbPatternsCompat.PB_URL.matcher(charSequence).find();
        }
        return invokeL.booleanValue;
    }

    public boolean isUrlValid(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charSequence)) == null) {
            if (charSequence == null) {
                return false;
            }
            return TbPatternsCompat.WEB_URL.matcher(charSequence).matches();
        }
        return invokeL.booleanValue;
    }

    public void setWebListener(UrlWebDealListener urlWebDealListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, urlWebDealListener) == null) {
            this.mWebListener = urlWebDealListener;
        }
    }

    public boolean dealOneLink(TbPageContext<?> tbPageContext, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, tbPageContext, strArr)) == null) {
            return dealOneLinkWithDialog(tbPageContext, strArr, false, null, false);
        }
        return invokeLL.booleanValue;
    }

    public void registerSchema(String str, UrlSchemaHandler urlSchemaHandler) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, str, urlSchemaHandler) == null) && !StringUtils.isNull(str) && urlSchemaHandler != null) {
            String schemaKey = getSchemaKey(str);
            if (!StringUtils.isNull(schemaKey)) {
                this.mHandlers.put(schemaKey, urlSchemaHandler);
            }
        }
    }

    public static SpannableString findAllWebUrl(String str) {
        InterceptResult invokeL;
        int start;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            Matcher matcher = pattern.matcher(str);
            SpannableString spannableString = new SpannableString(str);
            while (matcher.find()) {
                String group = matcher.group();
                String group2 = matcher.group();
                if (!group2.endsWith(" ")) {
                    group2 = group2 + " ";
                }
                int length = group2.length();
                spannableString.setSpan(new vt5(2, group), matcher.start(), (length + start) - 1, 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    private Map<String, String> getInnerParamPair(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            String[] split = str.split("[&]");
            if (split == null) {
                String[] split2 = str.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                } else {
                    hashMap.put(DEFAULT_PARAM, str);
                }
                return hashMap;
            }
            for (String str2 : split) {
                String[] split3 = str2.split("[=]");
                if (split3.length > 1) {
                    hashMap.put(split3[0], split3[1]);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, String> getParamPair(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            String[] split = str.split("[&]");
            if (split == null) {
                return null;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String getParamStrBehindScheme(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            int lastIndexOf = str.lastIndexOf("://");
            if (lastIndexOf < 0) {
                int lastIndexOf2 = str.lastIndexOf(":");
                if (lastIndexOf2 < 0 || (i = lastIndexOf2 + 1) > str.length()) {
                    return null;
                }
                return str.substring(i);
            }
            int i2 = lastIndexOf + 3;
            if (i2 > str.length()) {
                return null;
            }
            return str.substring(i2);
        }
        return (String) invokeL.objValue;
    }

    private String getSchemaKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            if (str.contains("://")) {
                return str.substring(0, str.lastIndexOf("://") + 2);
            }
            if (str.contains(":")) {
                return str.substring(0, str.lastIndexOf(":"));
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public String getSchemaKeyByUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            if (str.contains("://")) {
                return str.substring(0, str.lastIndexOf("://") + 2);
            }
            if (!str.contains(":")) {
                return null;
            }
            return str.substring(0, str.lastIndexOf(":"));
        }
        return (String) invokeL.objValue;
    }

    public String getTidFromPbUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (!isPbUrl(str)) {
                return null;
            }
            String[] split = str.split("\\?");
            if (split != null && split[0] != null) {
                str = split[0];
            }
            String[] split2 = str.split("/");
            return split2[split2.length - 1];
        }
        return (String) invokeL.objValue;
    }

    private void jumpToWeb(TbPageContext<?> tbPageContext, String str, String str2, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{tbPageContext, str, str2, Boolean.valueOf(z), urlWebDialogCancelListener, Boolean.valueOf(z2), bundle}) == null) && pattern.matcher(str2).find()) {
            this.mWebListener.deal(tbPageContext, str, str2, z, urlWebDialogCancelListener, z2, bundle);
        }
    }

    public void dealOneLink(TbPageContext<?> tbPageContext, String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, str, strArr) == null) {
            dealOneLinkWithDialog(tbPageContext, str, strArr, false, null, false);
        }
    }

    public void dealOneLink(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbPageContext, str, strArr, Boolean.valueOf(z)}) == null) {
            dealOneLinkWithDialog(tbPageContext, str, strArr, false, null, z);
        }
    }

    public void dealOneLink(TbPageContext<?> tbPageContext, String[] strArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, tbPageContext, strArr, z) == null) {
            dealOneLinkWithDialog(tbPageContext, strArr, false, null, z);
        }
    }

    public void dealOneLink(TbPageContext<?> tbPageContext, String[] strArr, boolean z, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{tbPageContext, strArr, Boolean.valueOf(z), bundle}) == null) {
            dealOneLinkWithDialog(tbPageContext, "", strArr, false, null, z, bundle);
        }
    }

    public boolean dealOneLink(TbPageContext<?> tbPageContext, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, str, bundle)) == null) {
            return dealOneLinkWithDialog(tbPageContext, "", new String[]{str}, false, null, false, bundle);
        }
        return invokeLLL.booleanValue;
    }

    public boolean dealOneLink(TbPageContext<?> tbPageContext, String[] strArr, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, strArr, bundle)) == null) {
            return dealOneLinkWithDialog(tbPageContext, "", strArr, false, null, false, bundle);
        }
        return invokeLLL.booleanValue;
    }

    public boolean dealOneLink(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, strArr)) == null) {
            TbPageContext currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity());
            if (currentPageContext == null) {
                return false;
            }
            return dealOneLink(currentPageContext, strArr);
        }
        return invokeL.booleanValue;
    }

    public boolean dealOneLinkWithDialog(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{tbPageContext, str, strArr, Boolean.valueOf(z), urlWebDialogCancelListener, Boolean.valueOf(z2)})) == null) {
            return dealOneLinkWithDialog(tbPageContext, str, strArr, z, urlWebDialogCancelListener, z2, null);
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0158, code lost:
        if (r12.mWebListener == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0160, code lost:
        if (r4.contains("nohead:url") != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0168, code lost:
        if (r4.contains("booktown") != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0170, code lost:
        if (r4.contains("bookreader") == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0174, code lost:
        if (r15.length <= 1) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x017c, code lost:
        if (com.baidu.adp.lib.util.StringUtils.isNull(r15[1]) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0186, code lost:
        if (com.baidu.tbadk.core.util.UrlManager.YUN_PUSH_TAG.equals(r15[1]) == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0188, code lost:
        r4 = new com.baidu.tbadk.core.atomData.MainTabActivityConfig(r13.getPageActivity());
        r4.setTargetScheme(r15[0]);
        com.baidu.adp.framework.MessageManager.getInstance().sendMessage(new com.baidu.adp.framework.message.CustomMessage(2015002, r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a6, code lost:
        jumpToWeb(r13, r14, r15[0], r16, r17, r18, r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b7, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dealOneLinkWithDialog(TbPageContext<?> tbPageContext, String str, String[] strArr, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2, Bundle bundle) {
        InterceptResult invokeCommon;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{tbPageContext, str, strArr, Boolean.valueOf(z), urlWebDialogCancelListener, Boolean.valueOf(z2), bundle})) == null) {
            if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0]) || FullBrowseHelper.checkAndShowFullBrowseModeDialog(tbPageContext)) {
                return false;
            }
            String str2 = strArr[0];
            w58 activityLog = ActivityLog.getInstance();
            activityLog.c("scheme", "dealOneLinkWithDialog:" + str2);
            if (str2.startsWith(UrlSchemaHelper.SCHEMA_TB_FLUTTER)) {
                try {
                    Uri parse = Uri.parse(str2);
                    MessageTask findTask = MessageManager.getInstance().findTask(2002015);
                    HashMap hashMap = new HashMap();
                    String host = parse.getHost();
                    for (String str3 : parse.getQueryParameterNames()) {
                        hashMap.put(str3, parse.getQueryParameter(str3));
                    }
                    FlutterOpenData flutterOpenData = new FlutterOpenData(tbPageContext.getPageActivity(), host, hashMap);
                    if (hv4.c().contains("-Flutter") && findTask == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921674, flutterOpenData));
                        return false;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, flutterOpenData));
                    return false;
                } catch (Exception e) {
                    BdLog.e(e);
                    return false;
                }
            }
            UrlSchemaHandler urlSchemaHandler = this.mHandlers.get(getSchemaKey(str2));
            if (urlSchemaHandler != null) {
                urlSchemaHandler.deal(tbPageContext, getInnerParamPair(getParamStrBehindScheme(str2)));
                return true;
            }
            if (CmdRouter.cmdMaps.getValues("3001000") != null) {
                for (String str4 : CmdRouter.cmdMaps.getValues("3001000")) {
                    for (ArrayList<String> arrayList : CmdRouter.configMaps.getValues(str4)) {
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (str2.contains(it.next())) {
                                try {
                                    Class.forName(str4);
                                } catch (Throwable th) {
                                    BdLog.e(th);
                                }
                            }
                        }
                    }
                }
            }
            Iterator<UrlDealListener> it2 = this.mListeners.iterator();
            while (true) {
                if (it2.hasNext()) {
                    UrlDealListener next = it2.next();
                    if (next != null && next.deal(tbPageContext, strArr) != 3) {
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
            if (!z3 && SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str2, bundle)) {
                return true;
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    public boolean dealOneLinkWithDialog(TbPageContext<?> tbPageContext, String[] strArr, boolean z, UrlWebDialogCancelListener urlWebDialogCancelListener, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{tbPageContext, strArr, Boolean.valueOf(z), urlWebDialogCancelListener, Boolean.valueOf(z2)})) == null) {
            return dealOneLinkWithDialog(tbPageContext, "", strArr, z, urlWebDialogCancelListener, z2);
        }
        return invokeCommon.booleanValue;
    }

    public int dealOneLinkWithOutJumpWebView(TbPageContext<?> tbPageContext, String[] strArr) {
        InterceptResult invokeLL;
        int deal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, tbPageContext, strArr)) == null) {
            if (strArr == null || strArr.length == 0 || FullBrowseHelper.checkAndShowFullBrowseModeDialog(tbPageContext)) {
                return 3;
            }
            String str = strArr[0];
            w58 activityLog = ActivityLog.getInstance();
            activityLog.c("scheme", "dealOneLinkWithOutJumpWebView:" + str);
            UrlSchemaHandler urlSchemaHandler = this.mHandlers.get(getSchemaKey(str));
            if (urlSchemaHandler != null) {
                urlSchemaHandler.deal(tbPageContext, getInnerParamPair(getParamStrBehindScheme(str)));
                return 0;
            }
            for (UrlDealListener urlDealListener : this.mListeners) {
                if (urlDealListener != null && (deal = urlDealListener.deal(tbPageContext, strArr)) != 3) {
                    return deal;
                }
            }
            if (!SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str, null)) {
                return 3;
            }
            return 0;
        }
        return invokeLL.intValue;
    }
}
