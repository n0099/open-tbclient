package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
/* loaded from: classes.dex */
public class AccessibilityServiceInfoCompat {
    public static final int FEEDBACK_ALL_MASK = -1;
    private static final AccessibilityServiceInfoVersionImpl IMPL;

    /* loaded from: classes.dex */
    interface AccessibilityServiceInfoVersionImpl {
        boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo);

        String getDescription(AccessibilityServiceInfo accessibilityServiceInfo);

        String getId(AccessibilityServiceInfo accessibilityServiceInfo);

        ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo);

        String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo);
    }

    /* loaded from: classes.dex */
    class AccessibilityServiceInfoStubImpl implements AccessibilityServiceInfoVersionImpl {
        AccessibilityServiceInfoStubImpl() {
        }

        @Override // android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo) {
            return false;
        }

        @Override // android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getDescription(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        @Override // android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getId(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        @Override // android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        @Override // android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    class AccessibilityServiceInfoIcsImpl extends AccessibilityServiceInfoStubImpl {
        AccessibilityServiceInfoIcsImpl() {
        }

        @Override // android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getCanRetrieveWindowContent(accessibilityServiceInfo);
        }

        @Override // android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getDescription(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getDescription(accessibilityServiceInfo);
        }

        @Override // android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getId(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getId(accessibilityServiceInfo);
        }

        @Override // android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getResolveInfo(accessibilityServiceInfo);
        }

        @Override // android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getSettingsActivityName(accessibilityServiceInfo);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityServiceInfoIcsImpl();
        } else {
            IMPL = new AccessibilityServiceInfoStubImpl();
        }
    }

    private AccessibilityServiceInfoCompat() {
    }

    public static String getId(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getId(accessibilityServiceInfo);
    }

    public static ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getResolveInfo(accessibilityServiceInfo);
    }

    public static String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getSettingsActivityName(accessibilityServiceInfo);
    }

    public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getCanRetrieveWindowContent(accessibilityServiceInfo);
    }

    public static String getDescription(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getDescription(accessibilityServiceInfo);
    }

    public static String feedbackTypeToString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (i > 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
            i &= numberOfTrailingZeros ^ (-1);
            if (sb.length() > 1) {
                sb.append(", ");
            }
            switch (numberOfTrailingZeros) {
                case 1:
                    sb.append("FEEDBACK_SPOKEN");
                    break;
                case 2:
                    sb.append("FEEDBACK_HAPTIC");
                    break;
                case 4:
                    sb.append("FEEDBACK_AUDIBLE");
                    break;
                case 8:
                    sb.append("FEEDBACK_VISUAL");
                    break;
                case 16:
                    sb.append("FEEDBACK_GENERIC");
                    break;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String flagToString(int i) {
        switch (i) {
            case 1:
                return "DEFAULT";
            default:
                return null;
        }
    }
}
