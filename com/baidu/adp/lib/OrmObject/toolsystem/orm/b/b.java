package com.baidu.adp.lib.OrmObject.toolsystem.orm.b;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes.dex */
public class b implements c {
    private Cursor mM;
    private final Set<String> mN;
    private final ContentValues values;

    public b(Cursor cursor) {
        this.mM = cursor;
        this.values = null;
        this.mN = new TreeSet();
        if (cursor != null) {
            int columnCount = cursor.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String columnName = cursor.getColumnName(i);
                if (columnName != null) {
                    this.mN.add(columnName);
                }
            }
        }
    }

    public b(ContentValues contentValues) {
        this.values = contentValues;
        this.mN = new TreeSet();
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Set<String> getKeys() {
        return this.mN;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x002c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object U(String str) {
        Object valueOf;
        Object string;
        int columnIndex = this.mM.getColumnIndex(str);
        if (columnIndex <= 0 || columnIndex >= this.mM.getColumnCount()) {
            return null;
        }
        if (0 == 0) {
            try {
                valueOf = Short.valueOf(this.mM.getShort(columnIndex));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (valueOf == null) {
                try {
                    valueOf = Integer.valueOf(this.mM.getInt(columnIndex));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (valueOf == null) {
                try {
                    valueOf = Long.valueOf(this.mM.getLong(columnIndex));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (valueOf == null) {
                try {
                    valueOf = Float.valueOf(this.mM.getFloat(columnIndex));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if (valueOf == null) {
                try {
                    valueOf = Double.valueOf(this.mM.getDouble(columnIndex));
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if (valueOf == null) {
                try {
                    string = this.mM.getString(columnIndex);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                if (string == null) {
                    try {
                        return this.mM.getBlob(columnIndex);
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        return string;
                    }
                }
                return string;
            }
            string = valueOf;
            if (string == null) {
            }
        }
        valueOf = null;
        if (valueOf == null) {
        }
        if (valueOf == null) {
        }
        if (valueOf == null) {
        }
        if (valueOf == null) {
        }
        if (valueOf == null) {
        }
        string = valueOf;
        if (string == null) {
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public void e(String str, Object obj) {
        if (str != null) {
            if (obj == null) {
                this.values.putNull(str);
            } else if (obj.getClass() == Boolean.TYPE || obj.getClass() == Boolean.class) {
                this.values.put(str, (Boolean) obj);
            } else if (obj.getClass() == Byte.TYPE || obj.getClass() == Byte.class) {
                this.values.put(str, (Byte) obj);
            } else if (obj.getClass() == byte[].class) {
                this.values.put(str, (byte[]) obj);
            } else if (obj.getClass() == Double.TYPE || obj.getClass() == Double.class) {
                this.values.put(str, (Double) obj);
            } else if (obj.getClass() == Float.TYPE || obj.getClass() == Float.class) {
                this.values.put(str, (Float) obj);
            } else if (obj.getClass() == Integer.TYPE || obj.getClass() == Integer.class) {
                this.values.put(str, (Integer) obj);
            } else if (obj.getClass() == Long.TYPE || obj.getClass() == Long.class) {
                this.values.put(str, (Long) obj);
            } else if (obj.getClass() == Short.TYPE || obj.getClass() == Short.class) {
                this.values.put(str, (Short) obj);
            } else if (obj.getClass() == String.class) {
                this.values.put(str, (String) obj);
            }
        }
    }

    @Override // com.baidu.adp.lib.OrmObject.toolsystem.orm.b.c
    public Object b(String str, Type type) {
        Object U = U(str);
        if (U != null) {
            com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c cVar = new com.baidu.adp.lib.OrmObject.toolsystem.orm.d.c(type);
            com.baidu.adp.lib.OrmObject.toolsystem.orm.c.h q = com.baidu.adp.lib.OrmObject.toolsystem.orm.d.g.q(U);
            if (q != null) {
                return q.g(cVar);
            }
            return U;
        }
        return U;
    }
}
