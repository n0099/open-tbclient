package cn.jpush.android.d;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public final class g {
    public static Queue<cn.jpush.android.data.c> a = null;

    private static synchronized void a(Context context, String str) {
        synchronized (g.class) {
            if (context != null) {
                File filesDir = context.getFilesDir();
                if (filesDir != null) {
                    File file = new File(filesDir, str);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        }
    }

    private static synchronized <T> void a(Context context, String str, ArrayList<T> arrayList) {
        synchronized (g.class) {
            if (context != null) {
                if (arrayList != null) {
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(context.openFileOutput(str, 0));
                        objectOutputStream.writeObject(arrayList);
                        objectOutputStream.close();
                    } catch (FileNotFoundException e) {
                        f.c("MsgQueueUtils", "save Objects FileNotFoundException error:" + e.getMessage());
                    } catch (IOException e2) {
                        f.c("MsgQueueUtils", "save Objects IOException error:" + e2.getMessage());
                    }
                }
            }
        }
    }

    public static boolean a(Context context, cn.jpush.android.data.c cVar) {
        if (a == null) {
            a = new ConcurrentLinkedQueue();
            try {
                ArrayList b = b(context, "msg_queue");
                if (b != null && !b.isEmpty()) {
                    Iterator it = b.iterator();
                    while (it.hasNext()) {
                        a.offer((cn.jpush.android.data.c) it.next());
                    }
                }
            } catch (Exception e) {
                f.c("MsgQueueUtils", "init lastMsgQueue failed:" + e.getMessage());
            }
        }
        if (context == null) {
            f.c("MsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (cVar == null) {
            f.c("MsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (a.contains(cVar)) {
            return true;
        }
        if (a.size() >= 200) {
            a.poll();
        }
        a.offer(cVar);
        try {
            ArrayList b2 = b(context, "msg_queue");
            if (b2 == null) {
                b2 = new ArrayList();
            }
            if (b2.size() >= 50) {
                b2.remove(0);
            }
            b2.add(cVar);
            a(context, "msg_queue", b2);
        } catch (Exception e2) {
            f.c("MsgQueueUtils", "msg save in sp failed:" + e2.getMessage());
        }
        return false;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0020 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0022 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.io.ObjectInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.ArrayList<T>] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized <T> ArrayList<T> b(Context context, String str) {
        ObjectInputStream objectInputStream;
        Throwable th;
        ObjectInputStream objectInputStream2 = (ArrayList<T>) false;
        synchronized (g.class) {
            if (context != null) {
                ArrayList arrayList = new ArrayList();
                try {
                    objectInputStream = new ObjectInputStream(context.openFileInput(str));
                } catch (Exception e) {
                } catch (Throwable th2) {
                    objectInputStream = null;
                    th = th2;
                }
                try {
                    objectInputStream2 = (ArrayList<T>) ((ArrayList) objectInputStream.readObject());
                    try {
                        objectInputStream.close();
                    } catch (IOException e2) {
                    }
                } catch (Exception e3) {
                    objectInputStream2 = (ArrayList<T>) objectInputStream;
                    try {
                        a(context, str);
                        if (objectInputStream2 != 0) {
                            try {
                                objectInputStream2.close();
                                objectInputStream2 = (ArrayList<T>) arrayList;
                            } catch (IOException e4) {
                                objectInputStream2 = (ArrayList<T>) arrayList;
                            }
                        } else {
                            objectInputStream2 = (ArrayList<T>) arrayList;
                        }
                        return (ArrayList<T>) objectInputStream2;
                    } catch (Throwable th3) {
                        objectInputStream = objectInputStream2;
                        th = th3;
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (objectInputStream != null) {
                    }
                    throw th;
                }
            }
        }
        return (ArrayList<T>) objectInputStream2;
    }
}
