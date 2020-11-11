package com.baidu.platform.comapi.walknavi.g.d;

import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f3054a = -1;
    private static final int[] b = {500, 400, 300, 200, 100, 90, 80, 70, 60, 50, 30, 20, 10};

    /* loaded from: classes7.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final a f3056a = new a();
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(int i, int i2);
    }

    public static a a() {
        return b.f3056a;
    }

    private a() {
    }

    public void a(int i, c cVar) {
        int i2;
        int i3 = 0;
        if (i > 0 && i < 10) {
            i2 = (int) (i / 2.5d);
            if (i2 != 1) {
                if (i2 == 2) {
                    i3 = 1;
                } else {
                    i3 = i2 == 3 ? 2 : -1;
                }
            }
        } else if (i >= 10 && i < 20) {
            i2 = 1;
            i3 = 3;
        } else if (i >= 20 && i < 30) {
            i3 = 4;
            i2 = 1;
        } else if (i >= 30 && i < 50) {
            i3 = 5;
            i2 = 1;
        } else if (i >= 50 && i < 60) {
            i3 = 6;
            i2 = 1;
        } else if (i >= 60 && i < 70) {
            i3 = 7;
            i2 = 1;
        } else if (i >= 70 && i < 80) {
            i3 = 8;
            i2 = 1;
        } else if (i >= 80 && i < 90) {
            i3 = 9;
            i2 = 1;
        } else if (i >= 90 && i < 100) {
            i3 = 10;
            i2 = 1;
        } else if (i < 100) {
            i2 = 0;
            i3 = -1;
        } else {
            C0292a b2 = b(i);
            i3 = b2.f3055a;
            i2 = b2.b;
        }
        if (f3054a != i3) {
            cVar.a(i3, i2);
        }
        f3054a = i3;
    }

    private C0292a b(int i) {
        C0292a c0292a = new C0292a();
        int i2 = (i / 10) * 10;
        int i3 = 0;
        while (true) {
            if (i3 >= b.length) {
                break;
            } else if (i2 < b[i3] || i2 % b[i3] != 0) {
                i3++;
            } else {
                c0292a.f3055a = c(b[i3]);
                c0292a.b = i2 / b[i3];
                break;
            }
        }
        return c0292a;
    }

    private int c(int i) {
        if (i == 500) {
            return 15;
        }
        if (i == 400) {
            return 14;
        }
        if (i == 300) {
            return 13;
        }
        if (i == 200) {
            return 12;
        }
        if (i == 100) {
            return 11;
        }
        if (i != 90) {
            if (i == 80) {
                return 9;
            }
            if (i == 70) {
                return 8;
            }
            if (i == 60) {
                return 7;
            }
            if (i == 50) {
                return 6;
            }
            if (i == 30) {
                return 5;
            }
            if (i == 20) {
                return 4;
            }
            if (i == 10) {
                return 3;
            }
            return 0;
        }
        return 10;
    }

    public int a(int i) {
        if (i == 0 || i == 1 || i == 2) {
            return R.drawable.aiapps_openlocation_go_my_point_bg_shape;
        }
        if (i == 3) {
            return R.drawable.aiapps_openlocation_path_selector;
        }
        if (i == 4) {
            return R.drawable.aiapps_person_center_dot;
        }
        if (i == 5) {
            return R.drawable.aiapps_new_dot;
        }
        if (i == 6) {
            return R.drawable.aiapps_open_app_button_normal;
        }
        if (i == 7) {
            return R.drawable.aiapps_open_app_buttion_selector;
        }
        if (i == 8) {
            return R.drawable.aiapps_multi_custom_layout_bg;
        }
        if (i == 9) {
            return R.drawable.aiapps_no_recommend;
        }
        if (i == 10) {
            return R.drawable.aiapps_night_mode_toast_icon;
        }
        if (i == 11) {
            return R.drawable.aiapps_permission_denied;
        }
        if (i == 12) {
            return R.drawable.aiapps_menu_add_bookmarkdir_pressed;
        }
        if (i == 13) {
            return R.drawable.aiapps_menu_add_bookmarkdir;
        }
        if (i == 14) {
            return R.drawable.aiapps_open_app_button_pressed;
        }
        if (i == 15) {
            return R.drawable.aiapps_normal_toast_view_bg;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.platform.comapi.walknavi.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0292a {

        /* renamed from: a  reason: collision with root package name */
        public int f3055a;
        public int b;

        C0292a() {
        }
    }
}
