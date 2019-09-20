package com.baidu.platform.comapi.walknavi.g.c;

import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class a {
    public static int a = -1;
    private static final int[] b = {500, 400, 300, 200, 100, 90, 80, 70, 60, 50, 30, 20, 10};

    /* loaded from: classes5.dex */
    static class b {
        static final a a = new a();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i, int i2);
    }

    public static a a() {
        return b.a;
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
            C0088a b2 = b(i);
            i3 = b2.a;
            i2 = b2.b;
        }
        if (a != i3) {
            cVar.a(i3, i2);
        }
        a = i3;
    }

    private C0088a b(int i) {
        C0088a c0088a = new C0088a();
        int i2 = (i / 10) * 10;
        int i3 = 0;
        while (true) {
            if (i3 >= b.length) {
                break;
            } else if (i2 < b[i3] || i2 % b[i3] != 0) {
                i3++;
            } else {
                c0088a.a = c(b[i3]);
                c0088a.b = i2 / b[i3];
                break;
            }
        }
        return c0088a;
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
            return R.drawable.aiapps_loading_dark_image_view;
        }
        if (i == 3) {
            return R.drawable.aiapps_loading_light_image_view;
        }
        if (i == 4) {
            return R.drawable.aiapps_loading_progress_animation;
        }
        if (i == 5) {
            return R.drawable.aiapps_keyboard_delete_normal;
        }
        if (i == 6) {
            return R.drawable.aiapps_loading;
        }
        if (i == 7) {
            return R.drawable.aiapps_keyboard_number_item_selector;
        }
        if (i == 8) {
            return R.drawable.aiapps_keyboard_arrow_down;
        }
        if (i == 9) {
            return R.drawable.aiapps_keyboard_delete_selector;
        }
        if (i == 10) {
            return R.drawable.aiapps_keyboard_delete_pressed;
        }
        if (i == 11) {
            return R.drawable.aiapps_loading_progress;
        }
        if (i == 12) {
            return R.drawable.aiapps_icon_route_st;
        }
        if (i == 13) {
            return R.drawable.aiapps_icon_route_en;
        }
        if (i == 14) {
            return R.drawable.aiapps_loading_bg;
        }
        if (i == 15) {
            return R.drawable.aiapps_keyboard_non_number_item_selector;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.platform.comapi.walknavi.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0088a {
        public int a;
        public int b;

        C0088a() {
        }
    }
}
