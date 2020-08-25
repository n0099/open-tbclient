package com.baidu.live.adp.lib.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/* loaded from: classes7.dex */
public class CloseUtil {
    public static void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    public static void close(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public static void close(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            try {
                sQLiteStatement.close();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
